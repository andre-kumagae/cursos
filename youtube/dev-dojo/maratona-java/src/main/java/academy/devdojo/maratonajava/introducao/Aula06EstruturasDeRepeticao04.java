package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao04 {
    // Dado o valor de um carro, descubra em quantas ele pode ser parcelado
    // Condição valorParcela 1000
    public static void main(String[] args) {
        double valorCarro = 30000;
        double valorParcela;
        int parcela=1;
        do {
            valorParcela = valorCarro / parcela;
            parcela++;
        }while (valorParcela > 1000);
        System.out.println("Valor do carro: R$ "+valorCarro+" parcelado em "+(parcela-1)+"x de R$ 1000,00.");
    }
}
