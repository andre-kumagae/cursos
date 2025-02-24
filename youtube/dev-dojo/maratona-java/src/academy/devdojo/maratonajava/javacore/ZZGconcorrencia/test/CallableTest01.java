package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
//        De preferencia para ThreadLocalRandom em vez de Math.Random, pois esta gera um lock
        int number = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < number; i++) {
            System.out.printf("%s executando uma tarefa callable...%n",Thread.currentThread().getName());
        }
        return String.format("%s finished and the random number is %d",Thread.currentThread().getName(), number);
    }
}

public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        metodo submit gera retorna tipo Future, que se não tiver um metodo de parada, executa depois do main parar
        Future<String> future = executorService.submit(randomNumberCallable);
//        metodo de get seria o metodo de  aguardar as threads tratarem o Callable
        String s = future.get();
        System.out.printf("Program finished %s",s);
        executorService.shutdown();
    }
}
