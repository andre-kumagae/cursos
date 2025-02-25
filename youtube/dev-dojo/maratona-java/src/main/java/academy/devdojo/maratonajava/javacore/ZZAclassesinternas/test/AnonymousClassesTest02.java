package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.Comparator;
import java.util.List;

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        List<Barco> barcoList = List.of(new Barco("Lancha"), new Barco("Canoa"));
//        A classe anonima também funciona dentro da assinatura de methods
//        o method sort recebe um comparator. Em vez de criar em uma classe a parte, podemos declarar dentro do parametro
        barcoList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
//        podemos utilizar também via expressão lambda
        barcoList.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
    }
}
