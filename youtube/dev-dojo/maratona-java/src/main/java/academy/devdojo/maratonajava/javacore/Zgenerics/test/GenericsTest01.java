package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        //antes de Generics, Java aceitava qualquer tipo primitivo, pois salvava como Object
        List lista = new ArrayList();
        lista.add("Midoriya");
        lista.add(123L);
        lista.add('A');
        //Para iterar, temos que usar como tipo Object e adaptar para cada tipo primitivo
        for (Object o : lista) {
            if (o instanceof String) System.out.println(o);
            if (o instanceof Long) System.out.println(o);
            if (o instanceof Character) System.out.println(o);
        }

        //Generics analisa em tempo de compilação o tipo primitivo de Arrays
        List<String> stringList = new ArrayList<>();
        stringList.add("Midoriya");
        stringList.add("Midoriya");
        stringList.add("Midoriya");
        for (String s : stringList) {
            System.out.println(s);
        }
        //a JVM acaba convertendo para o formato original, através de type erasure
        //isso bagunça se rodemos via metodo
        //aqui irá funcionar
        add(stringList, new Consumidor("Midoriya"));
        //a partir daqui, só funciona se tratarmos como Object
        for (Object o : stringList) {
            System.out.println(o);
        }

    }

    private static void add(List lista, Consumidor consumidor) {
        lista.add(consumidor);
    }
}
