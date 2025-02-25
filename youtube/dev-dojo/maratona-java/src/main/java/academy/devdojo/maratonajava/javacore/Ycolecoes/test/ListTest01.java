package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        // Utilizado até Java 1.4
        // ArrayList é dinamicamente incrementável
        List nomes = new ArrayList();
        nomes.add("William");
        nomes.add(121);
        // repare que como o tipo é Object, ele aceita qualquer tipo
        for (Object nome : nomes) {
            System.out.println(nome);
        }
        //a partir da versao 1.5, precisamos utilizar o diamond operator para forçar o tipo desejado
        List<String> nomes2 = new ArrayList<>();
        nomes2.add("William");
        nomes2.add("DevDojo Academy");
        for (String s : nomes2) {
            System.out.println(s);
        }
        System.out.println("=== For indexado ===");
        //usamos size() em vez de length()
        for (int i = 0; i < nomes2.size(); i++) {
            //usamos get() em vez de [i]
            System.out.println(nomes2.get(i));
        }
        System.out.println("=== teste de incremento dinâmico do array ===");
        nomes2.add("Suane");
        for (int i = 0; i < nomes2.size(); i++) {
            System.out.println(nomes2.get(i));
        }

        List<String> nomes3 = new ArrayList<>(16);
        nomes3.add("William");
        nomes3.add("DevDojo Academy");
        //se o add for inserido em uma foreach, gera uma Exception que entra em conflito com o tamanho especificado pelo for
//        for (String s : nomes3) {
//            System.out.println(s);
//            nomes3.add("Suane");
//        }

        //só funcionaria em for com indice, porém para não cairmos em um llop infinito, defina o tamanho da lista fora do loop
        System.out.println(nomes.size());
        int size = nomes3.size();
        for (int i = 0; i < size; i++) {
            nomes3.add("Suane");
        }
        System.out.println(nomes3);

        //Dentro do Diamond operator, o tipo deve ser um objeto
        // List<int> numeros = new ArrayList<>(16); errado
        // correto
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);

        // metodo remover pode ser pelo indice ou pelo objeto
        nomes3.remove(0);
        nomes3.remove("DevDojo Academy");
        System.out.println(nomes3);

        // copiar valores de uma lista para a outra
        List<String> nomesNovo = new ArrayList<>();
        nomesNovo.addAll(nomes3);
        System.out.println(nomesNovo);
        System.out.println("nomes3 = " + nomes3);
        System.out.println("nomesNovo = " + nomesNovo);

    }
}
