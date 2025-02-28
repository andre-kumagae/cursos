package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;

import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {

    public static List<Producer> findByName(String name) {
        log.info("Finding producer by name '{}", name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementfindByName(conn, name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    private static PreparedStatement createPreparedStatementfindByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer WHERE name like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + name + "%");
        return ps;
    }

    public static void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementDelete(conn, id)) {
//            execute() é utilizado para qualqer comando e retorna boolean
//            executeUpdate() só pdoe ser com UPDATE, INSERT ou DELETE e retorna int
            ps.execute();
            log.info("Deleted producer '{}' in the database.", id);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", id, e);
//            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPreparedStatementDelete(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void save(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createpreparedStatementSave(conn, producer)) {
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) log.info("Saving producer '{}'", rs.getInt(1));
            log.info("Updated producer '{}' in the database", producer.getName());
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createpreparedStatementSave(Connection conn, Producer producer) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, producer.getName());
        return ps;
    }

}
