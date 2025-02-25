package academy.devdojo.maratonajava.javacore.Eblocosdeinicializacao.test;

import academy.devdojo.maratonajava.javacore.Eblocosdeinicializacao.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("DBZ");
        System.out.println(anime.getNome());


        for (int episodio : anime.getEpisodios()) {
            System.out.print(episodio+ " ");
        }
        System.out.println();

        Anime anime2 = new Anime();
        System.out.println(anime2.getNome());
    }
}
