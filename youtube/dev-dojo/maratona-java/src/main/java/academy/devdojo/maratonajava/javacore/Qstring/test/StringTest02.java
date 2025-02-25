package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "Luffy";
        System.out.println(nome.charAt(0));
        int[] nums = {1,2,3};
        System.out.println(nums.length);
        System.out.println(nome.length());
        System.out.println(nome.replace("f","l"));
        System.out.println(nome.toUpperCase());
        System.out.println(nome.substring(0,3));
        System.out.println(nome.substring(3));
        String nome2 = " Zoro";
        System.out.println(nome2);
        System.out.println(nome2.trim());
    }
}
