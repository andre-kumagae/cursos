package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest01 {
    public static void main(String[] args) {
        // acessa a pasta atual do projeto
        Path dir = Paths.get(".");
        // usando um try with resources para iniciar DirectoryStream e fechá-la ao final da iteracao
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            // iterando cada diretorio
            for (Path path : stream) {
                // printando o nome de cada um
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
