package academy.devdojo.springboot2essentials.service;

import academy.devdojo.springboot2essentials.domain.Anime;
import academy.devdojo.springboot2essentials.repository.AnimeRepository;
import academy.devdojo.springboot2essentials.request.AnimeDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Service
@Builder
public class AnimeService {
    private final AnimeRepository animeRepository;



    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findById(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimeDto animeDto) {
        Anime anime = Anime.builder().name(animeDto.getName()).build();
        return anime;
    }

//    public void delete(long id) {
//        animes.remove(findById(id));
//    }
//
//    public void replace(Anime anime) {
//        delete(anime.getId());
//        animes.add(anime);
//    }
}
