package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest04 {
    public static void main(String[] args) {
//                forma padrão de instaciar objetos
//                AnimeComparator animeComparator = new AnimeComparator();
//        forma com a interface Supplier através de method reference
        Supplier<AnimeComparator> newAnimeComparator = AnimeComparator::new;
        AnimeComparator animeComparators = newAnimeComparator.get();
        List<Anime> animes = new ArrayList<>(List.of(new Anime("Berserk", 25), new Anime("One Piece", 1122), new Anime("Naruto", 500), new Anime("Demon Slayer", 63), new Anime("Attack on Titans", 94)));
        animes.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animes);

//        consguimos atraves desse tipo de method reference criar um objeto atraves de um construtor especifico
//        Utilizamos a Interface BiFunction. Na Function, utiliza-se 2 parametros (T, U), sendo que T entra e retorna R
//        Aqui T e U entram como parametro do construtor e retorna R, que é a classe a ser instanciada
        BiFunction<String, Integer, Anime> animeBiFunction = Anime::new;
        System.out.println(animeBiFunction.apply("Super Campeões", 52));
//        alternativa com expressa lambda
//        BiFunction<String, Integer, Anime> animeBiFunction2 = (title, episodes) -> new Anime(title, episodes);

    }
}
