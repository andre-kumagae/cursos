package academy.devdojo.maratonajava.javacore.Jmodificadorfinal.dominio;

public  class Carro {
    private String nome;
    public static final double VELOCIDADE_LIMITE = 250;
    public final Comprador COMPRADOR = new Comprador();

    public void imprime() {
        System.out.println(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", COMPRADOR=" + COMPRADOR +
                '}';
    }
}
