package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {
        //o comportamento da interface é similar ao de Map
        NavigableMap<String, String> navigableMap = new TreeMap<>();
        navigableMap.put("A", "Letra A");
        navigableMap.put("D", "Letra D");
        navigableMap.put("B", "Letra B");
        navigableMap.put("C", "Letra C");
        navigableMap.put("E", "Letra E");
        //lembrando que para iterar, é necessário que as classes implementem Comparable ou que implementem Comparator no construtor
        for (Map.Entry<String, String> stringStringEntry : navigableMap.entrySet()) {
            System.out.println(stringStringEntry+" - "+stringStringEntry.getValue());
        }
        //Porém incluindo métodos similares ao de NavigableSet
        //retorna menor que o valor dado
        System.out.println(navigableMap.headMap("C"));
        //podemos incluir o valor buscado com boolean true
        System.out.println(navigableMap.headMap("C",true));
        System.out.println(navigableMap);
        System.out.println("ceilingKey: "+navigableMap.ceilingKey("C"));
        System.out.println("floorKey: "+navigableMap.floorKey("C"));
        System.out.println("higherKey: "+navigableMap.higherKey("C"));
        System.out.println("lowerKey: "+navigableMap.lowerKey("C"));
        System.out.println("lowerEntry: "+navigableMap.lowerEntry("C"));
    }
}
