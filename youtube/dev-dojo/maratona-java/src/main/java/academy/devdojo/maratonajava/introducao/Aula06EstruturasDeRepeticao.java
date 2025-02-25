package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao {
    public static void main(String[] args) {
        int count = 0;
        System.out.println("Loop while");
        while (count < 10) {
            System.out.println(++count);
        }
        count = 0;
        System.out.println("Loop do-while");
        do {
            System.out.println(count++);
        } while (count < 10);
        System.out.println("Loop for");
        for (int i = 0; i < 10 ; i++) {
            System.out.println(i);
        }
    }
}
