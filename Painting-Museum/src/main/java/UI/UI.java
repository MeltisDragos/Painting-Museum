package UI;

import Domain.Entitate;
import Service.EntityService;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UI {
    private EntityService service;

    public UI(EntityService service) {
        this.service = service;
    }

    public void Meniu(){
        System.out.println();
        System.out.println("1.Afisare tablouri");
        System.out.println("2.Filtrare tablouri dupa tematica");
        System.out.println("3.Filtrare tablouri dupa tematica si celebritate peste 8");
        System.out.println("4.Cautare tablou");
        System.out.println("5.Sortare tablouri dupa titlu si pictor crescator");
        System.out.println("6.Sortare tablouri dupa tematica crescator");
        System.out.println("7.Sortatre tablouri dupa celebritate descrescator");
        System.out.println("-1.Exit");

    }

    public void run(){
        while(true){
            Meniu();
            int optiune;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dati optiune: ");
            optiune = scanner.nextInt();

             if(optiune == 1){
                Set<Entitate> set = (Set<Entitate>) service.getAll();
                set.forEach(System.out::println);
            }

            else if(optiune == 2){
                System.out.println("Dati tematica dupa care doriti filtrarea");
                String tematica = scanner.next();
                List<Entitate> filtrari = service.filterEntityByTematica(tematica);
                filtrari.forEach(System.out::println);
            }
            else if(optiune == 3){
                System.out.println("Dati tematica dupa care doriti filtrarea");
                String tematica = scanner.next();
                List<Entitate> filtrari = service.filterEntityByTematicaAndCelebritate(tematica);
                filtrari.forEach(System.out::println);
            }
            else if(optiune == 4){
                System.out.println("Dati titlul: ");
                String titlu = scanner.next();
                Set<Entitate> set = (Set<Entitate>) service.getAll();
                List<Entitate> en = set.stream()
                        .filter((x -> x.getTitlu().startsWith(titlu)))
                        .toList();
                en.forEach(System.out::println);
            }
            else if(optiune == 5){
                Set<Entitate> set = (Set<Entitate>) service.getAll();
                List<Entitate> sortByTtilu = set
                        .stream()
                        .sorted(Comparator.comparing(Entitate::getTitlu)).toList();
                sortByTtilu.forEach(x -> System.out.println(x.pctA()));
                System.out.println(" ");
                List<Entitate> sortByPictor =set
                        .stream()
                        .sorted(Comparator.comparing(Entitate::getPictor)).toList();
                sortByPictor.forEach(x-> System.out.println(x.pctA()));
            }
            else if(optiune == 6){
                Set<Entitate> set = (Set<Entitate>) service.getAll();
                List<Entitate> sortByTematica = set
                        .stream()
                        .sorted(Comparator.comparing(Entitate::getTematica)).toList();
                sortByTematica.forEach((x -> System.out.println(x.pctB())));
            }
            else if(optiune == 7){
                Set<Entitate> set = (Set<Entitate>) service.getAll();
                List<Entitate> sortByCelebritate = set
                        .stream()
                        .sorted(Comparator.comparing(Entitate::getCelebritate).reversed()).toList();
                sortByCelebritate.forEach((x -> System.out.println(x.pctC())));
            }
            else if(optiune == -1) break;
            else System.out.println("Optiune gresita! Reincercati!");
        }
    }
}
