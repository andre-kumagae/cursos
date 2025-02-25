package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class ExercicioDiaUtilTest01 {
    public static void main(String[] args) {
        LocalDate[] week = new LocalDate[7];
        week[0] = LocalDate.now();
        for (int i = 1; i < week.length; i++) {
            week[i] = week[i-1].plusDays(1);
        }
        for (LocalDate localDate : week) {
            nextWeekDayPrinter(localDate);
        }
    }
    public static void nextWeekDayPrinter(LocalDate weekDay) {
        LocalDate nextWeekDay = weekDay;
        if (weekDay.getDayOfWeek() == DayOfWeek.FRIDAY || weekDay.getDayOfWeek() == DayOfWeek.SATURDAY || weekDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            nextWeekDay = nextWeekDay.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        } else {
            nextWeekDay = nextWeekDay.plusDays(1);
        }
        System.out.println("Data: "+weekDay+" / Dia da semana: "+weekDay.getDayOfWeek()+" / Próxima dia útil: "+nextWeekDay.getDayOfWeek());
    }
}
