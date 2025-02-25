package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        // Set não permite objetos duplicados
        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(2L, "Hellsing Ultimate", 9.5));
        mangas.add(new Manga(5L, "Attack on titans", 2.99));
        mangas.add(new Manga(3L, "Pokemon", 3.2));
        mangas.add(new Manga(4L, "Dragon Ball Z", 11.20));
        mangas.add(new Manga(1L, "Berserk", 19.9));
        mangas.add(new Manga(1L, "Berserk", 19.9));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
