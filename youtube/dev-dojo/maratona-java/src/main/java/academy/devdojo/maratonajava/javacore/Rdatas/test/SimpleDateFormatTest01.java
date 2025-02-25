package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {
        String pattern = "'Canal do DevDojo, 'dd 'de' MMMM 'de' yyyy ' - 'hh:mm a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
