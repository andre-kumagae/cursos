package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest06 {
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
        //match utiliza Predicate para retornar um boolean
        //qualquer correspondência que atenda
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 9));
        //verifica se todos os LightNovel na lista têm um preço maior que 0. Como todos os preços são positivos, o resultado será true.
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));
        //verifica se nenhum dos LightNovel na lista tem um preço menor que 0. Como todos os preços são positivos, o resultado será true.
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0));

        // find utiliza um Optional para retornar os objeos buscados
        //achar qualquer
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).findAny().ifPresent(System.out::println);
        // achar o primeiro
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).findFirst().ifPresent(System.out::println);
        // ordenando antes de achar
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).sorted(Comparator.comparing(LightNovel::getPrice)).findFirst().ifPresent(System.out::println);
        // IntelliJ sugere que utilizemos o metodo min já para pegar o primeiro
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).min(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).sorted(Comparator.comparing(LightNovel::getPrice).reversed()).findFirst().ifPresent(System.out::println);
        // IntelliJ sugere que utilizemos o metodo max já para pegar o ultimo
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);

    }
}
