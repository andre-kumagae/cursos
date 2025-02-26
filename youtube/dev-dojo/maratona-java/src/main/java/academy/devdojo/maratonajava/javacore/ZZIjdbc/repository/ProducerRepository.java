package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' in the database. Database rows affected {}", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to inser producer '{}'", producer.getName(), e);
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' in the database. Database rows affected {}", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", id, e);
            throw new RuntimeException(e);
        }
    }

    public static void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%d');"
                .formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Uptaded producer '{}' in the database. Database rows affected {}", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> findAll() {
        log.info("Finding all producers");
        return findByName("");
    }

    public static List<Producer> findByName(String name) {
//        adicionei essa condicional para nao mostrar no log de findAll 2 vezes
        if (!name.equals("")) {
            log.info("Finding by producer name");
        }
// No MySQL, a query é essa: SELECT * FROM anime_store.producer WHERE name like "%%";
//        Podemos declarar a própria porcentagem como caracter de escape:
//        String sql = "SELECT * FROM anime_store.producer WHERE name like %%%s%%;".formatted(name);
//        Onde temos 1 escape para %, outro para %s e o ultimo para %
//        Ou colocar no formatted, que ficaria mais legivel
        String sql = "SELECT * FROM anime_store.producer WHERE name like '%s';".formatted("%"+name+"%");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }
}
