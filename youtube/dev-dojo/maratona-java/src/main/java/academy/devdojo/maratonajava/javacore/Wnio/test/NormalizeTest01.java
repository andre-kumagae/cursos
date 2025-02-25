package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String diretorioFinal = "C:\\Users\\Andre\\git-codes\\cursos\\youtube\\dev-dojo\\maratona-java\\pasta-paths\\sub-pasta\\arquivo.txt";
        String voltarDiretorio = "../../arquivo-test.txt";
        Path path1 = Paths.get(diretorioFinal, voltarDiretorio);
        System.out.println(diretorioFinal);
        System.out.println(path1.normalize());
    }
}
