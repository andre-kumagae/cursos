package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Endereco;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Pessoa;

public class HerancaTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Toyohisa Shimizu","111111");
        Endereco endereco = new Endereco();
        Endereco endereco2 = new Endereco();
        Funcionario funcionario = new Funcionario("Oda Nobunaga", "22222", 20000);

        endereco.setRua("Rua 3");
        endereco.setCep("010101-111");

        endereco2.setRua("Rua 4");
        endereco2.setCep("77777-444");

        pessoa.setEndereco(endereco);
        pessoa.imprime();
        System.out.println("---");

        funcionario.setEndereco(endereco2);
        funcionario.imprime();
        funcionario.relatorioPagamento();

    }
}
