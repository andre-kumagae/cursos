package academy.devdojo.maratonajava.javacore.ZZJcrud.test;

import academy.devdojo.maratonajava.javacore.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        while (true) {
            producerMenu();
//            usando parseInt para evitar excecoes de digitar caracteres diferentes de numero
            op = Integer.parseInt(SCANNER.nextLine());
            if (op == 0) break;
            ProducerService.buildMenu(op);
        }
    }

    private static void producerMenu() {
        System.out.println("\nType the number of your operation: ");
        System.out.printf("1. Search for a producer%n");
        System.out.printf("2. Delete a producer%n");
        System.out.printf("3. Insert a producer%n");
        System.out.printf("4. Update a producer%n");
        System.out.printf("0. Exit%n");
        System.out.print("Option: ");
    }
}
