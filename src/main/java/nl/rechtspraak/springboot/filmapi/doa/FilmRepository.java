package nl.rechtspraak.springboot.filmapi.doa;

import nl.rechtspraak.springboot.filmapi.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, String> {

}

