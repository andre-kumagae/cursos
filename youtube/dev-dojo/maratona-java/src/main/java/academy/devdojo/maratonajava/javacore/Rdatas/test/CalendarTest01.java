package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.*;

public class CalendarTest01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        Date date = c.getTime();
        System.out.println(date);
//        printa em milisegundos
        System.out.println("getTime do obejto Date: "+date.getTime());
//        printa em data completa
        System.out.println("getTime do obejto Calendar: "+c.getTime());
//        checar qual é o primeiro dia da semana
        if (c.getFirstDayOfWeek() == Calendar.SUNDAY) {
            System.out.println("Domingão é o primeiro dia da semana");
        }
//        pegar dias especificos em numero
        System.out.println("Dia do mês: "+c.get(Calendar.DAY_OF_MONTH));
        System.out.println("Número do dia da semana (sábado): "+c.get(Calendar.DAY_OF_WEEK));
        System.out.println("Número do dia no mês: "+c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("Dias no ano: "+c.get(Calendar.DAY_OF_YEAR));
        System.out.println("Data atual: "+c.getTime());
//        adição manualmente
        c.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println("+2 dias: "+c.getTime());
        c.add(Calendar.HOUR, 2);
        System.out.println("+2 horas: "+c.getTime());
//      virar as horas sem virar o dia, porém mantem no mesmo periodo (AM PM)
        c.roll(Calendar.HOUR, 2);
        System.out.println("2 horas mantendo periodo:"+c.getTime());
    }
}
