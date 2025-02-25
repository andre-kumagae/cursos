package academy.devdojo.maratonajava.javacore.Oexception.exception.dominio;

public class Leitor2 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Fechando o leitor 2");
    }
}
