package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

// padrao orcamento desejado no print
// storeName:price:discountCode
// a classe teve o modificador final para ser imutavel
public final class Quote {
    private final String store;
    private final double price;
    private final Discount.Code discountCode;

//    deixamos o construtor privado para que o construtor dela seja tratado pelo metodo newQuote
    private Quote(String store, double price, Discount.Code discountCode) {
        this.store = store;
        this.price = price;
        this.discountCode = discountCode;
    }

    // documentacao
    /**
     * Creates new Quote Object from the value following the pattern storeName:price:discountCode
     * @param value containing storeName:price:discountCode
     * @return new Quote with values from @param value
     */
    public static Quote newQuote(String value) {
//        aqui conseguimos criar o padrao desejado, dividindo cada String com ":"
        String[] values = value.split(":");
//        aqui foi necessário mudar no double "," por "." para corrigir NumberFormatException
        return new Quote(values[0], Double.parseDouble(values[1].replace(",",".")), Discount.Code.valueOf(values[2]));
    }

    @Override
    public String toString() {
        return "Quote{" +
                "store='" + store + '\'' +
                ", price=" + price +
                ", discountCode=" + discountCode +
                '}';
    }

    public String getStore() {
        return store;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
