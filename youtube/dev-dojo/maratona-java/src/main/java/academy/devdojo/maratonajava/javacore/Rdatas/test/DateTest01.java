package academy.devdojo.maratonajava.javacore.Rdatas.test;
import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        Date date = new Date(1_000_000L); //long ms desde 1/1/1970
        Date dateHoje = new Date(); //deixa vazio para saber dia de hoje
        System.out.println(date);
        System.out.println(date.getTime()); // conversao de volta para ms
        date.setTime(date.getTime() + 3_600_000); //add uma hora
        System.out.println(date);
        System.out.println(dateHoje);
        System.out.println(dateHoje.getTime()); // conversao de volta para ms
    }
}
