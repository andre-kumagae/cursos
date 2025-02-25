package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        //ao lidar com listas, para declaramos
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());
        printConsulta(cachorros);
        printConsulta(gatos);
        List<Animal> animals = new ArrayList<>();
        printConsultaAnimals(animals);
        printConsulta(animals);
    }

    //Para aceitar qualquer filho de Animal, usamos o Wilcard "? + herança"
    //Para não ter problema de adicionar de classe filha para pai, não podemos adicionar dentro desse metodo, apenas ler
    //Independentemente de utilizar com interface ou classes abstratas, sempre usamos a palavra extends
    private static void printConsulta(List<? extends Animal> animals) {
        System.out.println("====");
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    //Para poder criar metodo de adicao no metodo, trocamos a palavra "extends" por "super". Sendo asssim, ele permite uma adicao para cima da hierarquia, até Object
    private static void printConsultaAnimals(List<? super Animal> animals) {
        System.out.println("====");
        animals.add(new Cachorro());
        animals.add(new Gato());
    }
}
