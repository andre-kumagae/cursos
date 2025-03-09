package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.AnimeCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

// inicializacao mais rapida sem precisar inicializar o Spring Boot toda vez
@ExtendWith(SpringExtension.class)
class AnimeControllerTest {
    // testar a classe em si
    @InjectMocks
    private AnimeController animeController;
    // testar as classes dentro da classe acima
    @Mock
    private AnimeService animeServiceMock;

    @BeforeEach
    void setUp() {
        PageImpl<Anime> animePage = new PageImpl<>(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeServiceMock.listAll(ArgumentMatchers.any()))
                .thenReturn(animePage);
    }

    @Test
    @DisplayName("List returns list of anime inside page object when sucessful")
    void list_ReturnsListOfAnimeInsidePageObject_WhenSucessful() {
//        cria um objeto com nome e id de AnimeControllerTest
        String expectedName = AnimeCreator.createValidAnime().getName();
//        listar Animes sem parametro de paginacao
        Page<Anime> animePage = animeController.list(null).getBody();
//        testar se anime nao e nulo
        Assertions.assertThat(animePage).isNotNull();
//        testar se lista de anime nao esta vazia e se possui 1 elemento
        Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);
//        testar se o anime adicionado e igual ao anime esperado
        Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
    }
}