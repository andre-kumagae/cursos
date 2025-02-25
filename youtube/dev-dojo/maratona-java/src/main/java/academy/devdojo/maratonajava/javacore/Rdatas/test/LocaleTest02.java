package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Locale;

public class LocaleTest02 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        String[] isoCountries = Locale.getISOCountries();
        String[] isoLanguages = Locale.getISOLanguages();
        System.out.println("\nCountries - "+isoCountries.length);
        for (int i = 0; i < isoCountries.length; i++) {
            if (i % 40 == 0) {
                System.out.println();
            }
            System.out.print(isoCountries[i]+" ");
        }
        System.out.println("\n\nLanguages - "+isoLanguages.length);
        for (int i = 0; i < isoLanguages.length; i++) {
            if (i % 40 == 0) {
                System.out.println();
            }
            System.out.print(isoLanguages[i]+" ");
        }

    }
}
