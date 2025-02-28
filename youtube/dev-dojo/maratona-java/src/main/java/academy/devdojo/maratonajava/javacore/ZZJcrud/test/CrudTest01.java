package academy.devdojo.maratonajava.javacore.ZZJcrud.test;

import academy.devdojo.maratonajava.javacore.ZZJcrud.service.AnimeService;
import academy.devdojo.maratonajava.javacore.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            menu();
            op = Integer.parseInt(SCANNER.nextLine());
            switch (op) {
                case 1 -> {
                    producerMenu();
                    op = Integer.parseInt(SCANNER.nextLine());
                    ProducerService.menu(op);
                }
                case 2 -> {
                    animeMenu();
                    op = Integer.parseInt(SCANNER.nextLine());
                    AnimeService.menu(op);
                }
                case 0 -> System.exit(0);
            }
        }
    }

    private static void menu() {
        System.out.println("Type the number of your operation: ");
        System.out.println("1. Producer");
        System.out.println("2. Anime");
        System.out.println("0. Exit");
    }

    private static void producerMenu() {
        System.out.println("\nType the number of your operation: ");
        System.out.printf("1. Search for a producer%n");
        System.out.printf("2. Delete a producer%n");
        System.out.printf("3. Insert a producer%n");
        System.out.printf("4. Update a producer%n");
        System.out.printf("9. Go back%n");
        System.out.print("Option: ");
    }

    private static void animeMenu() {
        System.out.println("\nType the number of your operation: ");
        System.out.printf("1. Search for an anime%n");
        System.out.printf("2. Delete an anime%n");
        System.out.printf("3. Insert an anime%n");
        System.out.printf("4. Update an anime%n");
        System.out.printf("9. Go back%n");
        System.out.print("Option: ");
    }
}
