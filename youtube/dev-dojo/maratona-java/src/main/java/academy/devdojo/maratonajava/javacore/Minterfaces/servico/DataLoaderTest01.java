package academy.devdojo.maratonajava.javacore.Minterfaces.servico;

import academy.devdojo.maratonajava.javacore.Minterfaces.dominio.DataLoader;
import academy.devdojo.maratonajava.javacore.Minterfaces.dominio.DatabaseLoader;
import academy.devdojo.maratonajava.javacore.Minterfaces.dominio.FileLoader;

public class DataLoaderTest01 {
    public static void main(String[] args) {
        DatabaseLoader databaseLoader = new DatabaseLoader();
        FileLoader fileLoader = new FileLoader();
        databaseLoader.load();
        fileLoader.load();
        databaseLoader.remove();
        fileLoader.remove();
        databaseLoader.checkPremission();
        fileLoader.checkPremission();
        DataLoader.retrieveMaxSize(); //nao podemos instanciar objetos pela Interface.
        databaseLoader.retrieveMaxSize(); //metodo do nivel da classe, porem com comportamento diferente
    }
}
