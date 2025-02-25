package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatTest01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat[] d = new DateFormat[7];
        System.out.println("===");
        System.out.println(DateFormat.getDateTimeInstance().format(calendar.getTime()));
        System.out.println(DateFormat.getDateTimeInstance());
        d[0] = DateFormat.getInstance();
        d[1] = DateFormat.getDateInstance();
        d[2] = DateFormat.getDateTimeInstance();
        d[3] = DateFormat.getDateInstance(DateFormat.SHORT);
        d[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        d[5] = DateFormat.getDateInstance(DateFormat.LONG);
        d[6] = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("=== sem format ===");
        for (DateFormat dateFormat : d) {
            System.out.println(dateFormat);
        }
        System.out.println("=== com format ===");
        for (DateFormat dateFormat : d) {
            System.out.println(dateFormat.format(calendar.getTime()));
        }

    }
}
