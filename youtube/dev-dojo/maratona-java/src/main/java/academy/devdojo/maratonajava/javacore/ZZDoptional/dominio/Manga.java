package academy.devdojo.maratonajava.javacore.ZZDoptional.dominio;

public class Manga {
    private Integer id;
    private String titulo;
    private int capitulos;

    public Manga(Integer id, String titulo, int capitulos) {
        this.id = id;
        this.titulo = titulo;
        this.capitulos = capitulos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "titulo='" + titulo + '\'' +
                ", id=" + id +
                ", capitulos=" + capitulos +
                '}';
    }
}
