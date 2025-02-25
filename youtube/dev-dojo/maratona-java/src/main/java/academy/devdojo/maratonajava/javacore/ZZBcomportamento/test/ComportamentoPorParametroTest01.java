package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Car> carList = List.of(new Car("red", 2000), new Car("black", 1992), new Car("green", 2011), new Car("black", 1998), new Car("black", 2010), new Car("green", 2010), new Car("red", 2019), new Car("black", 1980), new Car("green", 2012));

    public static void main(String[] args) {
        System.out.println(filterGreenCars(carList));
        System.out.println(filterCarsByColor(carList, "black"));
        System.out.println(filterCarsByColor(carList, "white"));
        System.out.println(filterCarsByColor(carList, "red"));
        System.out.println(filterCarsByAgeBefore(carList, 2015));
    }

    private static List<Car> filterGreenCars(List<Car> cars) {
        List<Car> greenCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("green")) {
                greenCars.add(car);
            }
        }
        return greenCars;
    }

    private static List<Car> filterCarsByColor(List<Car> cars, String color) {
        List<Car> filteredCarList = new ArrayList<>();
        System.out.println("Filtering cars with the color: " + color);
        for (Car car : cars) {
            if (car.getColor().equals(color)) {
                filteredCarList.add(car);
            }
        }
        return filteredCarList;
    }

    private static List<Car> filterCarsByAgeBefore(List<Car> cars, int year) {
        List<Car> filteredCarList = new ArrayList<>();
        System.out.println("Filtering cars before: " + year);
        for (Car car : cars) {
            if (car.getYear() < year) {
                filteredCarList.add(car);
            }
        }
        return filteredCarList;
    }
}
