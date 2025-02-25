package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Jogador;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Time;

public class JogadorTest03 {
    public static void main(String[] args) {
        Time time = new Time("SeleSantos");
        Jogador jogador = new Jogador("Neymar");
        Jogador jogador2 = new Jogador("Tiquinho");
        Jogador jogador3 = new Jogador("Soteldo");
        Jogador[] jogadores = {jogador, jogador2, jogador3};

        jogador.setTime(time);
        jogador2.setTime(time);
        jogador3.setTime(time);

        time.setJogadores(jogadores);

        System.out.println("=== Jogador ===");
        jogador.imprime();

        System.out.println("=== Time ===");
        time.imprime();
    }
}
