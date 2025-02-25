package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        Map<String, String> maps = new HashMap<>();
        //no Map, nao adicionamos por add, mas sim por put
        maps.put("teklado", "teclado");
        maps.put("mouze", "mouse");
        maps.put("vc", "você");
        //se a chave for duplicada, ele sobrecreve
        //podemos utilizar utilizar o putIfAbsent para evitar esta sobescrita
        maps.putIfAbsent("vc2", "você");
        //Com o HashMap, ele busca a c=have a frente. Para manter a ordem, use LinkedHashMap
        System.out.println(maps);
        // as chaves são únicas, pois são Sets
        // por isso, para iterar pela chave, chamamos pelo metodo keySet em vez d variavel do map
        for (String key : maps.keySet()) {
            // e para retorno do valor. temos que chamar o metodo get(variavel do map)
            System.out.println("Chave: " + key + " / Valor: " + maps.get(key));
        }

        //Há outra forma de iterar dando o tipo do Map
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }

    }
}
