package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        //Similar à antiga criação de objeto da classe File. Aqui utilizamos da interface Path para chamar o metodo pela classe Paths
        Path path = Paths.get("pasta-paths");
        // Aqui nao precisamos criar um boolean para criarmos a pasta
        if (Files.notExists(path)) { // if para evitar mensagem de Exceção
            Path pastaDirectory = Files.createDirectory(path);
        }
        //para criacao de subpastas automaticamente, use o metodo createdirectories. Ele nao lança excecao caso exista
        path = Paths.get("pasta-paths/sub-pasta");
        Path pastaDirectories = Files.createDirectories(path);

        //criando arquivos com Files
        //utilizando a funcao de var args da aula passada
        Path newFilePath = Paths.get(path.toString(), "arquivo.txt");
        if (Files.notExists(newFilePath)) {
            Path newFile = Files.createFile(newFilePath);
        }

        //copiando arquivos
        // origem é a variavel criado anteriormente para criação do diretorio do arquivo a ser copiado
        Path source = newFilePath;
        // no destino usamos o metodo getparent da classe Paths para pegar o caminho absoluto deste arquivo. Sem ele, o programa vai entender que arquivo.txt é o arquivo pai e tentara criar uma pasta a mais (C:\Users\Andre\git-codes\cursos\youtube\dev-dojo\maratona-java\pasta-paths\sub-pasta\arquivo.txt\arquivo-renomeado.txt)
        Path target = Paths.get(newFilePath.getParent().toString(), "arquivo-renomeado.txt");
        // usamos a classe Files para cópia de arquivos. Parametro de replace para nao dar exception
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
