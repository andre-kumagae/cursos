package academy.devdojo.maratonajava.javacore.ZZIjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //java.sql = pacote para conectar Java com SQL
    //Os devs de Java criaram Interfaces como padrão = Connection, Statement, ResulSet, DriverManager
    // as empresas como MySQL, Postgres, MariaDB, adaptassem a conexao a elas
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }
}
