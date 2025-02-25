package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

class Animal {
    public void andar() {
        System.out.println("Animal andando");
    }
}

class Cachorro extends Animal {
    @Override
    public void andar() {
        System.out.println("Cachorro andando");
    }
}

public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.andar();
//        em vez de criar uma classe para cada method, poendo criar uma subclasse dentro da instancia da classe pai
        Animal animal1 = new Animal(){
//            sobrescrevendo o metodo
            @Override
            public void andar() {
                System.out.println("Animal anonimo andando");
                jump();
            }
//            podemos criar methods proprios para chamar pelo method sobrescrito
            public void jump() {
                System.out.println("Animal anonimo pulando");
            }
//          o fim do bloco tem que ter ponto e virgula
        };
//          podemos chamar o method sobrescrito
        animal1.andar();
    }
}
