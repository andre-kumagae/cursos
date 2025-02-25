package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    //Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
    //Simétrico: para x e y diferentes de null, se x.equals(y_ == true, logo, y.equals(x) == true
    //Transitividade: para x,y,z diferentes de null, se x.equals(y) == true e  x.equals(z) == true, logo, y.equals(z) == true
    //Consistente: x.equals(x) sempre retorna true se x for diferente de null
    //para x diferente de null, x.equals(null) tem que retornar false
    //x.equals(y) = this.equals(obj)
    @Override
    public boolean equals(Object obj) {
        //ex.: Smartphone smartphone4 = new Smartphone(null,null);
        if (obj == null) return false;
        /*
        Smartphone smartphone6 = new Smartphone("1ABC1", "iPhone");
        Smartphone smartphone7 = new Smartphone("1ABC1", "iPhone");
        smartphone6 = smartphone7;
         */
        if (this == obj) return true;
        /*dois objetos de classes diferentes
        class academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone
        class academy.devdojo.maratonajava.javacore.Zcolecoes.dominio.Smartphone
         */
        if (this.getClass() != obj.getClass()) return false;
        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    // se x.equals(y) == true y.hashCode() == x.hashCode()
    // y.hashCode() == x.hashCode() não necessariamente o equals y.equals(x) == true
    // x.equals(y) == false
    // y.hashCode() != x.hashCode(), x.equals(y) deverá ser false
    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }
}
