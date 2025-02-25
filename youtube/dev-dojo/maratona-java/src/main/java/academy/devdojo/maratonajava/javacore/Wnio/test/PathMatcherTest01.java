package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/teste.txt");
        Path path2 = Paths.get("pasta/subpasta/teste.bkp");
        Path path3 = Paths.get("pasta/subpasta/teste.java");
        //1 asterisco desconsidera diretorios
        matches(path1, "glob:*.txt");
        // 2 asterisco considera diretorios, porem ignorando tudo que vier antes
        matches(path1, "glob:**.txt");
        // pode ser colocado barra tbm
        matches(path2, "glob:**/*.bkp");
        //busca multipla
        matches(path1, "glob:**/*.{txt,bkp}");
        matches(path2, "glob:**/*.{txt,bkp}");
        //coringa com quantidade exata de caracteres
        matches(path3, "glob:**/*.???");
        matches(path3, "glob:**/*.????");


    }

    // metodo sobrescrito da interface PathMatcher
    private static void matches(Path path, String glob) {
        //metodo da classe FileSystems que puxa o padrão com base no Sistema operacional
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob+": "+matcher.matches(path));
    }
}
