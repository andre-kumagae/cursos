package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        //BasicFileAttributes, DosFileAttributes, PosixFileAttributes
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        File file = new File("pasta2/novo.txt");
        boolean isCreated = file.createNewFile();
        // editar data de modificacao
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(date.toInstant(ZoneOffset.UTC));
        System.out.println(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        Path path = Paths.get("pasta2/novo_path.txt");
        //Files.createFile(path);
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path,fileTime);
        System.out.println(fileTime);
        // editar permissoes de acesso
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isExecutable(path));
    }
}
