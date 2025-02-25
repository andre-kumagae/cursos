package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("C:\\Users\\Andre\\git-codes\\cursos\\youtube\\dev-dojo\\maratona-java\\file.txt");
        Path pathArquivo = Paths.get("C:\\Users\\Andre\\git-codes\\cursos\\youtube\\dev-dojo\\maratona-java","file.txt");
        Path pathDisco = Paths.get("C:","Users\\Andre\\git-codes\\cursos\\youtube\\dev-dojo\\maratona-java","file.txt");
        Path pathPastas = Paths.get("C:","Users","Andre","git-codes","cursos","youtube","dev-dojo","maratona-java","file.txt");
        System.out.println(path1);
        System.out.println(path1.getFileName());
        System.out.println(pathArquivo.getFileName());
        System.out.println(pathDisco.getFileName());
        System.out.println(pathPastas.getFileName());
    }
}
