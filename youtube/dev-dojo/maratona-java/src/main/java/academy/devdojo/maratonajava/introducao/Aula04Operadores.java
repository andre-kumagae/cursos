package academy.devdojo.maratonajava.introducao;

public class Aula04Operadores {
    public static void main(String[] args) {
        int numero1 = 10;
        int numero2 = 20;
        System.out.println(10+20);
        System.out.println("O valor é:"+10+20);
        System.out.println(numero1/numero2);
        System.out.println((double) 10/20);

        int resto = 22 % 2;
        System.out.println(resto);

        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezIgualQueVinte = 10 == 20;
        boolean isDezDiferenteQueVinte = 10 != 20;
        System.out.println(isDezMaiorQueVinte);
        System.out.println(isDezMenorQueVinte);
        System.out.println(isDezIgualQueVinte);
        System.out.println(isDezDiferenteQueVinte);

        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >= 4612;
        boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario >= 3381;
        System.out.println("isDentroDaLeiMaiorQueTrinta: " +isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta: " +isDentroDaLeiMenorQueTrinta);

        double saldoContaCorrente = 200;
        double saldoContaPoupanca = 10000;
        float valorPlaystation5 = 5000F;
        boolean isPossoComprarPlaystation5 = saldoContaCorrente > valorPlaystation5 || saldoContaPoupanca > valorPlaystation5;
        System.out.println(isPossoComprarPlaystation5);

        double bonus = 1800;
        System.out.println(bonus += 1000);
        System.out.println(bonus -= 1000);
        System.out.println(bonus *= 1000);
        System.out.println(bonus /= 1000);
        System.out.println(bonus %= 1000);

        int contador = 0;
        contador += 1;
        System.out.println(contador);
        contador++;
        System.out.println(contador);
        System.out.println(++contador);
        System.out.println(contador++);
    }
}

