# MVE-3: Lijst kunnen uitbreiden
In deze story gaan we ervoor zorgen dat een film kan worden toegevoegd.

## Acceptatie criteria

Als filmliefhebber wil ik de lijst van alle beschikbare films kunnen uitbreiden. 

---
Verzoek:

`POST /films`

Body:

```json
{
    "titel":"The Unususal Suspects",
    "releaseJaar":1996,
    "acteurs":[
        "Chazzy Palminteri",
        "Kevin Spacey Jr.",
        "Gabriel Bryne"
    ],
    "duur":"PT1H44M",
    "regisseur":"Bryan Writer",
    "id": 12 // Id geven nu nog even mee(natuurlijk niet mooi, gaan we in de volgende story rechttrekken)
}
```

Antwoord:

`201 Created`

Body:

12

---

## Stappenplan

* Lijst van films en logica naar een service verhuizen
* Endpoint toevoegen voor het aanmaken van films

### Lijst van films en logica naar een service verhuizen

Omdat onze code nu aan het groeien is, is het een goed idee om alle logic m.b.t. de lijst van films in een apart component te plaatsen (t.b.v. onderhoudbaarheid). 

Maak een nieuwe klasse aan in `nl.rechtspraak.springboot.filmapi.service` genaamd `FilmService`. Annoteer deze klasse met `@Service`.

De klass signature ziet er dan als volgt uit:

```java
@Service
public class FilmService {
    ...
}
```

Verplaats alle logica m.b.t. `Film`s naar deze nieuwe klasse en scherm de logica zo veel mogelijk af (bv het ophalen van een film) zodat vanuit de repositry enkel de methode hoeft te worden aangeroepen.

Voeg aan de `ApiController` een instantievariable toe met van het type van de zojuist aangemaakte `FilmService`. Maak ook ene constructor aan in de `ApiController` die de instantievariabele set. Annoteer de construct met `@Autowired`:

```java
public class ApiController {
    private FilmService filmService;

    @Autowired
    public ApiController(FilmService filmService) {
        this.filmService = filmService;
    }
    ...
}
```

Refactor de methoden in de `ApiController` zodat deze de methoden van de `FilmService` aanroepen.

### Endpoint toevoegen voor het aanmaken van films

Maak in de `FilmService` een nieuwe methode aan die een `Film` accepteert als input en de lijst van `Film`s uitbreidt. 

Maak in de `ApiController` een nieuwe methode aan die een film toevoegt door de methode van de `FilmService` aan te roepen. Deze methode moet een Film als input vragen. Annoteer de `Film` uit de input met `@RequestBody`.

Het returnType van de methode is een `ResponseEntity`. Op het moment dat alles goed is gegaan met het toevoegen van de `Film`, geven we een statuscode `201(CREATED)` terug met in de body een hint over waar de resource is aangemaakt, in ons geval het `Id` van de `Film` (het is dus handig als de methode in de service dit als antwoord geeft).

Om een `201` als antwoord te geven kunnen we de volgende methode gebruiken:

```java
ResponseEntity.status(HttpStatus.CREATED).body(id);
```

Annoteer deze methode met `@PostMapping`.

```java
@PostMapping
public ResponseEntity toevoegenFilm(@RequestBody Film film) {
    ...
}
```