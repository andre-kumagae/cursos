package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest11 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet EvergardenShittara", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));
    public static void main(String[] args) {
        // count
        System.out.println(lightNovels.stream().count());
        // max
        lightNovels.stream().max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);
        // sum
        System.out.println(lightNovels.stream().mapToDouble(LightNovel::getPrice).sum());
        // average
        lightNovels.stream().mapToDouble(LightNovel::getPrice).average().ifPresent(System.out::println);

        //com metodo collect
        // count
        System.out.println(lightNovels.stream().collect(Collectors.counting()));
        // max
        lightNovels.stream().collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))).ifPresent(System.out::println);
        // sum
        System.out.println(lightNovels.stream().collect(Collectors.summingDouble(LightNovel::getPrice)));
        // avg
        System.out.println(lightNovels.stream().collect(Collectors.averagingDouble(LightNovel::getPrice)));

        //Com collect, conseguimos fazer tudo isso com summarizing
        System.out.println(lightNovels.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice)));
        // Conseguimos extrair Strings e imprimí-las com delimitadores
        System.out.println(lightNovels.stream().map(LightNovel::getTitle).collect(Collectors.joining(", ")));
    }
}
