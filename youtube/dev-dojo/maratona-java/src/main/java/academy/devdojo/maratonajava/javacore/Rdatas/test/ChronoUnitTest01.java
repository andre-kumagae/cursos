package academy.devdojo.maratonajava.javacore.Rdatas.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Local;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
    public static void main(String[] args) {
        LocalDate javaBirth = LocalDate.of(1995, 5, 23);
        System.out.println(javaBirth);
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        // forma mais facil de calcular diferenca de periodos
        System.out.println(ChronoUnit.DAYS.between(javaBirth, hoje));
        System.out.println(ChronoUnit.WEEKS.between(javaBirth, hoje));
        System.out.println(ChronoUnit.MONTHS.between(javaBirth, hoje));
        System.out.println(ChronoUnit.YEARS.between(javaBirth, hoje));

        Period criancaAdulta = Period.ofWeeks(58);
        // convertendo semanas dias de semanas e tirando a diferença em meses
        System.out.println(hoje.until(hoje.plusDays(criancaAdulta.getDays()), ChronoUnit.MONTHS));
    }
}
