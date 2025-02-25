package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
    public static void main(String[] args) {
        // \d = todos os digitos
        // \D = tudo o que nao for digito
        // \s = espaçoes em branco \t \n \f \r
        // \S = todos os caracteres excluindo os brancos
        // \w = a-zA-Z, digitos, _
        // \w = tudo o que nao for incluso no \w
        // [] range de caracteres
        // ? zero ou uma ocorrencia
        // * zero ou mais ocorrencias
        // + uma ou mais ocorrencias
        // {n,m} de n ate m ocorrencias
        // () agrupamento
        // | ou ex.: o(v|c)o ovo | oco
        // $ fim da linha
        // . caracter curinga. ex.: 1.3 = 123, 1@3, 1a3
        String regex = "([a-zA-z0-9\\._-])+@([a-zA-z])+(\\.([a-zA-z])+)+";
        String texto = "luffy@hotmail.com, tste@teste@com, teste3@test.co.uk,    123jotaro@gmail.com, ace_fogo@fire.com, shanks-ruivo@red.com, !#$$@$@zoro@mail.br, teste@gmail.com.br, sakura@mail, chopper.rena@animal.com";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("== BUSCA de emails ==");
        while (matcher.find()) {
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }

        //validar se string é válida
        System.out.println("!#$$@$@zoro@mail.br".matches(regex));
        System.out.println("zoro@mail.br".matches(regex));
        //metodo que usa a split, que retorna um array e combina com toString para printa com um base em um caracter delimitador
        System.out.println(Arrays.toString(texto.split(",")));
        // removendo espaços em branco
        System.out.println(texto.split(",")[3].trim());
    }
}
