package academy.devdojo.maratonajava.javacore.Fmodificadoresestaticos.dominio;

public class Carro {
    private String nome;
    private double velocidadeMaxima;
    public static double velocidadeLimite = 250;


    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void imprime(){
        System.out.println("-------");
        System.out.println("Nome do carro: "+this.nome);
        System.out.println("Velocidade máxima: "+this.velocidadeMaxima);
        System.out.println("velocidade limite: "+Carro.velocidadeLimite);
    }

    public String getNome(){
        return this.nome;
    }

    public double getVelocidadeMaxima(){
        return this.velocidadeMaxima;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void  setVelocidadeMaxima(double velocidadeMaxima){
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public static void setVelocidadeLimite(double velocidadeLimite){
        Carro.velocidadeLimite = velocidadeLimite;
    }

    public static double getVelocidadeLimite(){
        return velocidadeLimite;
    }
}
