package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println("hoje = " + hoje);
        DayOfWeek today = hoje.getDayOfWeek();

        LocalDate proximoDiaDaSemana = LocalDate.now().with(TemporalAdjusters.next(today));
        System.out.println("proximoDiaDaSemana = " + proximoDiaDaSemana);

        LocalDate anteriorDiaDaSemana = LocalDate.now().with(TemporalAdjusters.next(today));
        System.out.println("anteriorDiaDaSemana = " + anteriorDiaDaSemana);

        LocalDate dia = LocalDate.now();
        DayOfWeek diaSemana = dia.getDayOfWeek();
        LocalDate primeiroDiaDomes = dia.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("primeiroDiaDomes = " + primeiroDiaDomes+" "+primeiroDiaDomes.getDayOfWeek());
        LocalDate ultimoDiaDoMes = dia.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("ultimoDiaDoMes = " + ultimoDiaDoMes+ " "+ultimoDiaDoMes.getDayOfWeek());
        LocalDate primeiroDiaDesteAno = dia.now().with(TemporalAdjusters.firstDayOfYear());
        System.out.println("primeiroDiaDesteAno = " + primeiroDiaDesteAno+" "+primeiroDiaDesteAno.getDayOfWeek());
        LocalDate primeiroDiaDoProximoAno = dia.now().with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("primeiroDiaDoProximoAno = " + primeiroDiaDoProximoAno+" "+primeiroDiaDoProximoAno.getDayOfWeek());

    }
}
