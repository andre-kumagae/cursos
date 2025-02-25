package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// classe filha de SimpleFileVisitor
class ListJavaFiles extends SimpleFileVisitor<Path> {
    // sobrescrita de metodo de SimpleFileVisitor que retorna um ENUM FileVisitResult
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith("java")) {
            System.out.println(file.getFileName());
        }
        // CONTINUE segue iterando as subpastas
        return FileVisitResult.CONTINUE;
    }
}

public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");
        //metodo da classe Files que roda atraves de um objeto que extende a classe SimpleFileVisitor
        Files.walkFileTree(root, new ListJavaFiles());
    }
}
