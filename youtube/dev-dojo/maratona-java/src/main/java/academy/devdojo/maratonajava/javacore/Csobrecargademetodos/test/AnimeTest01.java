package academy.devdojo.maratonajava.javacore.Csobrecargademetodos.test;

import academy.devdojo.maratonajava.javacore.Csobrecargademetodos.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        //através de getter e setters
        Anime anime = new Anime();
        anime.setTipo("TV");
        anime.setEpisodios(94);
        anime.setNome("Attack on Titans");
        anime.imprime();

        //através de metodo
        Anime anime2 = new Anime();
        anime2.init("One Piece", "TV", 1122);
        anime2.imprime();

        //atraves de sobrecarga de metodo
        Anime anime3 = new Anime();
        anime3.init("Demon Slayer", "TV", 63, "Ação");
        anime3.imprime();
    }
}
