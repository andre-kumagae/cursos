package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class DatabaseLoader implements DataLoader, DataRemover {

    @Override
    public void load() {
        System.out.println("Carregando dados do banco de dados");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados do banco de dados");
    }

    @Override
    public void checkPremission() {
        System.out.println("Checando permissões no banco de dados");
    }

    public static void retrieveMaxSize(){ //metodo do nivel da classe, porem com comportamento diferente
        System.out.println("Dentro do MasSize da classe DataBaseLoader");
    }
}
