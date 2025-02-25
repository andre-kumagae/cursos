package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao02 {
    public static void main(String[] args) {
        // Imprima todos os números pares de 0 até 1000000
        int numero = 0;
        int quantidadeNumeros = 0;
        while (numero <= 1000000){
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
            numero++;
            quantidadeNumeros++;
        }
        System.out.println("Números encontrados: "+quantidadeNumeros);
    }
}
