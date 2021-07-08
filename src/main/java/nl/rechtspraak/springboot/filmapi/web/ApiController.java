package nl.rechtspraak.springboot.filmapi.web;

import nl.rechtspraak.springboot.filmapi.model.Film;
import nl.rechtspraak.springboot.filmapi.model.FilmlijstItem;
import nl.rechtspraak.springboot.filmapi.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

/**
 * Apicontroller voor de Film-api.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("films")
public class ApiController {

    private FilmService filmService;

    /**
     * Constructor die films aanmaakt.
     */
    public ApiController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public Collection<FilmlijstItem> getFilms() {
        return filmService.getFilms();
    }

    @GetMapping("{id}")
    public Film getFilm(@PathVariable("id") int id) {
        final Optional<Film> zoekResultaat = filmService.getFilm(id);
        if (zoekResultaat.isPresent()) {
            return zoekResultaat.get();
        } else {
            throw new FilmNietGevondenException(id);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Film> setFilm(@PathVariable("id") int id, @RequestBody Film updateFilm) {
        final Optional<Film> optionalFilm = filmService.getFilm(id);
        if (optionalFilm.isPresent()) {
            Film currentFilm = optionalFilm.get();
            currentFilm.setDuur(updateFilm.getDuur());
            currentFilm.setRegisseur(updateFilm.getRegisseur());
            currentFilm.setReleaseJaar(updateFilm.getReleaseJaar());
            currentFilm.setTitel(updateFilm.getTitel());
            currentFilm.addActeurs(updateFilm.getActeurs().toArray(new String[0]));
            filmService.update(currentFilm);
            return new ResponseEntity<>(currentFilm, HttpStatus.ACCEPTED);
        } else {
            throw new FilmNietGevondenException(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable("id") int id){
        final Optional<Film> zoekResultaat = filmService.getFilm(id);
        if (zoekResultaat.isPresent()) {
            filmService.removeFilm(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("DELETE Success!");
        } else {
            throw new FilmNietGevondenException(id);
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<String> createFilm(@PathVariable("id") int id, @RequestBody Film newFilm){
        final Optional<Film> zoekResultaat = filmService.getFilm(id);
        if (zoekResultaat.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Resource already excists!");
        } else {
            newFilm.setId(id);
            filmService.add(newFilm);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Film created!");
        }
    }
}
