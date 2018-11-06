# MVE-5: Verwijderen van films
In deze story gaan we het mogelijk maken een film uit de lijst te verwijderen.

## Acceptatie criteria

Als filmcriticus wil ik de lijst van alle beschikbare films kunnen inkrimpen. 

---
Verzoek:

`DELETE /films/123`


Antwoord:

`202 Accepted`

---

## Stappenplan

* Endpoint toevoegen voor het verwijderen van een film


### Endpoint toevoegen voor het verwijderen van een film

Maak in de `FilmService` een nieuwe methode aan die een `Film.id` accepteert als input en een film verwijdert uit de lijst van `Film`s. 

Maak in de `ApiController` een nieuwe methode aan die een film verwijdert door de methode van de `FilmService` aan te roepen. Deze methode moet een `Film.id` als input vragen.

Het returnType van de methode is een `ResponseEntity`. Op het moment dat alles goed is gegaan met het verwijderen van de `Film`, geven we een statuscode `202(ACCEPTED)` terug met in de body een melding dat de film succesvol is verwijderd.

Om een `202` als antwoord te geven kunnen we de volgende methode gebruiken:

```java
ResponseEntity.status(HttpStatus.ACCEPTED).body("DELETE Success!");
```

Annoteer deze methode met `@DeleteMapping`.

```java
@DeleteMapping("{id}")
public ResponseEntity deleteFilm(@PathVariable("id") String id) {
    ...
}
```