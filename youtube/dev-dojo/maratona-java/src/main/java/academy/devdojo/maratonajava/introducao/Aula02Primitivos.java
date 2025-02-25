package academy.devdojo.maratonajava.introducao;

public class Aula02Primitivos {
    public static void main(String[] args) {
    int idade = 10;
    long numeroGrande = 100000;
    double salarioDouble = 2000;
    float salarioFloat = 2500;
    byte idadeByte = 10;
    short idadeShort = 10;
    boolean verdadeiro = true;
    boolean falso = false;
    char caracter = 'M';
    char caracterASCII = 65;
    char caracterUnicode = '\u0041';
    float doubleParaFloat = (float) 6000D;
    String nome = "Goku";
    var nome2 = "Vegeta";

        System.out.println("A idade é "+idade+" anos.");
        System.out.println(verdadeiro);
        System.out.println(caracterUnicode);
        System.out.println(caracterASCII);
        System.out.println(doubleParaFloat);
        System.out.println("Oi! Meu nome é "+nome);
        System.out.println("Oi! Meu nome é "+nome2);
    }
}
