package academy.devdojo.maratonajava.introducao;

/*
Explicando comentário do Youtube:
Perceba que nos prints antes dos loops for, mostram 2 objetos diferentes, aparecendo algo assim:

Array 1: [Ljava.lang.String;@7b23ec81
Array 2: [Ljava.lang.String;@312b1dae

Isto indica que são objetos diferentes. O Dev Dojo explica melhor na aula 76.

Ao atribuir um novo Array de 5 posições mas utilizando o mesmo nome ao segundo Array e dar o nome "Naruto" ao índice 4, ele entende que os índices 0 a 3 estão nulos, pois de fato criamos um novo Array de 5 posições, mas só demos valor à última.
 */

public class Aula07Arrays02 {
    public static void main(String[] args) {
        String[] nomes = new String[4];
        nomes[0] = "Goku";
        nomes[1] = "Kurosaki";
        nomes[2] = "Luffy";
        nomes[3] = "Hinata";
        System.out.println("Array 1: " + nomes);
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("For each 2 - Posição " + i + ": " + nomes[i]);
        }
        System.out.println("========");
        nomes = new String[5];
        nomes[4] = "Naruto";
        System.out.println("Array 2: " + nomes);
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("For each 2 - Posição " + i + ": " + nomes[i]);
        }
    }
}
