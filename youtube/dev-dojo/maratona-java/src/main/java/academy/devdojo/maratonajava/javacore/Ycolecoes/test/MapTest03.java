package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Wiliiam Suane");
        Consumidor consumidor2 = new Consumidor("Dev Dojo Academy");
//        System.out.println(consumidor1);
//        System.out.println(consumidor2);

        Manga manga1 = new Manga(2L, "Hellsing Ultimate", 9.5);
        Manga manga2 = new Manga(5L, "Attack on titans", 2.99);
        Manga manga3 = new Manga(3L, "Pokemon", 3.2);
        Manga manga4 = new Manga(4L, "Dragon Ball Z", 11.20);
        Manga manga5 = new Manga(1L, "Berserk", 19.9);
        Manga manga6 = new Manga(6L, "One Piece", 25.9);

        // implementando para um consumidor ter varios mangas
        Map<Consumidor, List<Manga>> consumidorMangaMap = new LinkedHashMap<>();
        List<Manga> mangaList1 = List.of(manga1, manga2, manga3);
        List<Manga> mangaList2 = List.of(manga4, manga5, manga6);
        consumidorMangaMap.put(consumidor1, mangaList1);
        consumidorMangaMap.put(consumidor2, mangaList2);
        //consumidorMangaMap.put(consumidor2, manga2);
        for (Map.Entry<Consumidor, List<Manga>> consumidorListEntry : consumidorMangaMap.entrySet()) {
            System.out.println("==== "+consumidorListEntry.getKey().getNome()+" ===");
            //para mostrar de forma mais amig´avel, crie um for-each dessa lista de mangas
            for (Manga manga : consumidorListEntry.getValue()) {
                System.out.println(manga.getNome());
            }
            System.out.println("");
        }
    }
}
