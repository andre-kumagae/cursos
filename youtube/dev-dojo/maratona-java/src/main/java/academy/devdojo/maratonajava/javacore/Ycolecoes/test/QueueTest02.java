package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        //Para adicionar objetos em uma Queue, necessário Comparable ou Comparator
//        Consumidor consumidor = new Consumidor("William Suane");
//        Queue<Consumidor> consumidorQueue = new PriorityQueue<>();
//        consumidorQueue.add(consumidor);

        // reverter a ordem para descendente
        Queue<Manga> mangaQueue = new PriorityQueue<>(new MangaByPrecoComparator().reversed());
        mangaQueue.add(new Manga(2L, "Hellsing Ultimate", 9.5));
        mangaQueue.add(new Manga(5L, "Attack on titans", 2.99));
        mangaQueue.add(new Manga(3L, "Pokemon", 3.2));
        mangaQueue.add(new Manga(4L, "Dragon Ball Z", 11.20));
        mangaQueue.add(new Manga(1L, "Berserk", 19.9));

        while (!mangaQueue.isEmpty()) {
            System.out.println(mangaQueue.poll());
        }
    }
}
