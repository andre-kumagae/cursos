package academy.devdojo.maratonajava.javacore.ZZJcrud.test;

import academy.devdojo.maratonajava.javacore.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        while (true) {
            producerMenu();
            op = Integer.parseInt(scanner.nextLine());
            if (op == 0) break;
            ProducerService.buildMenu(op);
        }
    }

    private static void producerMenu() {
        System.out.println("Type the number of your operation: ");
        System.out.printf("1. Search for producer%n");
        System.out.printf("0. Exit%n");
        System.out.print("Option: ");
    }
}
