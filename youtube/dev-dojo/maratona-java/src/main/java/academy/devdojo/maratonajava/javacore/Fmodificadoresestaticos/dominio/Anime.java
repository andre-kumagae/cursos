package academy.devdojo.maratonajava.javacore.Fmodificadoresestaticos.dominio;

public class Anime {
    private String nome;
    private static int[] episodios;

    static {
        System.out.println("Bloco estático 1");
        episodios = new int[20];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
        System.out.println();
    }

    static {
        System.out.println("Bloco estático 2");
    }

    static {
        System.out.println("Bloco estático 3");
    }

    {
        System.out.println("Bloco não estático");
    }

    public Anime(String nome) {
        System.out.println("=== Construtor com 1 parâmetro de nome ===");
        this.nome = nome;
    }

    public Anime(){
        System.out.println("=== Construtor sem parâmetros ===");
        for (int episodio : episodios) {
            System.out.print(episodio + " ");
        }
        System.out.println();
    }

    public String getNome(){
        return nome;
    }

    public int[] getEpisodios(){
        return episodios;
    }
}
