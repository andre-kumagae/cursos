package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        //imprindo valores pares infinitamente
        //Stream.iterate(1, n -> n + 2).forEach(System.out::println);

//        imprimindo valores pares partindo do 1, limitando a 10 valores
        Stream.iterate(1, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

//        imprimindo a sequência de Fibonacci: Ela é dada iniciando com 0,1 onde são somados, gerando o terceiro número da sequência.
//        0+1 = 1
//        0 1 1
//        Soma o último com o antecessor para ter o quarto número e assim por diante:
//        1+1=2
//        0 1 1 2
//        1+2 = 3
//        0 1 1 2 3
//        2+3 = 5
//        0 1 1 2 3 5
//        Em um array n, ficaria assim: [0,1], [1,1], [1,2], [2,3], [3,5]
//        Perceba que o índice 0 do próximo item sempre será o índice 1 do item anterior:
//        [1,2], [2,3] = n[1] do primeiro item é o n[0] do segundo item
//        o metodo iterate pode iniciar com um seed, que no caso abaixo, é um array com valores 0,1
//        geramos a sequencia de Fibonacci, onde n[0] = n[1] anterior, n[1] = n[0] + n[1]
        Stream.iterate(new int[] {0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
//                Sem o map, teremos impressão de referencia de objetos
//                Podemos transformar a referencia para String via Arrays.toString
                .forEach(a -> System.out.println(Arrays.toString(a)));

        Stream.iterate(new int[] {0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
//                Utilizando o map para o primeiro indice, pois estamos sempre incrementando o array em cima do outro
                .map(a -> a[0])
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

//        metodo para gerar numeros aleatorios
        ThreadLocalRandom random = ThreadLocalRandom.current();
//        geenrate usa o Supplier para usar o metodo get
        Stream.generate(() -> random.nextInt(1,500))
                .limit(10)
                .forEach(n -> System.out.print(n + " "));
    }
}
