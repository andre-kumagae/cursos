package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamTest15 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 10.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game no life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect);
        System.out.println("===========");
        for (Map.Entry<Category, DoubleSummaryStatistics> categoryDoubleSummaryStatisticsEntry : collect.entrySet()) {
            System.out.println(categoryDoubleSummaryStatisticsEntry.getKey());
            System.out.println(categoryDoubleSummaryStatisticsEntry.getValue());
        }
        System.out.println("===========");

        // para criamos um agrupamento Map<Category, List<Promotion>>, podemos utilizar no lugar do 2º groupingBy, o metodo mapping
        // ele age parecido com o map que utilizamos como metodo intermediario, onde convertiamos com method conference. ex.: .map(LightNovel::getTitle)
        // o que muda aqui é que adicionamos qual é o tipo de List de saída
        Map<Category, List<Promotion>> groupByCategorytoList = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toList())));
        Map<Category, Set<Promotion>> groupByCategorytoHashSet = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toSet())));
        Map<Category, LinkedHashSet<Promotion>> groupByCategorytoLinkedHashSet = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toCollection(LinkedHashSet::new))));
        System.out.println(groupByCategorytoList);
        System.out.println("=====");
        System.out.println(groupByCategorytoHashSet);
        System.out.println("=====");
        Map<Category, Long> collectTest = lightNovels.stream().collect(Collectors.groupingBy(
                LightNovel::getCategory,
                Collectors.mapping(StreamTest15::getPromotion, Collectors.counting())
        ));
    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}