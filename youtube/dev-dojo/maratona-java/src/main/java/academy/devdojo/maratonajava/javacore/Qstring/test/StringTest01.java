package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        String nome = "Wiliiam"; //String constant pool
        String nome2 = "Wiliiam";
        nome = nome.concat(" Suane");
        System.out.println(nome == nome2);
        String nome3 = new String("William"); //variavel de referemcia, objeto do tipo String, string no String pool
        System.out.println(nome3 == nome2);
        System.out.println(nome3.intern() == nome2);
    }
}
