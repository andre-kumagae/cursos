package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public interface DataLoader {
    public static final int MAX_DATA_SIZE = 10; //palavras redundantes pois toda variável na Interface é uma constante
    public abstract void load();

    default void checkPremission(){
        System.out.println("Fazendo checagem de permissões");
    }

    public static void retrieveMaxSize(){ // métodos estáticos são do nível da Classe, não permitindo override
        System.out.println("Dentro do MaxSize da Interface");
    }
}
