package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {
    private static List<Car> carList = List.of(new Car("red", 2000), new Car("black", 1992), new Car("green", 2011), new Car("black", 1998), new Car("black", 2010), new Car("green", 2010), new Car("red", 2019), new Car("black", 1980), new Car("green", 2012));

    public static void main(String[] args) {
        //(expressao -> <expressao que que retorna boolean>)
        //(Car car) -> car.getColor().equals("green")
       List<Car> black = genericFilter(carList, car -> car.getColor().equals("black"));
        System.out.println(black);
        List<Car> filterCarsBefore2025 = genericFilter(carList, car -> car.getYear() < 2015);
        System.out.println(filterCarsBefore2025);
        System.out.println(genericFilter(carList, car -> car.getColor().equals("red")));
        //A vantagem de trabalhar com generics é que podemos reutilizar para qualquer lista
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //perceba que a variavel na expressao lambda pode ter qualquer nome
        System.out.println(genericFilter(nums, par -> par % 2 == 0));
        List<String> palavras = List.of("amora", "banana", "jaboticaba", "abacaxi", "agua");
        System.out.println(genericFilter(palavras, comecaComA -> comecaComA.toLowerCase().startsWith("a")));
    }


    //Podemos utilizar a interface predicate que já existe no Java
    private static <T> List<T> genericFilter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }
}
