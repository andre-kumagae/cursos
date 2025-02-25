package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion.*;

public class StreamTest13 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 3.99, Category.FANTASY),
            new LightNovel("Violet EvergardenShittara", 5.99, Category.DRAMA),
            new LightNovel("No Game no life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        // conseguimos realizar o groupingBy de enumerates que não estão como atributos na classe
        Map<Promotion, List<LightNovel>> collect = lightNovels.stream().collect(Collectors.groupingBy(StreamTest13::getPromotion));
        for (Map.Entry<Promotion, List<LightNovel>> promotionListEntry : collect.entrySet()) {
            System.out.println(promotionListEntry.getKey());
            System.out.println(promotionListEntry.getValue());
        }

        // metodo groupingBy aceita 2 critérios de agrupamento

        // extracao de metodo
        // Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(ln -> getPromotion(ln)));
        // conversao de expressao lambda para method reference
        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(
                StreamTest13::getPromotion)));
        System.out.println("================");
        for (Map.Entry<Category, Map<Promotion, List<LightNovel>>> categoryMapEntry : collect1.entrySet()) {
            System.out.println(categoryMapEntry.getKey());
            System.out.println(categoryMapEntry.getValue());
        }

        // versão do groupingBy na função anônima
        Map<Category, Map<Promotion, List<LightNovel>>> collect2 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(
                ln -> ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE
        )));
    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
    }
}