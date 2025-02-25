package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9));
        mangas.add(new Manga(1L, "Berserk", 9.5));
        mangas.add(new Manga(4L, "Pokemon", 3.2));
        mangas.add(new Manga(3L, "Attack on titans", 11.20));
        mangas.add(new Manga(2L, "Dragon Ball Z", 2.99));
        Collections.sort(mangas);
        System.out.println("\n*** Ordenando por ID: ***\n");
        for (Manga manga : mangas) System.out.println(manga);

        //podemos usar a binarySearch passando o objeto.
        Manga mangaToSearch = new Manga(3L, "Attack on titans", 11.20);
        System.out.println("\nÍndice por ID: "+Collections.binarySearch(mangas, mangaToSearch));

        //podemos trocar o tipo de ordenacao guardando-a em uma variavel e adicioná-la à sobrecarga do metodo
        MangaByNomeComparator mangaByNomeComparator = new MangaByNomeComparator();
        MangaByPrecoComparator mangaByPrecoComparator = new MangaByPrecoComparator();
        Collections.sort(mangas, mangaByNomeComparator);
        System.out.println("\n*** Ordenando por Nome: ***\n");
        for (Manga manga : mangas) System.out.println(manga);
        System.out.println("\nÍndice por nome: "+Collections.binarySearch(mangas, mangaToSearch, mangaByNomeComparator));
        Collections.sort(mangas, mangaByPrecoComparator);
        System.out.println("\n*** Ordenando por preço: ***\n");
        for (Manga manga : mangas) System.out.println(manga);
        System.out.println("\nÍndice por preço: "+Collections.binarySearch(mangas, mangaToSearch, mangaByPrecoComparator));
    }
}
