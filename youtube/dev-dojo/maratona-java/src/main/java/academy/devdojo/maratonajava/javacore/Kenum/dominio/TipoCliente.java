package academy.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");
    private int valor;
    private String tipoPessoa;
    private int indice;

    TipoCliente(int VALOR, String tipoPessoa) {
        this.valor = VALOR;
        this.tipoPessoa = tipoPessoa;
    }

    public static TipoCliente tipoClientePorTipoPessoa(String nomeRelatorio) {
        for (TipoCliente tipoCliente : values()) {
            if (tipoCliente.getTipoPessoa().equals(nomeRelatorio)) {
                return tipoCliente;
            }
        }
        return null;
    }

    public static TipoCliente tipoClientePorIndice(int indice) {
        for (TipoCliente tipoCliente : values()) {
            if (tipoCliente.getValor() == indice) {
                return tipoCliente;
            }
        }
        return null;
    }

    public int getValor() {
        return valor;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}


