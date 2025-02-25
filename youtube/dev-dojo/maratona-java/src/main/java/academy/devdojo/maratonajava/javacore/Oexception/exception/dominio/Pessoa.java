package academy.devdojo.maratonajava.javacore.Oexception.exception.dominio;
import java.io.*;

public class Pessoa {
    public void salvar() throws LoginInvalidoException, FileNotFoundException, IOException {
        System.out.println("salvando pessoa");
    }
}
