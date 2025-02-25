package academy.devdojo.maratonajava.javacore.Hheranca.dominio;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Endereco endereco;

    static {
        System.out.println("Bloco estático de pessoa");
    }

     {
        System.out.println("Bloco não estático de pessoa 1");
    }

    {
        System.out.println("Bloco não estático de pessoa 2");
    }

    public Pessoa(String nome, String cpf) {
        System.out.println("Bloco construtor de pessoa");
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void imprime(){
        System.out.println(nome);
        System.out.println(cpf);
        System.out.println(endereco.getRua()+" "+endereco.getCep());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
