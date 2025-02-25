package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileWriter fileWriter = new FileWriter(file);){
            fileWriter.write("O DevDojo é lindo, é o melhor curso do Brasilllllllll \uD83C\uDFB5\nContinuando a cantoria na próxima linha\uD83C\uDFB5 ");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
