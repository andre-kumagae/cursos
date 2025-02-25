package academy.devdojo.maratonajava.javacore.Dconstrutores.test;

import academy.devdojo.maratonajava.javacore.Dconstrutores.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
    Anime anime = new Anime("Haikyuu", "TV", 85, "Esporte");
    anime.imprime();
    Anime anime2 = new Anime("Naruto Shippuuden", "TV", 500, "Ação", "Pierrot");
    anime2.imprime();
    }
}
