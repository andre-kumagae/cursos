package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Set;

public class PosixFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        // só roda no ubuntu
        Path path = Paths.get("/home/kuma/dev/teste.txt");
        //Path path = Paths.get("\\\\wsl.localhost\\Ubuntu-22.04\\home\\kuma\\dev\\teste.txt");
        // similar as classes passadas, cria um obejto para manipular permissoes
        PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
        // printa permissoes do arquivo
        System.out.println(posixFileAttributes.permissions());
        // idem as classes passadas para alterar permissoes
        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        // cria um set com comando de alteracao de permissoes
        Set<PosixFilePermission> posixFilePermission = PosixFilePermissions.fromString("rw-rw-rw-");
        System.out.println(posixFilePermission);
        fileAttributeView.setPermissions(posixFilePermission);
        System.out.println(fileAttributeView.readAttributes().permissions());
    }
}
