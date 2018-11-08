package nl.rechtspraak.springboot.filmapi.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class FilmNietGevondenException extends RuntimeException {
    FilmNietGevondenException(int id) {
        super(String.format("Film met id \"%s\" niet gevonden", id));
    }
}
