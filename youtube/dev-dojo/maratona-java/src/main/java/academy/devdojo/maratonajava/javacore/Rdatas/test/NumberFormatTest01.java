package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest01 {
    public static void main(String[] args) {
        Locale localeBr = new Locale("pt", "BR");
        Locale localeJp = Locale.JAPAN;
        Locale localeIt = Locale.ITALY;
        Locale localeAr = new Locale("es", "Ar");
        Locale localeUs = Locale.US;
        NumberFormat[] formatoNumerico = new NumberFormat[5];
        formatoNumerico[0] = NumberFormat.getInstance(localeBr);
        formatoNumerico[1] = NumberFormat.getInstance(localeJp);
        formatoNumerico[2] = NumberFormat.getInstance(localeIt);
        formatoNumerico[3] = NumberFormat.getInstance(localeAr);
        formatoNumerico[4] = NumberFormat.getInstance(localeUs);
        double valor = 10_000.2130;
        for (NumberFormat numberFormat : formatoNumerico) {
            System.out.println(numberFormat.getMaximumFractionDigits());
            System.out.println(numberFormat.getCurrency()+" - "+numberFormat.format(valor));
        }
    }
}
