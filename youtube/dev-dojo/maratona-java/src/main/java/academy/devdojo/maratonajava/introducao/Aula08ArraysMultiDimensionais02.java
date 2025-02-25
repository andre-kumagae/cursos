package academy.devdojo.maratonajava.introducao;

public class Aula08ArraysMultiDimensionais02 {
    public static void main(String[] args) {
        int[][] numeros = new int[4][];
        numeros[0] = new int[1];
        numeros[1] = new int[2];
        numeros[2] = new int[3];
        numeros[3] = new int[4];

        for (int[] arrBase : numeros){
            System.out.println("\n---");
            for (int num : arrBase){
                System.out.println(num + " ");
            }
        }

        System.out.println("\n-----------------");
        int[][] array = new int[3][];
        //atribuindo valores de um array utilizando outro array
        int[] array2 = {1, 2};


        //array[0] = {1,2,3}; nao podemos atribuir diretamente
        array[0] = array2; //devemos referenciar valores de outro array
        //ou podemos declarar como um novo array e seus valores
        array[1] = new int[]{1,2,3,4};
        array[2] = new int[]{1,2,3,4,5,6};

        for (int[] arrBase2 : array){
            System.out.println("\n---");
            for (int num2 : arrBase2){
                System.out.print(num2 + " ");
            }
        }
    }
}
