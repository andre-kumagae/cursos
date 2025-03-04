package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

// anotacao que retorna String via ResponseBody para o valor Json
@RestController
@RequestMapping("anime")
@Log4j2
//@AllArgsConstructor
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;
//    @Autowired


//    public AnimeController(DateUtil dateUtil) {
//        this.dateUtil = dateUtil;
//    }

    //localhost:8080/anime/list
    @GetMapping(path = "list")
    public List<Anime> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("DBZ"),new Anime("Boku no Hero"), new Anime("Berserk"), new Anime("One Piece"), new Anime("Naruto"));
    }
}
