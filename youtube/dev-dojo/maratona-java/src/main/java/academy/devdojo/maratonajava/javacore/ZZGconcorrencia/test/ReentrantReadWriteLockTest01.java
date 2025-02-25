package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite {
//    criando um Map para leitura e escrita
    private final Map<String, String> map = new LinkedHashMap<>();
//    usando a classe para o construtor e metodo put e get (allKeys)
    private final ReentrantReadWriteLock rwl;
// como map ja tem valor e é final, nao pode inserir no construtor
    public MapReadWrite(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void put(String key, String value) {
        rwl.writeLock().lock();
        try {
            if (rwl.isWriteLocked()) {
                System.out.printf("%s obteve o WRITE LOCK%n", Thread.currentThread().getName());
            }
            map.put(key, value);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public Set<String> allKeys() {
        rwl.readLock().lock();
        try{
            return map.keySet();
        }finally {
            rwl.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {
//        instanciamos a classe
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
//        utilizamos como parametro para a nossa classe ReadWriteLock
        MapReadWrite mapReadWrite = new MapReadWrite(rwl);

//        criamos um Runnable de escrita para sobrescrita do metodo start
        Runnable writer = () -> {
//            aqui ira escrever 20 valores para chave e valor do nosso map
            for (int i = 0; i < 20; i++) {
                mapReadWrite.put(String.valueOf(i), String.valueOf(i));
            }
        };

//        e tambem para leitura
        Runnable reader = () -> {
//            se tiver lock no writer, apresenta o sout abaixo
            if (rwl.isWriteLocked()) {
                System.out.println("WRITE LOCKED");
            }
//            da lock no reader e da o sout pro write nao concorrer junto
            rwl.readLock().lock();
            System.out.println("FINALLY I GOT THE DAMN LOCK!");
            try{
//                printa o map
                System.out.println(Thread.currentThread().getName()+ " "+mapReadWrite.allKeys());
            }finally {
//                solta o lock do reader
                rwl.readLock().unlock();
            }
        };
        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(reader);
        t1.start();
        t2.start();
        t3.start();
    }
}