package academy.devdojo.maratonajava.testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Pessoa implements Comparable<Pessoa> {
    String nome;
    int idade;

    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return nome + " - " + idade + " anos";
    }

    @Override
    public int compareTo(Pessoa outra) {
        return Integer.compare(this.idade, outra.idade);
    }

    // Método estático para ordenar uma lista de pessoas por idade
    public static void sort(List<Pessoa> pessoas) {
        pessoas.sort(null); // Utiliza o método sort da interface List
    }
}

public class Testes {
    public static void main(String[] args) {
        List<ShounenManga> shounen = new ArrayList<>();
        List<Manga> manga = new ArrayList<>();
        Collections.sort(shounen);
        Collections.sort(manga);
        double dias=100;
        double dia=0;
        int idade=19;
        String maior = idade > 18 ? "Maior" : "Menor";
        System.out.println(maior);
        String result;
//        for (int i = 1; i <= 7; i++) {
//            dia = (dias/7)*i;
//            System.out.print("Dia "+i+": ");
//            System.out.printf("%.2f", dia);
//            System.out.println("%");
//        }

        for (int i = 1; i <= 7; i++) {
            dia = (dias/7)*i;
            //System.out.print("Day "+i+": ");
            System.out.println("Day "+i);
            System.out.println();
            //result = String.format(java.util.Locale.US,"%.2f", dia);
            //System.out.println(result+"%");

            Teste teste = new Teste("Joao", 12, 300, 'M');
            System.out.println(teste);
            Integer inteiros = 1;
        }
    }
}
