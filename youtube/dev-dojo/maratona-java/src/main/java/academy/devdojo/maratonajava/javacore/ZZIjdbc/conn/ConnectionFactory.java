package academy.devdojo.maratonajava.javacore.ZZIjdbc.conn;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.RowSetWarning;
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

    public static JdbcRowSet getJdbcRowset() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);
        return jdbcRowSet;
    }

    public static CachedRowSet getCachedRowset() throws SQLException {
//        como é um banco offline, nao precisamos configurar a url para conexao
        return RowSetProvider.newFactory().createCachedRowSet();
    }
}
