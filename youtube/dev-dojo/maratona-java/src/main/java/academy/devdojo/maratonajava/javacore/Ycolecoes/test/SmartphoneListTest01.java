package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        Smartphone smartphone1 = new Smartphone("1ABC1", "iPhone");
        Smartphone smartphone2 = new Smartphone("222", "Pixel");
        Smartphone smartphone3 = new Smartphone("333", "Samsung");
        // add objeto na lista
        List<Smartphone> smartphones = new ArrayList<>(6);
        smartphones.add(smartphone1);
        smartphones.add(smartphone2);
        smartphones.add(smartphone3);
        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone);
        }
        Smartphone smartphone4 = new Smartphone("222", "Pixel");
        //metodo contains utiliza o metodo equals
        System.out.println(smartphones.contains(smartphone4));
        //metodo de busca por indice pela primeira correspondencia
        System.out.println(smartphones.indexOf(smartphone4));
        //adicionado em um indice desejado
        smartphones.remove(2);
        smartphones.add(0, smartphone3);
        System.out.println(smartphones.indexOf(smartphone3));

        //caso contains nao encontre, retorna -1
        smartphone4 = new Smartphone("2111122", "Pixel");
        boolean indicePixel = smartphones.contains(smartphone4);
        System.out.println(indicePixel);

        //metodo get pode retornar fora do for com base em um indice. É basicamente o que o for faz em uma interação
        int indiceIphone = smartphones.indexOf(smartphone1);
        System.out.println(smartphones.get(indiceIphone));

        String nome = "William Suane";
        System.out.println("nome = " + nome);
    }
}
