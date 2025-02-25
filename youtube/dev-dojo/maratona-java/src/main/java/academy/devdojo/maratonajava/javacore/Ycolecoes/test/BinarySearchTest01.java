package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);
        // (-(ponto de inserção) -1)
        // index 0 1 2 3
        // value 0 2 3 4
        Collections.sort(numeros);
        System.out.println(Collections.binarySearch(numeros, 0));
        System.out.println(Collections.binarySearch(numeros, 2));
        System.out.println(Collections.binarySearch(numeros, 3));
        System.out.println(Collections.binarySearch(numeros, 4));
        // caso busquemos um número inexistente, irá retornar o valor abaixo:
        // - (ponto de inserção) -1
        //Ex.: 1 se estivesse na lista, estaria na posição 1, antes do 2
        // index 0 1 2 3
        // value 0 [1] 2 3 4
        // - 1 -1 = 2
        System.out.println(Collections.binarySearch(numeros, 1));
        // 5 estaria na posicao 4, após o 4
        // -4 - 1 = -4
        System.out.println(Collections.binarySearch(numeros, 5));
        System.out.println(Collections.binarySearch(numeros, 6));
        System.out.println(Collections.binarySearch(numeros, 7));
        // o -1 serve para diferenciar da busca do zero e de valores negativos
        // se não tivesse o -1, a busca de 0 e -1 daria -1
        System.out.println(Collections.binarySearch(numeros, 0));
        System.out.println(Collections.binarySearch(numeros, -1));
//        System.out.println(Collections.binarySearch(numeros, -2));
    }
}
