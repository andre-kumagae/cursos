package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.LoginInvalidoException;
import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidoException {
        Scanner scanner = new Scanner(System.in);
        String loginDB = "goku";
        String senhaDB = "ssj";
        System.out.print("Digite o seu login: ");
        String loginDigitado = scanner.nextLine();
        System.out.print("Digite a sua senha: ");
        String senhaDigitada = scanner.nextLine();
        if (!loginDigitado.equals(loginDB) || !senhaDigitada.equals(senhaDB)){
            throw new LoginInvalidoException("Login ou senha inválida.");
        }else {
            System.out.println("Login efetuado com sucesso!");
        }
    }
}
