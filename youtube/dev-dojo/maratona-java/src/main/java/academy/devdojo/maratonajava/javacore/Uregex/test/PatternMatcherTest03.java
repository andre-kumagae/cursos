package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
    public static void main(String[] args) {
        // \d = todos os digitos
        // \D = tudo o que nao for digito
        // \s = espaçoes em branco \t \n \f \r
        // \S = todos os caracteres excluindo os brancos
        // \w = a-zA-Z, digitos, _
        // \w = tudo o que nao for incluso no \w
        // [] range de caracteres
        String regex = "\\d";
        String regex2 = "\\D";
        String regex3 = "\\s";
        String regex4 = "\\S";
        String regex5 = "\\w";
        String regex6 = "\\W";
        String regex7 = "[abc]";
        String texto = "deo_dwccacio32842 9rcbbbcccaah4urf4   893rabcccfh3 4_q";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("== BUSCA DE DIGITOS ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }
        pattern = Pattern.compile(regex2);
        matcher = pattern.matcher(texto);
        System.out.println("== BUSCA DE NAO DIGITOS ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }

        pattern = Pattern.compile(regex3);
        matcher = pattern.matcher(texto);
        System.out.println("== BUSCA DE ESPAÇOS ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }

        pattern = Pattern.compile(regex4);
        matcher = pattern.matcher(texto);
        System.out.println("== BUSCA DE CARACTERES MENOS OS EM BRANCO ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }

        pattern = Pattern.compile(regex5);
        matcher = pattern.matcher(texto);
        System.out.println("== BUSCA DE LETRAS, DIGITOS E UNDERLINE ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }

        pattern = Pattern.compile(regex6);
        matcher = pattern.matcher(texto);
        System.out.println("== BUSCA EXCLUINDO DE LETRAS, DIGITOS E UNDERLINE ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }

        pattern = Pattern.compile(regex7);
        matcher = pattern.matcher(texto);
        System.out.println("== BUSCA a,b e c  ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }

        int numeroHex = 0X59F86A;
        System.out.println(numeroHex);
        String regex8 = "0[xX][0-9a-fA-F]";
        String texto2 = "12 0x 0X 0xFFABC 0x109 0x1";
        pattern = Pattern.compile(regex8);
        matcher = pattern.matcher(texto2);
        System.out.println("== BUSCA de hexadecimal ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }
    }
}
