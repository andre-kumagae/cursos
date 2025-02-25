package academy.devdojo.maratonajava.javacore.ZZDoptional.repository;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static List<Manga> mangas = List.of(new Manga(1,"Boku no Hero", 50), new Manga (2,"Overlord", 25));

    public static Optional<Manga> findByTitle(String titulo) {
        return find(m -> m.getTitulo().equals(titulo));
    }

    public static Optional<Manga> findById(Integer id) {
       return find(m -> m.getId().equals(id));
    }

    public static Optional<Manga> find(Predicate<Manga> predicate) {
        Manga found = null;
        for (Manga manga : mangas) {
            if (predicate.test(manga)) {
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }
}
