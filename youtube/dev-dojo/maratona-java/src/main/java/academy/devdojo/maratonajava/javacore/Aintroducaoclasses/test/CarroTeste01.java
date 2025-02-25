package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Carro;

public class CarroTeste01 {
    public static void main(String[] args) {
        Carro carro = new Carro();
        Carro carro2 = new Carro();
        carro.nomeCarro = "Relâmpago Mcqueen";
        carro.modeloCarro = "Corvette C6";
        carro.anoCarro = 2006;
        carro2.nomeCarro = "Derby";
        carro2.modeloCarro = "Fusca";
        carro2.anoCarro = 1963;
        carro2 = carro;
        System.out.println("Nome do carro: "+carro.nomeCarro+"\nModelo do carro: "+carro.modeloCarro+"\nAno do carro: "+carro.anoCarro);
        System.out.println("================================");
        System.out.println("Nome do carro: "+carro2.nomeCarro+"\nModelo do carro: "+carro2.modeloCarro+"\nAno do carro: "+carro2.anoCarro);

    }
}
