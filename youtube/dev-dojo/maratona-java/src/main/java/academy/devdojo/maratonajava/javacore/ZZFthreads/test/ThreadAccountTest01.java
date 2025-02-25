package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Account;

// implementaca da interface para utilizacao do metodo run()
public class ThreadAccountTest01 implements Runnable {
//    defina o atributo como final se for utilizar o synchronized dentro de um bloco
    private final Account account = new Account();

    public static void main(String[] args) {
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01, "Hestia");
        Thread t2 = new Thread(threadAccountTest01, "Bell Cranel");
        t1.start();
        t2.start();
    }

    // sobrescrita para sacar de 10 em 10 no loop
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            // mensagem em caso de saldo zerado
            if (account.getBalance() < 0) {
                System.out.println("FODEO");
            }
        }
    }

//    perceba que apesar de mesmo nome, este metodo apenas tem o if else para liberar o saque
//    a palavra synchronized na assinatura do metodo barra o paralelismo entre as threads criando um lock
    private void withdrawal(int amount) {
        // podemos utilizar o synchronized dentrod e um bloco do metodo
        // para evitar problemas de uso de outro objeto, deixe-o como final
        System.out.println(getThreadName() + " ### fora do bloco synchronized: ");
        synchronized (account) {
            System.out.println(getThreadName() + " *** dentro do bloco synchronized: ");
            if (account.getBalance() >= amount) {
                System.out.println(getThreadName() + " está indo sacar dinheiro.");
                account.withdrawal(amount);
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(getThreadName() + " completou o saque. Valor atual da conta: " + account.getBalance());
            } else {
                System.out.println("Sem dinheiro para "+ getThreadName() +" efetuar o saque "+account.getBalance());
            }
        }
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
