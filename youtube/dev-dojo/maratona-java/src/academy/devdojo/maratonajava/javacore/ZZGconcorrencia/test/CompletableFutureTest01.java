package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
//        searchPricesSync(storeService);
//        searchPricesASyncFuture(storeService);
        searchPricesASyncCompletableFuture(storeService);
    }

    private static void searchPricesSync(StoreService storeService) {
//        pegando inicio que roda o metodo
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));
//        pegando o fim e calculando a diferença
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %d ms%n", end - start);
    }

    private static void searchPricesASyncFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
//        De forma assíncrona o metodo getPricesAsyncFuture é chamada junto devido ao Executors
        Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 4");
        try {
//            Porém para encerrar todas as Threads sem causar uma Exception, precisa de um try catch
            System.out.println(pricesAsyncFuture1.get());
            System.out.println(pricesAsyncFuture2.get());
            System.out.println(pricesAsyncFuture3.get());
            System.out.println(pricesAsyncFuture4.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", end - start);
//        Há a necessidade de chamar o shutdown após o bloco catch para garantir o encerramento de todas as threads
        StoreService.shutdown();
    }

    private static void searchPricesASyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        CompletableFuture<Double> pricesAsyncCompletableFuture1 = storeService.getPricesAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pricesAsyncCompletableFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pricesAsyncCompletableFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pricesAsyncCompletableFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");
//        Através do ComparableFuture, deixamos o código sem a necessidade de utilizar try catch, pois o metodo join lança uma unchecked Exception
        System.out.println(pricesAsyncCompletableFuture1.join());
        System.out.println(pricesAsyncCompletableFuture2.join());
        System.out.println(pricesAsyncCompletableFuture3.join());
        System.out.println(pricesAsyncCompletableFuture4.join());
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %d ms%n", end - start);
        StoreService.shutdown();
    }
}
