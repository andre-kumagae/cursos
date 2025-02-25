package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais {
    public static void main(String[] args) {
        int idade = 15;
        boolean isAutorizadoAComprarBebida = idade >= 18;

        if (isAutorizadoAComprarBebida){
            System.out.println("Autorizado a comprar bebida alcoólica!");
        }
        else {
            System.out.println("Não autorizado a comprar bebida alcoólica!");
        }
    }
}
