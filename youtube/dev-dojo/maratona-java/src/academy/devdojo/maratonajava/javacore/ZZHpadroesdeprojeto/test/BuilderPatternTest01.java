package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .firstName("William")
                .lastName("Suane")
                .userName("william-suane")
                .email("devdojo@devdojo")
                .build();
        System.out.println(person);
    }
}
