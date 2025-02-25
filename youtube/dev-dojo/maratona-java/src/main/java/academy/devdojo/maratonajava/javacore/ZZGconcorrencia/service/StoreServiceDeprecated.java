package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import java.util.concurrent.*;

public class StoreServiceDeprecated {
//     geração de threads dinâmica
    public static final ExecutorService ex = Executors.newCachedThreadPool();

//    Gerando números aleatórios para os preços, chamando o metodo de delay antes do return
    private double priceGenerator() {
        System.out.printf("%s generating price %n",Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1,500)*10;
    }

//    Pegando os preços de forma síncrona
    public double getPriceSync(String storeName) {
        System.out.printf("Getting prices sync for store %s%n",storeName);
        return priceGenerator();
    }

//    Metodo que simula delay para carregar lojas
    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
