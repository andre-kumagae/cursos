package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> nomesList = new ArrayList<>(List.of("Rimuru", "Veldora", "Hikimaru"));
        nomesList.sort(String::compareTo);
        System.out.println(nomesList);

        //Function<String, Integer> nuMStringToInteger = s -> Integer.parseInt(s);
        Function<String, Integer> nuMStringToInteger = Integer::parseInt;
        Integer num = nuMStringToInteger.apply("10");
        System.out.println(num);

        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(nomesList, "Rimuru"));


    }
}
