package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> stringList = List.of("Natsu", "Alucard");
        List<Integer> integers = map(stringList, s -> s.length());
        System.out.println(integers);
//        Apesar de tratarmos com tipos T e R, ambos podem ser do emsmo tipo
        List<String> maiusculo = map(stringList, s -> s.toUpperCase());
        System.out.println(maiusculo);
//        Podemos resumir ainda mais através de method references
//        sintaxe: metodo(lista, Tipo::metodo)
        List<String> maiusculoMethodReference = map(stringList, String::toUpperCase);
    }
// A Interface Function recebe um valor T e retorna o resultado R
    private static <T, R> List<R> map(List<T> list, Function<T,R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
//            Realizamos pelo metodo apply para receber o valor de T
            R r = function.apply(t);
//            E retornar o valor de resultado para R
            result.add(r);
        }
        return result;
    }
}
