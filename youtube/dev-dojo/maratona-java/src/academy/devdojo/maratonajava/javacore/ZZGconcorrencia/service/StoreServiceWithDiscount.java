package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Discount;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Quote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServiceWithDiscount {
    //     geração de threads dinâmica
    public static final ExecutorService ex = Executors.newCachedThreadPool();

    //    Gerando números aleatórios para os preços, chamando o metodo de delay antes do return
    private double priceGenerator() {
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    //    Pegando os preços de forma síncrona
    public String getPriceSync(String storeName) {
//        pegando o valor aleatorio de um preco de produto
        double price = priceGenerator();
//        pegando um valor aleatorio do enum. Perceba que para pegar o valor dele, usamos a sintaxe de array (Discount.Code.values()[])
        Discount.Code discountCode = Discount.Code.values()[ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];
//        Aqui conseguimos pegar o formato que criamos na class Quote (storeName:price:discountCode)
        return String.format("%s:%.2f:%s", storeName, price, discountCode);
    }

    public String applyDiscount(Quote quote) {
// simulacao de delay de 1 segundo para busca de API
        delay();
//        macete para calculo de porcentagem para valores zerados ou inteiros
//        exs: 1370 * (100 - 15) / 100 = 1370 * 75/100 = 1370 * 0.75 = 1027,50
//             1040 * (100 - 0) / 100 = 1040 * 100/100 = 1040 * 1 = 1040
        double discountValue = quote.getPrice() * (100 - quote.getDiscountCode().getPercentage()) / 100;
//        formatacao para relatorio final com calculo de desconto
        return String.format("'%s' original price: '%.2f'. Applying discount code '%s'. Final price: '%.2f'", quote.getStore(), quote.getPrice(), quote.getDiscountCode(), discountValue);
    }

    //    Metodo que simula delay para carregar lojas
    private void delay() {
        try {
            int mili = ThreadLocalRandom.current().nextInt(200, 2500);
            TimeUnit.MILLISECONDS.sleep(mili);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
