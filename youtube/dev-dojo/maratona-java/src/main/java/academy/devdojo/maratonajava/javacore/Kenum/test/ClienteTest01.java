package academy.devdojo.maratonajava.javacore.Kenum.test;

import academy.devdojo.maratonajava.javacore.Kenum.dominio.Cliente;
import academy.devdojo.maratonajava.javacore.Kenum.dominio.TipoCliente;
import academy.devdojo.maratonajava.javacore.Kenum.dominio.TipoPagamento;

import static academy.devdojo.maratonajava.javacore.Kenum.dominio.TipoPagamento.CREDITO;
import static academy.devdojo.maratonajava.javacore.Kenum.dominio.TipoPagamento.DEBITO;

public class ClienteTest01 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Tsubasa", TipoCliente.PESSOA_FISICA, CREDITO);
        Cliente cliente2 = new Cliente("Neymar", TipoCliente.PESSOA_FISICA, CREDITO);
        Cliente cliente3 = new Cliente("Santos FC", TipoCliente.PESSOA_JURIDICA, DEBITO);
        Cliente cliente4 = new Cliente("Santos SAF FC", TipoCliente.PESSOA_JURIDICA, DEBITO);
        Cliente[] clientes = new Cliente[]{cliente1, cliente2, cliente3, cliente4};
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        System.out.println(DEBITO.calcularDesconto(100));
        System.out.println(CREDITO.calcularDesconto(100));
        TipoCliente tipoCliente = TipoCliente.valueOf("PESSOA_FISICA");
        System.out.println(tipoCliente.getTipoPessoa());
        TipoCliente tipoCliente2 = TipoCliente.tipoClientePorTipoPessoa("PF");
        System.out.println(tipoCliente2);
        TipoCliente tipoCliente3 = TipoCliente.tipoClientePorIndice(1);
        System.out.println(tipoCliente3);
    }
}
