package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepositoryRowset;

import java.util.List;

public class ProducerServiceRowset {
    public static List<Producer> findByNameJdbcRowset(String name){
        return ProducerRepositoryRowset.findByNameJdbcRowset(name);
    }
}
