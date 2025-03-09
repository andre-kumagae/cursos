package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import jakarta.validation.ConstraintViolationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;
    @Test
    @DisplayName("Save creates an anime when it's successful")
    void save_PersistAnime_WhenSuccessful() {
        Anime animeTobeSaved = createAnime();
        Anime savedAnime = this.animeRepository.save(animeTobeSaved);
        Assertions.assertThat(savedAnime).isNotNull();
        Assertions.assertThat(savedAnime.getId()).isNotNull();
        Assertions.assertThat(savedAnime.getName()).isEqualTo(animeTobeSaved.getName());
    }

    // update
    @Test
    @DisplayName("Update creates an anime when it's successful")
    void update_PersistAnime_WhenSuccessful() {
        Anime animeTobeSaved = createAnime();
        Anime savedAnime = this.animeRepository.save(animeTobeSaved);
        savedAnime.setName("Overlord");
        Anime updatedAnime = this.animeRepository.save(animeTobeSaved);
        Assertions.assertThat(updatedAnime).isNotNull();
        Assertions.assertThat(updatedAnime.getId()).isNotNull();
        Assertions.assertThat(updatedAnime.getName()).isEqualTo(animeTobeSaved.getName());
    }

    // delete
    @Test
    @DisplayName("Delete removes an anime when it's successful")
    void delete_RemovesAnime_WhenSuccessful() {
        Anime animeTobeSaved = createAnime();
        Anime savedAnime = this.animeRepository.save(animeTobeSaved);
        this.animeRepository.delete(savedAnime);
        Optional<Anime> optionalAnime = this.animeRepository.findById(savedAnime.getId());
        Assertions.assertThat(optionalAnime).isEmpty();
    }

    // find by name
    @Test
    @DisplayName("Find By Name Returns a List of Name when it's successful")
    void findByName_ReturnListOfAnimes_WhenSuccessful() {
        Anime animeTobeSaved = createAnime();
        Anime savedAnime = this.animeRepository.save(animeTobeSaved);
        List<Anime> animes = this.animeRepository.findByName(savedAnime.getName());
        Assertions.assertThat(animes).isNotEmpty();
        Assertions.assertThat(animes).contains(savedAnime);
    }


    // find by name return empty list
    @Test
    @DisplayName("Find By Name Returns an Empty List when an ANime is not found")
    void findByName_ReturnEmptyList_WhenAnimeIsNotFound() {
        List<Anime> notAnAnime = this.animeRepository.findByName("not an anime");
        Assertions.assertThat(notAnAnime).isEmpty();
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void save_ThrowConstraintViolationException_WhenNameIsEmpty() {
        Anime anime = new Anime();
        // comparando pelo metodo se é instancia da excecao
//        Assertions.assertThatThrownBy(() -> this.animeRepository.save(anime)).isInstanceOf(ConstraintViolationException.class);

        // comparando se a excecao e lançada pelo metodo
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.animeRepository.save(anime))
                .withMessageContaining("The anime name cannot be empty");
    }

    private Anime createAnime() {
        return Anime.builder()
                .name("Hajime no Ippo")
                .build();
    }
}