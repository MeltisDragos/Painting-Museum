package Service;

import Domain.Entitate;
import Domain.Entity;
import Repository.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EntityService {
    private Repository<Long , Entitate> repo;
    public EntityService(Repository<Long , Entitate> repo){
        this.repo = repo;
    }
    public Iterable<Entitate> getAll(){
        return  repo.findAll();
    }
    public Entitate addEntitate(Entitate e){
        repo.save(e);
        return e;
    }

    public List<Entitate> filterEntityByTematica(String tematica){
        Set<Entitate> entitate = (Set<Entitate>) repo.findAll();
        List<Entitate> filtrare = entitate.stream().filter(x-> Objects.equals(x.getTematica(),tematica)).collect(Collectors.toList());
        return filtrare;
    }

    public List<Entitate> filterEntityByTematicaAndCelebritate(String tematica){
        Set<Entitate> entitate = (Set<Entitate>) repo.findAll();
        List<Entitate> filtrare = entitate.stream().filter(x-> Objects.equals(x.getTematica(), tematica) && x.getCelebritate() > 8.0).collect(Collectors.toList());
        return filtrare;
    }
}
