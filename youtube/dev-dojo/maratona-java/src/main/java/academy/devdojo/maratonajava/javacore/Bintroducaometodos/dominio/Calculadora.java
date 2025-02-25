package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Calculadora {
    public void somaDoisNumeros(){
        System.out.println(10+10);
    }

    public void subtraiDoisNumeros(){
        System.out.println(21-1);
    }

    public void multiplicaDoisNumeros(int num1, int num2){
        System.out.println(num1 * num2);
    }

    public double divideDoisNumeros(double num1, double num2){
        return num1 / num2;
    }

    public void divideDoisNumeros2(double num1, double num2){
        if (num2 == 0){
            System.out.println("Não existe divisão por zero");
            return;
        }
        System.out.println(num1 / num2);
    }

    public void alteraDoisNumeros(int num1, int num2){
        num1 = 33;
        num2 = 99;
        System.out.println("Números dentro do método: \nNum1: "+num1+"\nNum2: "+num2);
    }

    public void somaArray(int[] arr){
        int soma = 0;
        for (int num : arr){
            soma += num;
        }
        System.out.println(soma);
    }

    public void somarVarArgs(String res, int... numeros){
        int soma = 0;
        for (int num : numeros){
            soma += num;
        }
        System.out.println(res+" "+soma);
    }
}
