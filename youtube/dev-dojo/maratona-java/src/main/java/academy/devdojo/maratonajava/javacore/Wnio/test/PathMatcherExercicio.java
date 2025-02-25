package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllTestFilesWithJavaOrClassExtension extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String glob = "glob:**Test*{java,class}";
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        if (matcher.matches(file)) {
            System.out.println(file.getParent()+"\\"+file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}
public class PathMatcherExercicio {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");
        Files.walkFileTree(root, new ListAllTestFilesWithJavaOrClassExtension());
    }
}