package academy.devdojo.maratonajava.javacore.ZZGconcorrencia;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteTes01 {
    public static void main(String[] args) {
    /*ao adicionar valores, esta classe cria listas novas
    [1]
    [1,2] = lista diferente
    [1] para remover tambem cria uma lista nova
     */
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 2000; i++) {
            list.add(i);
        }
        Runnable runnableIterator = () -> {
//            Iterator mantem uma cópia do conteúdo original
            Iterator<Integer> iterator = list.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnableRemover = () -> {
            for (int i = 0; i < 500; i++) {
                list.remove(0);
                System.out.printf("%s removed %d%n", Thread.currentThread().getName(), i);
            }
        };
        new Thread(runnableIterator).start();
        new Thread(runnableIterator).start();
        new Thread(runnableRemover).start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
    }
}
