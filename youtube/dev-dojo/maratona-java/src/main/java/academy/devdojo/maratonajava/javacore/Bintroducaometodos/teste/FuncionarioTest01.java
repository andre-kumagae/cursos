package academy.devdojo.maratonajava.javacore.Bintroducaometodos.teste;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Funcionario;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Fulano");
        funcionario.setIdade(20);
        funcionario.setSalario(new double[]{1000, 2000, 3000});
        funcionario.imprimirDados();
    }
}
