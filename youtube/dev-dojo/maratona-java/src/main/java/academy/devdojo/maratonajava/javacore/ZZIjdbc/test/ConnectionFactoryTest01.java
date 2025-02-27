package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
//        ProducerService.showTypeScrollWorking();
//        ProducerService.findByNameAndDelete("tes");
//        ProducerService.findByNameAndDelete("teste");
//        List<Producer> producers = ProducerService.findByNameAndInsertWhenNotFound("Ghibli");
//        log.info("Producers found '{}'", producers);
        List<Producer> producers2 = ProducerService.findByNameAndInsertWhenNotFound("Bandai Namco");
        log.info("Producers found '{}'", producers2);
    }
}
