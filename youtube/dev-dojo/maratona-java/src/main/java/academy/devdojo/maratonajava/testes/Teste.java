package academy.devdojo.maratonajava.testes;

public class Teste {
    private String nome;
    private int numero;
    private double salario;
    private char sexo;
    private boolean maior;

    public Teste(String nome, int numero, double salario, char sexo) {
        this.nome = nome;
        this.numero = numero;
        this.salario = salario;
        this.sexo = sexo;
    }

    public Teste(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Teste{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                ", salario=" + salario +
                ", sexo=" + sexo +
                '}';
    }
}
