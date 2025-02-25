package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

public interface Currency {
    String getSymbol();
}

class Real implements Currency {
    @Override
    public String getSymbol() {
        return "R$";
    }
    @Override
    public String toString() {
        return getSymbol();
    }

    }
class Dollar implements Currency {
    @Override
    public String getSymbol() {
        return "U$";
    }

    @Override
    public String toString() {
        return getSymbol();

    }
}