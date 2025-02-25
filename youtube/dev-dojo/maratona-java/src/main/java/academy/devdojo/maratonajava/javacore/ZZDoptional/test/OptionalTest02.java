package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repository.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
//        Por ser metodo estatico, não precisa de objeto
        Optional<Manga> bokuNoHero = MangaRepository.findByTitle("Boku no Hero");
        System.out.println(bokuNoHero);

        bokuNoHero.ifPresent(m -> m.setTitulo("Boku no Hero 2"));
        System.out.println(bokuNoHero);

        Manga mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaById);

        mangaById = MangaRepository.findById(3).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaById);

        Manga newManga = MangaRepository.findByTitle("Drifters").orElseGet(() -> new Manga(3, "Drifters", 20));
        System.out.println(newManga);
    }
}
