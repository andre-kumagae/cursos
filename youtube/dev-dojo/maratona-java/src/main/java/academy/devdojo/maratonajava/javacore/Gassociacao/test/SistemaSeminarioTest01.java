package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.*;

/*
Crie um sistema que gerencie seminários.

O sitema deverá cadastrar seminários, estudantes, professores e local onde será realizado OK

Um aluno poderá estar em apenas um seminário OK
Um seminário poderá ter nenhum ou vários alunos ok
Um professor poderá ministrar vários seminários
Um seminário deve ter um local

Campos básicos (excluindo relacionamento)

seminário: título
aluno: nome e idade
professor: nome, especialidade
local: endereço
 */

public class SistemaSeminarioTest01 {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Joao", 18);
        Aluno aluno2 = new Aluno("Maria", 18);
        Aluno aluno3 = new Aluno("Ana", 18);
        Local local = new Local("Campus Anchieta");
        Seminario seminario1 = new Seminario("Seminario Java", local);
        Seminario seminario2 = new Seminario("Seminario Spring", local);
        Professor professor = new Professor("Marcos", "SI");

        aluno1.setSeminario(seminario1);
        seminario1.setAlunos(new Aluno[]{aluno1, aluno2, aluno3});
        seminario2.setAlunos(new Aluno[]{aluno1, aluno2, aluno3});
        seminario1.setLocal(local);
        seminario2.setLocal(local);
        professor.setSeminarios(new Seminario[]{seminario1, seminario2});

        aluno1.imprime();
        aluno2.imprime();
        aluno3.imprime();

        seminario1.imprime();
        seminario2.imprime();
        professor.imprime();


    }
}
