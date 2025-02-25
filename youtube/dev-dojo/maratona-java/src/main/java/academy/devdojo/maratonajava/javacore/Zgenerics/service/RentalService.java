package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;

import java.util.List;

//T = tipo. Em coleções, o padrão é colocar E = elemento
//Não utilizamos ? pois queremos definir um mesmo tipo para os metodos
public class RentalService<T> {
    //variável que irá receber Lista do tipo T
    private List<T> veiculosDisponiveis;

    public RentalService(List<T> veiculosDisponiveis) {
        this.veiculosDisponiveis = veiculosDisponiveis;
    }

    //oerceba que aqui irá retornar a classe, portantos eria somente t em vez de List<t>
    public T buscarVeiculoDisponivel() {
        System.out.println("Buscando veículo disponível...");
        T t = veiculosDisponiveis.remove(0);
        System.out.println("Alugando veículo: " + t);
        System.out.println("Carros disponiveis para alugar");
        System.out.println(veiculosDisponiveis);
        return t;
    }

    public void retornarCarroAlugado(T t) {
        System.out.println("Devolvendo veículo: " + t);
        veiculosDisponiveis.add(t);
        System.out.println("Veículos disponíveis para alugar");
        System.out.println(veiculosDisponiveis);
    }
}
