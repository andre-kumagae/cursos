package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;

public class ProducerService {
    public static void save(Producer producer) {
        ProducerRepository.save(producer);
    }
    public static void delete(int id) {
//        validacao de id ter que ser 1 ou maior
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }
        ProducerRepository.delete(id);
    }
}
