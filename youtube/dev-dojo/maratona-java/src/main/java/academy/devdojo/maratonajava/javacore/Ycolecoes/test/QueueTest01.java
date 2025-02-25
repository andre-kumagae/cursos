package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("E");
        fila.add("A");
        fila.add("B");
        fila.add("D");
        // não printa ordenado
        for (String s : fila) {
            System.out.print(s+" ");
        }
        System.out.println();
        // se utilizarmos o metodo poll que remove o cabeça, ele retorna a remoção de forma ordenada
        //tb funciona com remove
        while (!fila.isEmpty()) {
            System.out.print(fila.poll()+" ");
            //System.out.print(fila.remove()+" ");
        }
        System.out.println();
        System.out.println(fila);
    }
}
