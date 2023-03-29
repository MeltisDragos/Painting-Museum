import Domain.Entitate;
import Repository.Repository;
import Repository.EntitateDbRepository;
import Service.EntityService;
import UI.UI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reading data from file");
        String username = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://localhost:5432/examen";
        Repository<Long, Entitate> EntitateRepository = new EntitateDbRepository(url, username, password);
        EntityService service = new EntityService(EntitateRepository);

        UI console = new UI(service);
        console.run();
    }
}