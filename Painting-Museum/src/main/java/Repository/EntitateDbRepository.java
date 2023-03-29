package Repository;

import Domain.Entitate;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class EntitateDbRepository implements Repository<Long, Entitate>{

    private String url;
    private String username;
    private String password;

    public EntitateDbRepository(String url , String username , String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    @Override
    public Optional<Entitate> findOne(Long aLong) {
        String sqlCommand = "Select * from entitate";

        try (Connection connection = DriverManager.getConnection(url, username , password);
        PreparedStatement ps = connection.prepareStatement(sqlCommand);
        ResultSet resultSet = ps.executeQuery()){

            while (resultSet.next()) {

                Long id = resultSet.getLong("id");
                String titlu = resultSet.getString("titlu");
                String pictor = resultSet.getString("pictor");
                String tematica = resultSet.getString("tematica");
                Double celebritate = resultSet.getDouble("celebritate");

                Entitate entitate = new Entitate(id, titlu, pictor, tematica , celebritate);
                if (id.equals(aLong)) return Optional.of(entitate);
            }
                return Optional.of(new Entitate("", "", null, 0.0));

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public Iterable<Entitate> findAll() {
        Set<Entitate> entitates = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from entitati");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String titlu = resultSet.getString("titlu");
                String pictor = resultSet.getString("pictor");
                String tematica = resultSet.getString("tematica");
                Double celebritate = resultSet.getDouble("celebritate");
                Entitate entitate = new Entitate(id, titlu, pictor, tematica, celebritate);
                entitate.setId(id);
                entitates.add(entitate);
            }
            return entitates;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entitates;
    }

    @Override
    public Optional<Entitate> save(Entitate entity) {
        String sql = "insert into entitate (titlu, pictor, tematica, celebritate) values (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getTitlu());
            ps.setString(2, entity.getPictor());
            ps.setString(3, entity.getTematica());
            ps.setDouble(4, entity.getCelebritate());

            ps.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            return Optional.ofNullable(entity);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Entitate> delete(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Entitate> update(Entitate entity) {
        return Optional.empty();
    }
}
