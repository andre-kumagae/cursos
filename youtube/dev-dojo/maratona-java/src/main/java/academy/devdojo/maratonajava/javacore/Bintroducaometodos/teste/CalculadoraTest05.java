package academy.devdojo.maratonajava.javacore.Bintroducaometodos.teste;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest05 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int[] array = {1,2,3,4};
        calculadora.somaArray(array);
        calculadora.somaArray(new int[]{4,5,6,7});
        calculadora.somarVarArgs("Valor:",5,6,7);
    }
}
