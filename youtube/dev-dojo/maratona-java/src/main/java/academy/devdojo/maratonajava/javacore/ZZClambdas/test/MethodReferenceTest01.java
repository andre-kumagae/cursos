package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animes = new ArrayList<>(List.of(new Anime("Berserk", 25), new Anime("One Piece", 1122),new Anime("Naruto", 500), new Anime("Demon Slayer", 63), new Anime("Attack on Titans", 94)));
//        expressão lambda com 2 variaveis
        Collections.sort(animes, (a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
        System.out.println(animes);
        Collections.sort(animes, AnimeComparator::compareByTitle);
        System.out.println(animes);
        Collections.sort(animes, AnimeComparator::compareByEpisodes);
        System.out.println(animes);
    }
}
