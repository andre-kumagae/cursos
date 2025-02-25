package academy.devdojo.maratonajava.javacore.Oexception.error.test;

public class StackOverFlowTest01 {
    public static void main(String[] args) {
        recursion();
    }

    public static void recursion(){
        recursion();
    }
}
