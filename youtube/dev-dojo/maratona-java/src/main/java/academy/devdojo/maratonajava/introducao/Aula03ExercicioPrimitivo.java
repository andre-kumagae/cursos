package academy.devdojo.maratonajava.introducao;

/*
Prática
Crie variáveis para os campos descritos abaixo entre <> e imprimq a seguinte mensqgem:
Eu <nome>, morandq no endereço <endereço>, confirmo que recebi o salário de <salario>, na data <data>.
 */

public class Aula03ExercicioPrimitivo {
    public static void main(String[] args) {
        String nome = "André";
        String endereco = "Rua Doutor José Áureo Bustamante, 455";
        String data = "20/01/2025";
        float salario = 10000;
        System.out.println("Eu, " + nome + ", morando no endereço: " + endereco + ", confirmo que recebi o salário de R$ " + salario + " na data de " + data + ".");
    }
}
