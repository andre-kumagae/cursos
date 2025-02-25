package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.List;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        //somando
        integers.stream().reduce((x, y) -> x + y).ifPresent(System.out::println);
        integers.stream().reduce((x, y) -> x + y).ifPresent(System.out::println);
        //para soma, há o methor reference de Integer
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        //argumento identity já coloca um valor inicial à soma. No exemplo soma 2 + os nuemros do arraylist;
        // como não vai dar vazio, não precisa de passar pela validacao do optional
        System.out.println(integers.stream().reduce(2, (x, y) -> x + y));

        integers.stream().reduce((x, y) -> x - y).ifPresent(System.out::println);
        integers.stream().reduce((x, y) -> x * y).ifPresent(System.out::println);
        List<Double> doubles = List.of(1d, 2d, 3d, 4d, 5d, 6d);
        doubles.stream().reduce((x, y) -> x / y).ifPresent(System.out::println);

        // validacao de maior e menor
        integers.stream().reduce((x, y) -> x > y ? x : y).ifPresent(System.out::println);
        integers.stream().reduce((x, y) -> x < y ? x : y).ifPresent(System.out::println);
        // tbm há method reference para eles
        integers.stream().reduce(Integer::max).ifPresent(System.out::println);
        integers.stream().reduce(Integer::min).ifPresent(System.out::println);
    }
}
