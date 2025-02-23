package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {

    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.tryLock(2, TimeUnit.SECONDS);
            if (lock.isHeldByCurrentThread()) {
                System.out.printf("Thread %s pegou o LOCK%n",name);
            }
            System.out.printf("Thread %s entrou em uma sessão crítica%n", name);
            System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength());
            Thread.sleep(500);
            System.out.printf("Thread %s finalizou a espera%n", name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}

public class ReentrantLockTest01 {
    public static void main(String[] args) {
//        colocando o parametro true, conseguimos randomizar as Threads
        ReentrantLock reentrantLock = new ReentrantLock(true);
//        nao precisa de variavel de Thread para executar
        new Thread(new Worker("A", reentrantLock)).start();
        new Thread(new Worker("B", reentrantLock)).start();
        new Thread(new Worker("C", reentrantLock)).start();
        new Thread(new Worker("D", reentrantLock)).start();
        new Thread(new Worker("E", reentrantLock)).start();
        new Thread(new Worker("F", reentrantLock)).start();
        new Thread(new Worker("G", reentrantLock)).start();

    }
}
