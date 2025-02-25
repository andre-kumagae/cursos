package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");
        Path arquivosParaZipar = Paths.get("pasta/subpasta");
        zipar(arquivoZip,arquivosParaZipar);
    }

    private static void zipar(Path arquivoZip, Path arquivosParaZipar) {
        //try with resources da classe ZipOutputStream e DirectoryStream
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {
            //for each para iterar cada arquivo via Files.newDirectoryStream
            for (Path file : directoryStream) {
                //ZipOutputStream tem 4 etapas:
                //1 - pega o arquivo
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                //2 - prepara um arquivo do mesmo tipo
                zipOutputStream.putNextEntry(zipEntry);
                //3- copia o conteudo
                Files.copy(file, zipOutputStream);
                //4- fecha o arquivo
                zipOutputStream.closeEntry();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
