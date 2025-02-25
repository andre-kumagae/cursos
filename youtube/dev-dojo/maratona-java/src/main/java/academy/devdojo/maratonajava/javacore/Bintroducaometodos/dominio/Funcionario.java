package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Funcionario {
    private String nome;
    private int idade;
    private double[] salario;
    private double media;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getSalario() {
        return salario;
    }

    public void setSalario(double[] salario) {
        this.salario = salario;
    }

    public double getMedia() {
        return media;
    }

    public void imprimirDados(){
        if (salario == null){
            return;
        }
        System.out.println("Nome: "+this.nome);
        System.out.println("Idade: "+this.idade);
        System.out.println("3 últimos sálarios:");
        for (double num : this.salario) {
            System.out.println("R$ "+num);
        }
        mediaSalario(salario);
    }

    private void mediaSalario(double... array){
        int soma = 0;
        for (double num : array){
            media += num;
        }
        media /= salario.length;
        System.out.println("Média dos 3 salários: R$ "+media);
    }
}

