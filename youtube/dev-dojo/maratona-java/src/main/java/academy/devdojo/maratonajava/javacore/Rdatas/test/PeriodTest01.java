package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate afterYearsAndTime = LocalDate.now().plusYears(2).plusDays(2);
        Period p1 = Period.between(now, afterYearsAndTime);
        System.out.println(p1);
        // convertendo semans para dias
        Period semanaParaDias = Period.ofWeeks(58);
        System.out.println("semanaParaDias: "+semanaParaDias);

        // calculo que periodo de vida desde o aniversario de Java
        LocalDate nascimento = LocalDate.of(1995, 05, 23);
        Period toVivo = Period.between(nascimento, now);
        System.out.println(toVivo);
    }
}
