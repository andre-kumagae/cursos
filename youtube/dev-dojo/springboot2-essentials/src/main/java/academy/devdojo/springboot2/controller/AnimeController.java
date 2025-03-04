package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// anotacao que retorna String via ResponseBody para o valor Json
@RestController
@RequestMapping("anime")
public class AnimeController {
//    equivalente a acessar //localhost:8080/anime/list
//    Forma obsoleta de declarar
//    @RequestMapping(method = RequestMethod.GET, path = "list")
@GetMapping(path = "list")
    public List<Anime> list(){
        return List.of(new Anime("DBZ"), new Anime("Berserk"));
    }
}
