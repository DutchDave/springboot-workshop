package nl.rechtspraak.springboot.filmapi.doa;

import nl.rechtspraak.springboot.filmapi.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    Optional<Film> findById(int id);

    void deleteById(int id);
}

