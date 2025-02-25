package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Wiliiam Suane");
        Consumidor consumidor2 = new Consumidor("Dev Dojo Academy");
        System.out.println(consumidor1);
        System.out.println(consumidor2);

        Manga manga1 = new Manga(2L, "Hellsing Ultimate", 9.5);
        Manga manga2 = new Manga(5L, "Attack on titans", 2.99);
        Manga manga3 = new Manga(3L, "Pokemon", 3.2);
        Manga manga4 = new Manga(4L, "Dragon Ball Z", 11.20);
        Manga manga5 = new Manga(1L, "Berserk", 19.9);

        Map<Consumidor, Manga> consumidorMangaMap = new HashMap<>();
        consumidorMangaMap.put(consumidor1, manga1);
        consumidorMangaMap.put(consumidor2, manga2);

        for (Map.Entry<Consumidor, Manga> consumidorMangaEntry : consumidorMangaMap.entrySet()) {
            System.out.println(consumidorMangaEntry.getKey().getNome() + " - " + consumidorMangaEntry.getValue().getNome());
        }
    }
}
