package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest01 {
    public static void main(String[] args) {
        Path absoluto = Paths.get("/home/andre");
        Path relativo = Paths.get("dev");
        Path arquivo = Paths.get("file.txt");

        System.out.println("1: " + absoluto.resolve(relativo));
        System.out.println("2: " + absoluto.resolve(arquivo));
        System.out.println("3: " + relativo.resolve(absoluto));
        System.out.println("4: " + relativo.resolve(arquivo));
        System.out.println("5: " + arquivo.resolve(absoluto));
        System.out.println("6: " + arquivo.resolve(relativo));
    }
}
