package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
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

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementUpdate(conn, producer)) {
            int rowsAffected = ps.executeUpdate();
            log.info("Uptaded producer '{}' in the database. Database rows affected {}", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
//        a ordem aqui é da query, não do banco. Como ? de name é a primeira, indice dela é 1
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }

    public static void saveTransaction(List<Producer> producers) {
//        Simulando varios inserts de uma vez, precisamos gera-los fora try with resources pra nao precisar abrir e fechar conexoes pra cada
        try (Connection conn = ConnectionFactory.getConnection()) {
//            precisamos desabilitar o auto commit para que a transacao seja concluida so se nao der erros
            conn.setAutoCommit(false);
//            aqui preparamos a declaracao
            preparedStatementsaveTransaction(conn, producers);
//            e so depois se der sucesso em todos os inserts, commitamos
            conn.commit();
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producers, e);
            throw new RuntimeException(e);
        }
    }

    private static void preparedStatementsaveTransaction(Connection conn, List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
//        boolean para validar possivel erro e rollback de comandos
        boolean rollback = false;
        for (Producer p : producers) {
//            aqui fazemos o PrepapredStatemnt no try with resources para que seja iterado e aberta 1 e fechada conexao
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                log.info("Saving producer '{}'", p.getName());
                ps.setString(1, p.getName());
//                teste de falha para 1 dos producers
                if (p.getName().equals("White fox")) throw new SQLException("Can't save white fox");
                ps.execute();
            } catch (SQLException e) {
//                mudamos o boolean para chamar o roolback no metodo saveTransaction
                rollback = true;
                log.warn("Transaction is goind to be rollbacked");
                throw new RuntimeException(e);
            }
        }
//        aqui a Exception vai pra saveTransaction, por isso deixamos na assinatura
        if (rollback) conn.rollback();
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
        String sql = "SELECT * FROM anime_store.producer WHERE name like '%s';".formatted("%" + name + "%");
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

    public static void showProducerMetadata() {
        log.info("Showing Producer Metadata");
        String sql = "SELECT * FROM anime_store.producer";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
//            metodo pra pegar metadados do banco
            ResultSetMetaData metaData = rs.getMetaData();
//            aqui retiramos o while  e o next pois usaremos o for
//            numero de colunas para iterar
            int columnCount = metaData.getColumnCount();
            log.info("Columns count '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", metaData.getTableName(i));
                log.info("Column name '{}'", metaData.getColumnName(i));
                log.info("Column size '{}'", metaData.getColumnDisplaySize(i));
                log.info("Column type '{}'", metaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            log.error("Error while trying to find the metadata", e);
        }
    }

    public static void showDriverMetadata() {
        log.info("Showing Driver Metadata");
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("and Supports CONCUR_UPDATABLE");
                }
            }
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("and Supports CONCUR_UPDATABLE");
                }
            }
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("and Supports CONCUR_UPDATABLE");
                }
            }
        } catch (SQLException e) {
            log.error("Error while trying to find the metadata", e);
        }
    }

    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            log.info("Last row? '{}'", rs.last());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("First row? '{}'", rs.first());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Absolute row? '{}'", rs.absolute(2));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Relative row? '{}'", rs.absolute(-1));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Is last? '{}'", rs.isLast());
            log.info("Row number '{}'", rs.getRow());

            log.info("Is First? '{}'", rs.isFirst());
            log.info("Row number '{}'", rs.getRow());

            log.info("----");
            rs.next();
            log.info("After last row? '{}'", rs.isAfterLast());

            while (rs.previous()) {
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        if (!name.equals("")) {
            log.info("Finding by producer name");
        }
        String sql = "SELECT * FROM anime_store.producer WHERE name like '%s';".formatted("%" + name + "%");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
//                Importante que utilizemos tanto updateString quanto updateRow para o ResultSet realizar o Update
                rs.updateString("name", rs.getString("name").toUpperCase());
                rs.updateRow();
                producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        if (!name.equals("")) {
            log.info("Finding by producer name");
        }
        String sql = "SELECT * FROM anime_store.producer WHERE name like '%s';".formatted("%" + name + "%");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
//            movendo o return do fim para o meio
            if (rs.next()) return producers;
//            mover o cursor para a linha após a ultima
            insertNewProducer(name, rs);
            producers.add(getProducer(rs));

        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        String sql = "SELECT * FROM anime_store.producer WHERE name like '%s';".formatted("%" + name + "%");
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                log.info("Deleting '{}'", rs.getString("name"));
                rs.deleteRow();
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        if (!name.equals("")) {
            log.info("Finding by producer name");
        }
//        mudamos a nossa query utilizando "?" como wildcard
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             // Mudamos para PreparedStatement. Ele funciona com SetString em vez de formatted ns String para evitar SQL Injection.
             // Porém teriamos que declara-lo fora juntamente com ResultSet e isso faz perdemos o close() do try with resources.
             // Para resolvermos isso, criamos um metodo para tratar o PreparedStatement
             PreparedStatement ps = preparedStatementFindByName(conn, name);
             // Outra diferença é que o sql já foi pré-compilado no PreparedStatement, logo nao passamos como parametros no ExecuteQuery
             ResultSet rs = ps.executeQuery()) {
//            como nao podemos dar valores dentro dos parametro de try, declaramos fora dele, junto com o ResultSet
            while (rs.next()) {
                producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static List<Producer> findByNameCallableStatement(String name) {
        if (!name.equals("")) {
            log.info("Finding by producer name");
        }
//        mudamos a nossa query utilizando "?" como wildcard
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             CallableStatement cs = callableStatementFindByName(conn, name);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    private static PreparedStatement preparedStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer WHERE name like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
//        Formas de buscar utilizando parte da String
//        ps.setString(1, String.format("%%%s%%",name));
//        ps.setString(1, "%"+name+"%");
        return ps;
    }

    private static CallableStatement callableStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "CALL `anime_store`.`sp_get_producer_byname`(?);";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, name);
//        Formas de buscar utilizando parte da String
//        ps.setString(1, String.format("%%%s%%",name));
//        ps.setString(1, "%"+name+"%");
        return cs;
    }

    private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
        rs.moveToInsertRow();
        rs.updateString("name", name);
        rs.insertRow();
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
//        pelo que entendi, chamamos o beforeFirst() para o cursos ir para antes da primeira linha, que é a linha padrão
        rs.beforeFirst();
//        e depois chamamos o next() é para ir para a primeira linha do ResultSet. Seria como dar um enter no MySQL Workbench e ele salta para a próxima linha
        rs.next();
        return Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
    }
}
