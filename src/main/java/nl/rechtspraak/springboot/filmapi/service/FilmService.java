package nl.rechtspraak.springboot.filmapi.service;

import nl.rechtspraak.springboot.filmapi.model.Film;
import nl.rechtspraak.springboot.filmapi.model.FilmlijstItem;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private Set<Film> films = new HashSet<>();

    public void add(Film film){
        films.add(film);
    }

    public Collection<FilmlijstItem> getFilms() {
        return films.stream().map(FilmlijstItem::new).collect(Collectors.toSet());
    }

    public Optional<Film> getFilm(String id) {
        return films.stream().filter((film) -> film.getId().equals(id)).findFirst();
    }

    public void removeFilm(String id) {
        films.removeIf(film -> film.getId().equals(id));
    }

    public void createFilm(Film newFilm) {
        films.add(newFilm);
    }
}
