package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest12 {
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
        //Criando um Map para dividir por categorias de nosso Enumerate

        //metodo sem stream
        Map<Category, List<LightNovel>> categoryListMap = new HashMap<>();
        List<LightNovel> fantasyList = new ArrayList<>();
        List<LightNovel> dramaList = new ArrayList<>();
        List<LightNovel> romanceList = new ArrayList<>();

        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()) {
                case FANTASY: fantasyList.add(lightNovel); break;
                case DRAMA: dramaList.add(lightNovel); break;
                case ROMANCE: romanceList.add(lightNovel); break;
            }
        }
        categoryListMap.put(Category.FANTASY, fantasyList);
        categoryListMap.put(Category.DRAMA, dramaList);
        categoryListMap.put(Category.ROMANCE, romanceList);
        System.out.println(categoryListMap);
        for (Map.Entry<Category, List<LightNovel>> categoryListEntry : categoryListMap.entrySet()) {
            System.out.println(categoryListEntry.getKey() + " / " + categoryListEntry.getValue());
        }
        System.out.println("====================");
        //com stream e collectors.groupinBy
        Map<Category, List<LightNovel>> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(collect);
        for (Map.Entry<Category, List<LightNovel>> categoryListEntry2 : collect.entrySet()) {
            System.out.println(categoryListEntry2.getKey() + " / " + categoryListEntry2.getValue());
        }

    }
}
