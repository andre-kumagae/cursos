package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.sql.SQLOutput;
import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class ZoneTest01 {
    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        shortIds.forEach( (k, v) -> { System.out.println(k + " -> " + v); } );
        //System.out.println(shortIds);
        System.out.println(ZoneId.systemDefault());
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println("tokyoZone = " + tokyoZone);

        Instant nowInstant = Instant.now();
        System.out.println("nowInstant = " + nowInstant);
//        adicionando zona ao tempo zulu
        ZonedDateTime zonaAtualComOffsetJp = nowInstant.atZone(tokyoZone);
        System.out.println("zonaAtualComOffsetJp = " + zonaAtualComOffsetJp);
//        alterando o horario para esta zona
        ZoneOffset zonaTokyo = ZoneOffset.of("+09:00");
        System.out.println("zonaTokyo = " + zonaTokyo);
        OffsetDateTime zonaBrParaTokyo = nowInstant.atOffset(zonaTokyo);
        System.out.println("zonaBrParaTokyo = " + zonaBrParaTokyo);

        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate);
        LocalDate meijiEraLocalDate = LocalDate.of(1900, 2, 1);
        JapaneseDate meijiEra = JapaneseDate.from(meijiEraLocalDate);
        System.out.println(meijiEra);

//        pegar offset da maquina
        ZoneId zoneSP = ZoneId.systemDefault();
        System.out.println("zoneSP = " + zoneSP);
        ZonedDateTime zonaDateTimeSp = ZonedDateTime.now(zoneSP);
        System.out.println("zonaDateTimeSp = " + zonaDateTimeSp);
        String offset = zonaDateTimeSp.getOffset().getId();
        System.out.println("zonaDateTimeSp.getOffset() = " + zonaDateTimeSp.getOffset());
        System.out.println("offset = " + offset);
    }
}
