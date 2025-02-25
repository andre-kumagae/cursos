package academy.devdojo.maratonajava.javacore.Zgenerics.test;

// criando uma classe abstrata para mostrar o funcionamento de polimorfismo em objetos
abstract class Animal {
    public abstract void consulta();
}

class Cachorro extends Animal {
    @Override
    public void consulta() {
        System.out.println("Consulta cachorro");
    }
}

class Gato extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consulta gato");
    }
}

public class WildcardTest01 {
    public static void main(String[] args) {
        //conseguimos instanciar arrays de obejtos
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
        //conseguimos misturá-los
        Animal[] animals = {new Gato(), new Cachorro()};
        printConsulta(cachorros);
        printConsulta(gatos);
        printConsulta(animals);
    }

    //criando um metodo que chama as classes abstratas
    private static void printConsulta(Animal[] animals) {
        System.out.println("====");
        for (Animal animal : animals) {
            //como é um metodo de outra classe, chamamos diretamente sem sout
            animal.consulta();
        }
//        aqui se adicionassemos uma classe específica, dará Exception pois o parametro é da classe abstrata, porem pdoeriamos passar objeto Cachorro
//        animals[1] = new Gato();
    }
}
