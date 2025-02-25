package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Jogador;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Time;

public class JogadorTest02 {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Neymar");
        Jogador jogador2 = new Jogador("Ganso");
        Jogador jogador3 = new Jogador("Messi");
        Time time = new Time("Santos FC");
        jogador1.setTime(time);
        jogador2.setTime(time);
        jogador3.setTime(time);
        jogador1.imprime();
        jogador2.imprime();
        jogador3.imprime();
    }
}
