package academy.devdojo.maratonajava.javacore.Oexception.exception.dominio;

public class Leitor1 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Fechandor o leitor 1");
    }
}
