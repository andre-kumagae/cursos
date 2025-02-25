package academy.devdojo.maratonajava.javacore.Npolimorfismo.servico;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;

public class CalculadoraImposto {
//    public static void calcularImpostoComputador(Computador computador){
//        double imposto = computador.calcularImposto();
//        System.out.println("*** Relatório do imposto do computador ***");
//        System.out.println("Computador: "+computador.getNome());
//        System.out.println("Valor: "+computador.getValor());
//        System.out.println("Imposto: "+imposto);
//    }
//
//    public static void calcularImpostoTomate(Tomate tomate){
//        double imposto = tomate.calcularImposto();
//        System.out.println("*** Relatório do imposto do tomate ***");
//        System.out.println("Tomate: "+tomate.getNome());
//        System.out.println("Valor: "+tomate.getValor());
//        System.out.println("Imposto: "+imposto);
//    }

    public static void calcularImposto(Produto produto){
        double imposto = produto.calcularImposto();
        System.out.println("*** Relatório do imposto do produto ***");
        System.out.println("Produto: "+produto.getNome());
        System.out.println("Valor: "+produto.getValor());
        System.out.println("Imposto: "+imposto);
        if (produto instanceof Tomate) System.out.println(((Tomate) produto).getDataValidade());
        // forma resumida do if abaixo
//        if (produto instanceof  Tomate){
//            Tomate tomate = (Tomate) produto;
//            System.out.println(tomate.getDataValidade());
//        }
    }
}
