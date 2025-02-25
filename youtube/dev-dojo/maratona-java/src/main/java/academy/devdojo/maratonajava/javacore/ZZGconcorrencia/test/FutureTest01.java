package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        expressa lambda utilizando Callable
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return 4.35D;
        });
//        chamando metodo de calculo de numeros
        System.out.println(doSomething());
//        utilizando o get pra aguardar a resposta da lambda
//        caso nao de resposta, lança Exception
        Double dollarResponse = dollarRequest.get(3, TimeUnit.SECONDS);
//        printando resposta do metodo
        System.out.println(dollarResponse);
//        encerrando as Threads
        executorService.shutdown();
    }

    private static long doSomething() {
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        return sum;
    }
}
