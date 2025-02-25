package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime afterTwoYears = LocalDateTime.now().plusYears(2);
        LocalDateTime minusTwoHours = LocalDateTime.now().minusHours(2);
        Duration d1 = Duration.between(now, afterTwoYears);
        System.out.println(d1);
        Duration d2 = Duration.between(now, minusTwoHours);
        System.out.println(d2);
        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
        System.out.println(d3);
        Duration d4 = Duration.ofDays(20);
        System.out.println(d4);
        Duration d5 = Duration.ofMinutes(30);
        System.out.println(d5);
    }
}
