package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Quote;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceDeprecated;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest04 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
//        searchPricesWithDiscount(service);
        searchPricesWithDiscountAsync(service);
    }

    private static void searchPricesWithDiscount(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        stores.forEach(s -> System.out.println(service.getPriceSync(s)));
        stores.stream()
                .map(service::getPriceSync)
                .map(Quote::newQuote)
                .map(service::applyDiscount)
                .forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %d ms%n", end - start);
    }

        private static void searchPricesWithDiscountAsync (StoreServiceWithDiscount service){
            long start = System.currentTimeMillis();
            List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
            List<CompletableFuture<String>> completableFutures = stores.stream()
                    // pegando o preco async storeName::price::discountCode
                    .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                    // instanciando um novo Quote da String gerado por getPriceSync
                    .map(cf -> cf.thenApply(Quote::newQuote))
                    // composto o primeiro completable future
                    .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                    .collect(Collectors.toList());

            completableFutures.stream()
                    .map(CompletableFuture::join)
                    .forEach(System.out::println);

            long end = System.currentTimeMillis();
            System.out.printf("Time passed to searchPricesSync %d ms%n", end - start);
        }
    }


