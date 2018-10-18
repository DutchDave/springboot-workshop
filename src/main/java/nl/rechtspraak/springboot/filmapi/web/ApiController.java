package nl.rechtspraak.springboot.filmapi.web;

import nl.rechtspraak.springboot.filmapi.model.Film;
import nl.rechtspraak.springboot.filmapi.model.FilmlijstItem;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Apicontroller voor de Film-api.
 */
@RestController
@RequestMapping("films")
public class ApiController {
    private Set<Film> films = new HashSet<>();

    /**
     * Constructor die films aanmaakt.
     */
    public ApiController() {
        maakFilms();
    }

    private void maakFilms() {
        final Film film1 = new Film();
        film1.setTitel("The Ususal Suspects");
        film1.setReleaseJaar(1995);
        film1.setDuur(Duration.ofMinutes(106));
        film1.setRegisseur("Bryan Singer");
        film1.addActeurs("Kevin Spacey", "Gabriel Byrne", "Chazz Palminteri");
        film1.setId("123");

        final Film film2 = new Film();
        film2.setTitel("Donnie Darko");
        film2.setReleaseJaar(2001);
        film2.setDuur(Duration.ofMinutes(113));
        film2.setRegisseur("Richard Kelly");
        film2.addActeurs("Jake Gyllenhaal", "Jena Malone", "Mary McDonnell");
        film2.setId("456");

        films.add(film1);
        films.add(film2);
    }

    @GetMapping
    public Collection<FilmlijstItem> getFilms() {
        return films.stream().map(FilmlijstItem::new).collect(Collectors.toSet());
    }

    @GetMapping("{id}")
    public Film getFilm(@PathVariable("id") String id) {
        final Optional<Film> zoekresultaat = films.stream().filter((film) -> film.getId().equals(id)).findFirst();
        if(zoekresultaat.isPresent()) {
            return zoekresultaat.get();
        } else {
            throw new FilmNietGevondenException(id);
        }
    }

    @PutMapping("{id}")
    public Film setFilm(@PathVariable("id") String id, @RequestBody Film updateFilm) {
        final Optional<Film> optionalFilm = films.stream().filter((film) -> film.getId().equals(id)).findFirst();
        if(optionalFilm.isPresent()) { // Updaten
            Film currentFilm = optionalFilm.get();
            currentFilm.setDuur(updateFilm.getDuur());
            currentFilm.setRegisseur(updateFilm.getRegisseur());
            currentFilm.setReleaseJaar(updateFilm.getReleaseJaar());
            currentFilm.setTitel(updateFilm.getTitel());
            currentFilm.addActeurs(updateFilm.getActeurs().toArray(new String[0]));
            return currentFilm;
        } else { // Aanmaken
            updateFilm.setId(id);
            films.add(updateFilm);
            return updateFilm;
        }


    }
}
