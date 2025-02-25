package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingletonLazy {
    // Lazy initialization = criamos o atributo sem dar valor a ele
    private static AircraftSingletonLazy INSTANCE;

    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    public AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }

    // instanciamos ele via metodo somente se for nulo
    // metodo lazy tem a desavantagem de poder gerar problemas em multithread
    // por isso, geramos o bloco synchronized dentro da condicional
    public static AircraftSingletonLazy getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (AircraftSingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }
}
