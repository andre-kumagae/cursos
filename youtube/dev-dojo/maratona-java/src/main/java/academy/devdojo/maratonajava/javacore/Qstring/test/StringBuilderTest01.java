package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        String nome = "William Suane";
        nome.concat(" Devdojo");
        System.out.println(nome.substring(0,3));
        System.out.println(nome);
        StringBuilder stringBuilder = new StringBuilder(nome);
        stringBuilder.append(" DevDojo").append(" Academy");
        System.out.println(stringBuilder);
        stringBuilder.substring(0,3);
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        stringBuilder.delete(0,3);
        System.out.println(stringBuilder);
    }
}
