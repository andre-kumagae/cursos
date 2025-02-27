package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepositoryRowset;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerServiceRowset;
import lombok.extern.log4j.Log4j2;

import java.util.List;
@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        List<Producer> producers = ProducerServiceRowset.findByNameJdbcRowset("NHK");
        log.info("Producer found '{}",producers);
    }
}
