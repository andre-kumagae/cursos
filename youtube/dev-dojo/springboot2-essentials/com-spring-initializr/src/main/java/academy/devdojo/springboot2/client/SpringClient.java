package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 2);
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);

        log.info(object);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);

        log.info(Arrays.toString(animes));
        //@formatter:off
        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});
        //@formatter:on
        log.info(exchange.getBody());

//        Anime kingdom = Anime.builder().name("Kingdom").build();
//        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes", kingdom, Anime.class);
//        log.info("Saved anime: {}", kingdomSaved);

        Anime samuraiChampoloo = Anime.builder().name("Samurai Champloo").build();
        ResponseEntity<Anime> samuraiChampolooSaved = new RestTemplate().exchange("http://localhost:8080/animes", HttpMethod.POST, new HttpEntity<>(samuraiChampoloo, createJsonHeader()), Anime.class);
        log.info("Saved anime: {}", samuraiChampolooSaved);

        // pegamos o body json
        Anime updatedAnime = samuraiChampolooSaved.getBody();
        // alterando o nome
        updatedAnime.setName("Samurai Champloo 2");
        // retorno void conforme metodo em service
        ResponseEntity<Void> samuraiChampolooUpdated = new RestTemplate().exchange("http://localhost:8080/animes", HttpMethod.PUT, new HttpEntity<>(updatedAnime, createJsonHeader()), Void.class);
        log.info("Saved anime: {}", samuraiChampolooUpdated);

        // HttpEntity null e ultimo metodo para pegar o id
        ResponseEntity<Void> samuraiChampolooDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}", HttpMethod.DELETE, null, Void.class, updatedAnime.getId());
        log.info("Saved anime: {}", samuraiChampolooDeleted);




    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}