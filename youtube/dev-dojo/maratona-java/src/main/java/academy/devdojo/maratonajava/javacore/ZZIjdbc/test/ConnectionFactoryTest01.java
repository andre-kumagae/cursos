package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
//        Producer producer = Producer.builder().name("Studio Deen").build();
//        Producer producerToUpdate = Producer.builder().name("MADHOUSE").id(1).build();
//        ProducerService.save(producer);
//        ProducerService.update(producerToUpdate);
        List<Producer> producerList1 = ProducerService.findAll();
        log.info("Producers found '{}'", producerList1);
        List<Producer> producerName = ProducerService.findByName("Mad");
        log.info("Producers found '{}'", producerName);
//        ProducerService.delete(3);
//        ProducerService.delete(4);
//        ProducerService.delete(5);
//        ProducerService.delete(6);
    }
}
