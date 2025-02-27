package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepositoryRowset;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerServiceRowset;
import lombok.extern.log4j.Log4j2;

import java.util.List;
@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
//        List<Producer> producers = ProducerServiceRowset.findByNameJdbcRowset("NHK");
        Producer producer = Producer.builder().id(1).name("MAD").build();
        ProducerServiceRowset.updateJdbcRowset(producer);
        log.info("Producer updated '{}'",producer);
//        List<Producer> producers = ProducerRepositoryRowset.findByNameJdbcRowset("");
//        log.info("Producer found '{}",producers);
    }
}
