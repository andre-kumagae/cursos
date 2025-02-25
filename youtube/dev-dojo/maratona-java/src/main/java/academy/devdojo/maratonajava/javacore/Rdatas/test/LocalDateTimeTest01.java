package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
//       funciona com ambos os metodos de LocalDate e LocalTime
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime);
        LocalDate data = LocalDate.of(2025, 02, 02);
        LocalTime tempo = LocalTime.of(21, 32);
//        juncao de LocalDate e LocalTime
        LocalDateTime dataComTempo = data.atTime(tempo);
        LocalDateTime tempoComData = tempo.atDate(data);
        System.out.println(dataComTempo);
        System.out.println(tempoComData);
//        funciona com Strings tambem
        LocalDate dataString = LocalDate.parse("2025-02-02");
        LocalTime tempoString = LocalTime.parse("21:36");
        LocalDateTime tempoComDataString = tempoString.atDate(dataString);
        System.out.println(tempoComDataString);

    }
}
