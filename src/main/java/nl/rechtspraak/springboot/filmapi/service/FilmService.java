package nl.rechtspraak.springboot.filmapi.service;

import nl.rechtspraak.springboot.filmapi.doa.FilmRepository;
import nl.rechtspraak.springboot.filmapi.model.Film;
import nl.rechtspraak.springboot.filmapi.model.FilmlijstItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class FilmService {

    @Autowired
    private FilmRepository repository;

    public void add(Film film){
        repository.save(film);
    }

    public Collection<FilmlijstItem> getFilms() {
        Stream<Film> filmStream = StreamSupport.stream(repository.findAll().spliterator(), false);
        return filmStream.map(FilmlijstItem::new).collect(Collectors.toSet());
    }

    public Optional<Film> getFilm(String id) {
        return repository.findById(id);
    }

    public void removeFilm(String id) {
        repository.deleteById(id);
    }

    public void update(Film currentFilm) {
        repository.save(currentFilm);
    }
}
