package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");
        //metodo convencional para iterar letra a letra do primeiro item
        String[] letters = words.get(0).split("");
        System.out.println(Arrays.toString(letters));

        // perceba que fazendo via map, temos um List<String[]> (Um list de array de strings)
        //como podemos ver, o metodo que dividimos o primeiro item retorna um Array de Strings
        //String[] letters1 = letters;
        List<String[]> collect = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        // Queremos um Stream<String> para depois utilizarmos o Collectors.toList e transform-la em um List<String>;
        // O metodo para fazer esta primeira conversão é o Array.stream;
        Stream<String> stream = Arrays.stream(letters);
        // Para funcionar devidamente em um array multi-dimensional, aplicamos este metodo dentro do flatMap
        List<String> letters2 = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(letters2);
    }
}
