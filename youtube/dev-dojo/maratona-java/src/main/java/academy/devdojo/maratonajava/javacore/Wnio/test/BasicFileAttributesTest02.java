package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta2/novo.txt");
        // a interface BasicFilesAttributes vai servir para utilizar o metodo readAttributes da classe Files, que pega o path e nos retorna a classe criada, no caso do tipo BasicFileAttributes
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);


        // variaveis que servem como getters de datas de criacao, modificacao e acesso
        // como vamos usar estes valores abaixo, guardamos em variaveis
        // a classe FileTime nos serve para utilizar os metodos de leitura dos arquivos pela primeira vez.
        // Perceba que nesse caso usamos o metodo do objeto da interface BasicFileAttributes
        FileTime creationTime = basicFileAttributes.creationTime();
        /* perguntas respondidas
        pq nao posso chamar por FileTime.creationTime()?
        pq ela é private, sendo necessaria a utilizacao de outro objeto
        pq FileTime nao e interface?
        pe ela precisa de variaveis em vez de constantes
         */
        System.out.println("creationTime = " + creationTime);
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        System.out.println("lastModifiedTime = " + lastModifiedTime);
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        System.out.println("lastAccessTime = " + lastAccessTime);
        System.out.println("=====================");
        // perceba que esta interface é similar à BasicFileAttributes. A diferença é que usamos ela para modificar os atributos
        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        // criamos uma variavel para puxar a data atual do sistema em milisegundos
        // aqui podemos inataciar da propria classe pois é o metodo dela que queremos
        FileTime newTime = FileTime.fromMillis(System.currentTimeMillis());

        // setter das datas acima
        basicFileAttributeView.setTimes(newTime,newTime,newTime);

        // apesar de termos mudados as datas, precisamos chamar o metodo readAttributeViews em cada variavel

        creationTime = basicFileAttributeView.readAttributes().creationTime();
        System.out.println("creationTime = " + creationTime);
        lastModifiedTime = basicFileAttributeView.readAttributes().lastModifiedTime();
        System.out.println("lastModifiedTime = " + lastModifiedTime);
       lastAccessTime = basicFileAttributeView.readAttributes().lastAccessTime();
        System.out.println("lastAccessTime = " + lastAccessTime);

    }
}
