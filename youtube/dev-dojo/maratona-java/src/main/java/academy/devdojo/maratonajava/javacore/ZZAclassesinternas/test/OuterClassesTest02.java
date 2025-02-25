package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest02 {
    private String nome = "Midoriya";

    void print() {
        //Variável declarada ou passada como um parâmetro do method é implicitamente final
        String lastName = "Izuku";
        // classe local é uma classe dentro de um method
        // modificadores permitidos: abstract ou final
        class LocalClass {
            //ela pode carregar methods, mas o acesso dele acaba quando ele termina
            public void printLocal() {
                System.out.println(nome+" "+lastName);
            }
        }
//        para ter acesso a uma classe local, temos que instanciá-la dentro do method
        LocalClass localClass = new LocalClass();
        localClass.printLocal();
//        declaração em uma linha
//        new LocalClass().printLocal();
    }

    public static void main(String[] args) {
//        Para ter acesso à classe, chamamos o method pela classse externa
        OuterClassesTest02 outerClassesTest02 = new OuterClassesTest02();
        outerClassesTest02.print();
    }
}
