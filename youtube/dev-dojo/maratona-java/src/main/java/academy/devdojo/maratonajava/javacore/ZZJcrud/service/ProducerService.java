package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

import java.util.Scanner;

public class ProducerService {
    //    scanner estatico para uso nos metodos da classe
    private static final Scanner SCANNER = new Scanner(System.in);

    // menu chamado no main
    public static void buildMenu(int op) {
//        substituido para o enhanced switch
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            default -> throw new IllegalArgumentException("Not a valid option");
        }
    }

    //    diferentemente do metodo em Repository, nao retorna List, pois irá imprimir no for i
    private static void findByName() {
        System.out.println("Type the name or keep empty to show all names: ");
        String name = SCANNER.nextLine();
//        juntado 2 declaracoes em uma, aplicando expressao lambda
        ProducerRepository.findByName(name)
                .forEach(p -> System.out.printf("[%d] - %s%n", p.getId(), p.getName()));
    }

    private static void delete() {
        System.out.println("Type the id of the producer you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            ProducerRepository.delete(id);
        }
    }

    public static void save() {
        System.out.println("Type the name of the producer you want to insert");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }
}
