package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        String nome = "Willian Suane";
        String nome2 = new String("Willian Suane");
        // compara a referência
        System.out.println(nome == nome2);
        // compara o conteúdo String retorna verdadeiro
        System.out.println(nome.equals(nome2));
        Smartphone smartphone = new Smartphone("1ABC1", "iPhone");
        Smartphone smartphone2 = new Smartphone("1ABC1", "iPhone");
        // porém comparando objetos dará falso não está fazendo referência para o mesmo objeto
        //System.out.println(smartphone.equals(smartphone2));
        // agora fazem refereência ao mesmo objeto
        //smartphone2  = smartphone;
        System.out.println(smartphone.equals(smartphone2));
        Smartphone smartphone3 = new Smartphone("1ABC1", "Pixel");
        System.out.println(smartphone3.equals(smartphone));
        smartphone.setSerialNumber(null);
        //smartphone2.setSerialNumber(null);
        System.out.println(smartphone);
        System.out.println(smartphone2);
        nome = "";
        System.out.println(nome);
        String nome3 = "";
        System.out.println(nome.equals(nome3));

    }
}
