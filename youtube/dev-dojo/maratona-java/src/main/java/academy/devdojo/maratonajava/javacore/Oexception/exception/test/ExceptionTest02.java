package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest02 {
    public static void main(String[] args) throws IOException {
        criarNovoArquivo2();
    }

    private static void criarNovoArquivo() {
        File file = new File(".\\arquivo\\test.txt");
        try {
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado: " + isCriado);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problema em criar o arquivo");
        }
    }

    public static void criarNovoArquivo2() throws IOException {
        File file = new File(".\\arquivo\\test.txt");
        boolean isCriado = file.createNewFile();
        System.out.println("Arquivo criado: " + isCriado);
    }

    public static void chamaExcecao() throws IOException {
        criarNovoArquivo2();
    }
}

