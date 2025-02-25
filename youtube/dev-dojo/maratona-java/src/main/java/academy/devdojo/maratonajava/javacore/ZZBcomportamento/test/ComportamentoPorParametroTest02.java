package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;
import academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest02 {
    private static List<Car> carList = List.of(new Car("red", 2000), new Car("black", 1992), new Car("green", 2011), new Car("black", 1998), new Car("black", 2010), new Car("green", 2010), new Car("red", 2019), new Car("black", 1980), new Car("green", 2012));

    public static void main(String[] args) {
        // chamamos uma função anônima, que serve para pegar o critério sem precisar do if e já retorná-lo para o method filter
        List<Car> green = filterByCarPredicate(carList, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });
        System.out.println(green);
        //perceba que como a classe anônima só possui uma função, podemos reduzí-la a uma expressão lambda;
        //Na expressão lambda, retiramos a instaciação da interface, a assinatura do metodo sobrescrita e declaracao do unico method, pegamos e deixamos somente o parametro e retorno;
        //sintaxe: metodo(lista, variavel -> Teste desejado com essa variavel)
        //perceba que o comportamento se torna um parametro dessa estrutura
        List<Car> black = filterByCarPredicate(carList, car -> car.getColor().equals("black"));
        System.out.println(black);

        //Assim, conseguimos criar a regra de negócio em uma linha:
        List<Car> filterCarsBefore2025 = filterByCarPredicate(carList, car -> car.getYear() < 2015);
        System.out.println(filterCarsBefore2025);
        //Posso chamar direto no sout em vez de guardar em uma variável
        System.out.println(filterByCarPredicate(carList, car -> car.getColor().equals("red")));
    }

    // recebemos a interface como parâmetro
    private static List<Car> filterByCarPredicate(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    //Podemos utilizar a interface predicate que já existe no Java
    private static List<Car> filter(List<Car> cars, Predicate<Car> carPredicate) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
