package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

public class Discount {
    public enum Code {
        NONE(0), SUPER_SAYAJIN(5), SUPER_SAYAJIN_2(10), SUPER_SAYAJIN_3(15);
        private final int percentage;
// perceba que no construtor de um enum, não recebemos as suas constantes, somente oa tributo percentage
// esse atributo será utilizado para receber o valor das constantes
        Code(int percentage) {
            this.percentage = percentage;
        }

        public int getPercentage() {
            return percentage;
        }
    }
}
