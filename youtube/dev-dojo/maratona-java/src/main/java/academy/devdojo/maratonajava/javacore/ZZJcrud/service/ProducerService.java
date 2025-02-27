package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class ProducerService {
//    scanner estatico para uso nos metodos da classe
    private static Scanner scanner = new Scanner(System.in);
// menu chamado no main
    public static void buildMenu(int op) {
        switch (op) {
            case 1:
                findByName();
                break;
            default:
                throw new IllegalArgumentException("Not a valid option");
        }
    }

//    diferentemente do metodo em Repository, nao retorna List, pois irá imprimir no for i
    public static void findByName() {
        System.out.println("Type the name or keep empty to show all names: ");
        String name = scanner.nextLine();
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size(); i++) {
            System.out.printf("[%d] - %s%n", producers.get(i).getId(), producers.get(i).getName());
        }
    }
}
