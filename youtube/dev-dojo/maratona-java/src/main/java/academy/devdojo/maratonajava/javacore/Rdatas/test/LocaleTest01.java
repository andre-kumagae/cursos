package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocaleTest01 {
    public static void main(String[] args) {
        Date pegaData = Calendar.getInstance().getTime();
        Locale localeItaly = new Locale("it","IT");
        Locale localeSwiss = new Locale("it","CH");
        Locale localeJapan = new Locale("ja","JP");
        Locale localeIndia = new Locale("hi","IN");
        Locale localeNetherlands = new Locale("nl","NL");
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeSwiss);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeJapan);
        DateFormat df4= DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
        DateFormat df5= DateFormat.getDateInstance(DateFormat.FULL, localeNetherlands);
        System.out.println(df1.format(pegaData));
        System.out.println(df2.format(pegaData));
        System.out.println(df3.format(pegaData));
        System.out.println(df4.format(pegaData));
        System.out.println(df5.format(pegaData));
        System.out.println(localeJapan.getDisplayCountry());
        System.out.println(localeJapan.getDisplayCountry(localeJapan));
        System.out.println(localeItaly.getDisplayLanguage(localeJapan));
    }
}
