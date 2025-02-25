package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

//se nao declarássemos o <T> no method, teríamo que declarar aqui: public class MetodoGenericoTest01 <T> {
public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        //new DoisAnimais<Cachorro, Gato>();
        criarArrayComoUmObjeto(new Barco("Canoa marota"));
        List<Barco> canoaMarota = criarArrayComoUmObjetoReturn(new Barco("Canoa marota"));
        System.out.println(canoaMarota);
    }


    //Em generics, podemos criar quantos atributos quisermos
//Perceba que o nome da classe também é genérica
    class DoisAnimais<C, G> {
        private C c;
        private G g;
    }

// generics method
//    declarando o <T> aqui, não precisamor declarar na classe
    private static <T> void criarArrayComoUmObjeto(T t) {
        List<T> list = List.of(t);
        System.out.println(list);
    }

    private static <T> List<T> criarArrayComoUmObjetoReturn(T t) {
        return List.of(t);
    }
}
