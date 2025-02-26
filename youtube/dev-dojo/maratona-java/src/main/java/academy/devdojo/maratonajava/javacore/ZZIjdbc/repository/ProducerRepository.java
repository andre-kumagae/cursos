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
//        Fazendo um select que retorna dados já declarados na query
        String sql = "SELECT id, name FROM anime_store.producer;";
//        criamos uma List para receber os valores de select
        List<Producer> producers = new ArrayList<>();
//             adicionamos a classe resultSet ao try with resources
//             com isso conn cria a conexao, stmt cria a query e rs a executa ja com o retorno do select
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
//                Temos a opção de declarar linha a linha com variáveis ou em 1 linha

//                Declarando linha a linha

//                aqui podemos usar o indice, porem se atente que o primeiro indice é 1, nao 0. Ex.:  rs.getInt(1);
//                var id = rs.getInt("id");
//                var name = rs.getString("name");
//                Producer producer = Producer.builder().id(id).name(name).build();
//                producers.add(producer);

//                Declarando sem variaveis em 1 linha

                producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
//        aqui retornamos a lista vazia em vez de dar uma condicao de return null pois é mais chato de tratar
        return producers;
    }
}
