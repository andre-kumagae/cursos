package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest01 {
    private String nome = "Monkey D. Luffy";

    class Inner{
        public void printOuterClassAttribute() {
            System.out.println(nome);
            //this se refere ao contexto da classe que se encontra (Inner)
            System.out.println(this);
            //temos que chamar o this pela classe externa
            System.out.println(OuterClassesTest01.this);
        }
    }
    public static void main(String[] args) {
        OuterClassesTest01 outerClassesTest01 = new OuterClassesTest01();
        //sintaxe para instanciar a classe interna pela externa
        Inner inner1 = outerClassesTest01.new Inner();
        Inner inner2 = new OuterClassesTest01().new Inner();
        inner2.printOuterClassAttribute();

    }
}
