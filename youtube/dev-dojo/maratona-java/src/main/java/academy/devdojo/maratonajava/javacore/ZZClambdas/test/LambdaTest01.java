package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {
        List<String> heroisList = List.of("William", "Suane", "Luffy", "Zoro");
        List<Integer> numerosList = new ArrayList<>();
        int numero=1;
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0) numerosList.add(i);
        }
        forEach(heroisList, s -> System.out.println(s));
        forEach(numerosList, n -> System.out.print(n+" "));
    }
//    Enquanto o Predicate retorna um boolean, a Interface Consumer receba não tem retorno. Voltado para mostrar o resultado, como por exemplo um for-each que aceita qualquer tipo com Generics:
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
