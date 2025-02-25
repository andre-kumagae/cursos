package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

import java.sql.SQLException;
import java.io.*;

public class RunTimeExceptionTest04 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Dentro do IndexOutOfBoundsException");
        } catch (IllegalArgumentException e) {
            System.out.println("Dentro do IllegalArgumentException");
        } catch (ArithmeticException e) {
            System.out.println("Dentro do ArithmeticException");
        } catch (RuntimeException e) {
            System.out.println("Dentro do RuntimeException");
        }

        try {
            talvezLanceException();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try{
            talvezLanceException();
        //}catch (SQLException | FileNotFoundException | IOException e){ IOException é pai de FileNotFoundException, nao sendo possivel usar mulicatch
        }catch (SQLException | FileNotFoundException e){
            System.out.println("Multi catch");
        }
    }


    public static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}
