package academy.devdojo.maratonajava.javacore.ZZKunit.dominio;

import java.util.Objects;

// a sintaxe dele ja tem os parametros utilizado e tem parametros que ja serve para ser o construtor
// ele possui metodos boilerplate codes como getter, equals e hashcode
public record Manga(String name, int episodes) {
    //    private String producerName; // nao podemos criar atibutos de objeto
    //    só podemos criar atributos estaticos
    private static String producer;

//    construtor que exige name non null
    public Manga {
        Objects.requireNonNull(name);
    }
}
