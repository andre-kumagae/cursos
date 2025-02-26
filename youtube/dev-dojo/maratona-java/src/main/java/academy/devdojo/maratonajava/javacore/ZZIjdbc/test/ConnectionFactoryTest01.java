package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
//        Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producerToUpdate = Producer.builder().name("MADHOUSE").id(1).build();
//        ProducerService.save(producer);
        ProducerService.update(producerToUpdate);
//        ProducerService.delete(3);
//        ProducerService.delete(4);
//        ProducerService.delete(5);
//        ProducerService.delete(6);
    }
}
