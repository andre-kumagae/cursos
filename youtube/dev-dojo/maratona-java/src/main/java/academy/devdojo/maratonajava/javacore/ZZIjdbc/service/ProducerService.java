package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;

import java.util.List;

public class ProducerService {
    public static void save(Producer producer) {
        ProducerRepository.save(producer);
    }

//    utilizando wrapper class para evitar redundancia do teste id == null
    public static void delete(Integer id) {
//        validacao de id ter que ser 1 ou maior
        requireValidId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer) {
//        validacao de id ter que ser 1 ou maior
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    //    Como funciona como um getter, nao precisamos validar e nem de parâmetros. Apenas ter o return
    public static List<Producer> findAll() {
       return ProducerRepository.findAll();
    }

//    Aqui precisa receber a String de parametro
    public static List<Producer> findByName(String name) {
        return ProducerRepository.findByName(name);
    }

    public static void showProducerMetadata() {
        ProducerRepository.showProducerMetadata();
    }

    // criando metodo validador de id para evitar repeticao de codigo
    private static void requireValidId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }
    }
}
