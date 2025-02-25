package academy.devdojo.maratonajava.javacore.Hheranca.dominio;

public class Funcionario extends Pessoa {
    private double salario;

    static {
        System.out.println("Bloco estático de funcionario");
    }

    {
        System.out.println("Bloco não estático de funcionario 1");
    }

    {
        System.out.println("Bloco não estático de funcionario 2");
    }

    public Funcionario(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
        System.out.println("Bloco construtor de funcionario");
    }

    public void imprime(){
        super.imprime();
        System.out.println(salario);
    }

    public void relatorioPagamento() {
        System.out.println("Eu, "+this.nome+", recebi o salário de "+this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
