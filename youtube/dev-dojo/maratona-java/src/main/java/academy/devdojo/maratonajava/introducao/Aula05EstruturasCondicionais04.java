package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais04 {
    public static void main(String[] args) {
        // € 0 € 34712 = 9.70%
        // € 34,713 € 68,507 = 37.35%
        // € 68,508  = 49.50%
        double salarioAnual = 34712;
        double imposto;
        if (salarioAnual < 34713) imposto = 0.097;
        else if (salarioAnual < 68508) imposto = 0.3735;
        else imposto = 0.495;
        salarioAnual = salarioAnual - (salarioAnual * imposto);
        System.out.println("Imposto: "+(imposto*100)+" %");
        System.out.println("Salário final: \u20ac "+salarioAnual);
    }
}