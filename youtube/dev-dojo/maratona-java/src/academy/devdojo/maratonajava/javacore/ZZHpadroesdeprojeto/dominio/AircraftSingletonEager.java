package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingletonEager {
    // Eager initialization = utilization of an instance
    private static final AircraftSingletonEager INSTANCE = new AircraftSingletonEager("787-900");

    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    public AircraftSingletonEager(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }

    public static AircraftSingletonEager getInstance() {
        return INSTANCE;
    }

}
