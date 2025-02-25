package academy.devdojo.maratonajava.javacore.Csobrecargademetodos.dominio;

public class Anime {
    private String tipo;
    private int episodios;
    private String nome;
    private String genero;

    public void imprime(){
        System.out.println(this.tipo);
        System.out.println(this.episodios);
        System.out.println(this.nome);
    }

    public void init(String nome, String tipo, int episodios){
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
    }

    public void init(String nome, String tipo, int episodios, String genero){
     this.init(nome, tipo, episodios);
        this.genero = genero;
    }


    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getEpisodios(){
        return this.episodios;
    }

    public void setEpisodios(int episodios){
        this.episodios = episodios;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getGenero(){
        return this.genero = genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }
}
