package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparator;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparator animeComparator = new AnimeComparator();
        List<Anime> animes = new ArrayList<>(List.of(new Anime("Berserk", 25), new Anime("One Piece", 1122),new Anime("Naruto", 500), new Anime("Demon Slayer", 63), new Anime("Attack on Titans", 94)));
        animes.sort(animeComparator::compareByEpisodesNonStatic);
        System.out.println(animes);
//        lambda
        animes.sort((a1, a2) -> animeComparator.compareByEpisodesNonStatic(a1,a2));
    }
}
