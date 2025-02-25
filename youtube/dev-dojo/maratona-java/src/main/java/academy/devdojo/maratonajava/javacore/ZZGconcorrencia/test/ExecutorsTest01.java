package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable {
    private int num;

    public Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s inicio: %d%n", Thread.currentThread().getName(), num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s finalizou%n", Thread.currentThread().getName());
    }
}

public class ExecutorsTest01 {
    public static void closeService(ExecutorService ex, String name) {
        ex.shutdown();
//        gambiarra para esperar encerrar todas as threads e depois printar
        while (!ex.isTerminated()) {
        }
        System.out.printf("%s finalizado%n", name);
        System.out.println("============");
    }

    public static void main(String[] args) {
//        metodo para saber quantas threads em nossa cpu
        System.out.println(Runtime.getRuntime().availableProcessors());
//        definir 4 threads para cada tarefa
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4));
        executorService.execute(new Printer(5));
        executorService.execute(new Printer(6));
//        metodo que criei para automatizar etapas repetidas
        closeService(executorService, "executorService");
//        fixar numeros de threads do cpu
        ExecutorService executorServiceXeon = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorServiceXeon.execute(new Printer(1));
        executorServiceXeon.execute(new Printer(2));
        executorServiceXeon.execute(new Printer(3));
        executorServiceXeon.execute(new Printer(4));
        executorServiceXeon.execute(new Printer(5));
        executorServiceXeon.execute(new Printer(6));
        executorServiceXeon.execute(new Printer(7));
        executorServiceXeon.execute(new Printer(8));
        executorServiceXeon.execute(new Printer(9));
        executorServiceXeon.execute(new Printer(10));
        executorServiceXeon.execute(new Printer(11));
        executorServiceXeon.execute(new Printer(12));
        closeService(executorServiceXeon, "executorServiceXeon");
//        definit 1 threada por tarefa
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();
        executorServiceSingle.execute(new Printer(1));
        executorServiceSingle.execute(new Printer(2));
        executorServiceSingle.execute(new Printer(3));
        closeService(executorServiceSingle, "executorServiceSingle");
//        definir para divisao de threads ser dinamica de acordo com o que o sistema decidir
        ExecutorService executorServiceCached = Executors.newCachedThreadPool();
        executorServiceCached.execute(new Printer(1));
        executorServiceCached.execute(new Printer(2));
        executorServiceCached.execute(new Printer(3));
        executorServiceCached.shutdown();
        closeService(executorServiceCached, "executorServiceCached");
    }
}
