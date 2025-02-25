package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDiretorio = new File("pasta");
        boolean isDiretorioCriado = fileDiretorio.mkdir();
        System.out.println(isDiretorioCriado);
        //caminho absoluto
        File fileArquivoDiretorio = new File("C:\\Users\\Andre\\git-codes\\cursos\\youtube\\dev-dojo\\maratona-java\\pasta\\arquivo.txt");
        boolean isFileCreated = fileArquivoDiretorio.createNewFile();
        System.out.println(isFileCreated);
        //referencia do diretorio
        File fileArquivoDiretorio2 = new File(fileDiretorio, "arquivo2.txt");
        boolean isFileCreated2 = fileArquivoDiretorio2.createNewFile();
        System.out.println(isFileCreated2);
        //renomeando na mesma pasta
        File remanedFile = new File(fileDiretorio, "arquivo_renomeado.txt");
        boolean isRenamedFile = fileArquivoDiretorio.renameTo(remanedFile);
        System.out.println(isRenamedFile);

        //renomeando pasta
        File renamedFolder = new File("pasta-renomeada");
        boolean isRenamedFolder = fileDiretorio.renameTo(renamedFolder);
        System.out.println(isRenamedFolder);
    }
}
