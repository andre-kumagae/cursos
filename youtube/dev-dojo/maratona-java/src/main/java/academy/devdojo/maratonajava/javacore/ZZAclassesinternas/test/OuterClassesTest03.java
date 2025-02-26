package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
//        uma classe estatica interna/aninhada é igual a uma classe que estivesse fora do bloco
//    porem uma classe estatica tem que estar dentro de outra top-level (não-aninhada)
//    Ela só fica dentro de outra classe por questões de empacotamento ou por ser relacionado a classe externa
private String nome = "Wiliiam";
    public static class Nested {
        //    por ser estatica, nao consegue acessar variaveis do objeto. Deve ser declarado juntamente com a criacao da instancia da classe
        private String sobrenome = "Suane";
        void print() {
            System.out.println(new OuterClassesTest03().nome+" "+sobrenome);
        }
    }

    public static void main(String[] args) {
//        perceba que apesar da classe ser estatica, o metooo nao é. Logo, precisa d eum objeto
        Nested nested = new Nested();
        nested.print();
//        exemplo para ajudar a entender a instancia build na aula 257 de jdbc
        OuterClassesTest03.Nested outer = new OuterClassesTest03.Nested();
    }
}
