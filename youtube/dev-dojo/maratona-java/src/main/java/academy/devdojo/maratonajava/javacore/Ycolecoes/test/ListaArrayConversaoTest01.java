package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        //convertendo um ArrayList para um Arrray convencional
        //chamando indice zero é mais rapido do que new Integer[numeros.size]
        Integer[] integerListToArrayList = numeros.toArray(new Integer[0]);
        System.out.println("integerListToArrayList = " + Arrays.toString(integerListToArrayList));

        //convertendo de volta via metodo asList da classe Arrays
        List<Integer> arrayListToIntegerList = Arrays.asList(integerListToArrayList);
        System.out.println("arrayListToIntegerList = " + arrayListToIntegerList);
        //o problema é que este metodo cria uma conexão com o array original
        //veja que se alterarmos um numero, iremos alterar dos dois
        //no indice 0, mude para 12
        arrayListToIntegerList.set(0, 12);
        System.out.println("integerListToArrayList = " + Arrays.toString(integerListToArrayList));
        System.out.println("arrayListToIntegerList = " + arrayListToIntegerList);
        //por esse link, metodos de Collections como add geram exception
        //arrayListToIntegerList.add(2); //Exception in thread "main" java.lang.UnsupportedOperationException

        //a solução é criar chamar esse metodo dentro do construtor de ArrayList
        List<Integer> arrayToList2 = new ArrayList<>(Arrays.asList(integerListToArrayList));
        //agora os metodos irao funcionar
        System.out.println("arrayToList2 = " + arrayToList2);
        arrayToList2.add(8);
        System.out.println("arrayToList2 = " + arrayToList2);
        //nao ha link mais entre eles
        System.out.println("integerListToArrayList = " + Arrays.toString(integerListToArrayList));
        arrayToList2.remove(2);
        System.out.println("arrayToList2 = " + arrayToList2);

        //Além de poder converter Listas para ArrayList, esse metodo permite adicionar varios valores de uma vez por ser um var args
        List<Integer> addArrayList = Arrays.asList(4, 5, 6);
        System.out.println("addArrayList = " + addArrayList);
        //A partir do Java 11, podemos utilizar List,of:
        List<Integer> addArrayList2 = List.of(1, 2, 3);
        System.out.println("addArrayList2 = " + addArrayList2);
        //a vantagem é que funciona com String
        List<String> addArrayListString = List.of("4", "5", "6");
        System.out.println("addArrayListString = " + addArrayListString);


        List<Integer> numeros2 = new ArrayList<>();
        numeros2.add(1);
        numeros2.add(2);
        numeros2.add(3);
        Integer[] integerListToArrayList2 = numeros.toArray(new Integer[0]);
        integerListToArrayList2[2] = 5;
        System.out.println(numeros2);
        System.out.println("numeros2 = " + numeros2);
        System.out.println("integerListToArrayList2 = " + Arrays.toString(integerListToArrayList2));

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        // Converte List<Integer> para int[]
        int[] intArray = listToIntArray(integerList);

        // Imprime o array
        for (int i : intArray) {
            System.out.print(i + " ");
        }
    }

    public static int[] listToIntArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
