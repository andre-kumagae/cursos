package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosList = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Mercedes"),new Carro("Fusca")));
        List<Barco> barcosList = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Iate"),new Barco("Canoa")));
        //Perceba que agora podemos utilizar nossa classe criado com generics para ambas as classes
        RentalService<Carro> carroRentalService = new RentalService<>(carrosList);
        RentalService<Barco> barcoRentalService = new RentalService<>(barcosList);
        //e podemos chamar o method da classe generics
        carroRentalService.buscarVeiculoDisponivel();
        barcoRentalService.buscarVeiculoDisponivel();
    }
}
