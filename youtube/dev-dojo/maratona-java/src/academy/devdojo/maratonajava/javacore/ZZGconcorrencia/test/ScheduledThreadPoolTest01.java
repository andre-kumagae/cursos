package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest01 {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SS");
    //    definicao de quantas threada
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    private static void beeper() {
        Runnable r = () -> {
            System.out.println("Beep:   "+ LocalTime.now().format(formatter));
        };
//        agendar para executar apos 5 segundos
        executor.schedule(r, 5, TimeUnit.SECONDS);
    }

    private static void beeperWithFixedDelay() {
        Runnable r = () -> {
            System.out.println("Beep:   "+ LocalTime.now().format(formatter));
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
//        temos um parametro a mais para dar um delay de 1 segundo para começar
//        delay a cada 10 segundos + 3 de sleep = beep a cada 13 segundos
        ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 2, TimeUnit.SECONDS);
        executor.schedule(() -> {
//            esse bloco é o 1º parametro do schedule
//            ele só rodará após o delay
            System.out.println("Cancelando o scheduleWithFixedDelay.");
            scheduleWithFixedDelay.cancel(false);
            executor.shutdown();
        }, 20, TimeUnit.SECONDS);
    }

    private static void beeperAtFixedDelay() {
        Runnable r = () -> {
            System.out.println("Beep:   " + LocalTime.now().format(formatter));
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
//        temos um parametro a mais para dar um delay de 1 segundo para começar
//        intervalo será de 10 segundos do parâmetro period
        ScheduledFuture<?> scheduleAtFixedDelay = executor.scheduleAtFixedRate(r, 1, 2, TimeUnit.SECONDS);
        executor.schedule(() -> {
//            esse bloco é o 1º parametro do schedule
//            ele só rodará após o delay
            System.out.println("Cancelando o scheduleAtFixedRate.");
            scheduleAtFixedDelay.cancel(false);
            executor.shutdown();
        }, 20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
//        marcar tempo que chama a main
        System.out.println("Início: " + LocalTime.now().format(formatter));
//        execucao do runnable
//        beeper();
//        beeperWithFixedDelay();
        beeperAtFixedDelay();
        while (!executor.isTerminated()) {
        }
        System.out.println("Fim:    "+ LocalTime.now().format(formatter));
    }
}