package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(2L, "Hellsing Ultimate", 19.9,0));
        mangas.add(new Manga(1L, "Berserk", 9.5,5));
        mangas.add(new Manga(4L, "Pokemon", 3.2,0));
        mangas.add(new Manga(3L, "Attack on titans", 11.2,2));
        mangas.add(new Manga(2L, "Dragon Ball Z", 2.99,2));

        //com a Interface Iterator, chamamos o metodo iterator() da interface List<E>, que irá iterar o nosso ArrayList
        Iterator<Manga> mangaIterator = mangas.iterator();
        //que por sua vez chaam o metodo hasNext, que retorna true até chegar ao fim
        while (mangaIterator.hasNext()) {
            //pega o proximo do ArrayList
            Manga manga = mangaIterator.next();
            //checa se o atributo quantidade é 0
            //forma simplificada:
            //if (mangaIterator.next().getQuantidade() == 0)
            if (manga.getQuantidade() == 0) {
                //volta à variável de Iterator e remove
                mangaIterator.remove();
            }
        }
        System.out.println("mangas = " + mangas);

        //A partir do Java 8, há uma forma simplificada de realizar este código através de programação funcional:
        mangas.removeIf(manga -> manga.getQuantidade() == 2);
        System.out.println("mangas = " + mangas);
    }
}
