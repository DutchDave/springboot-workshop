# MVE-2: Lijst van films
In deze story gaan we ervoor zorgen dat alle films kunnen worden opgehaald.

## Acceptatie criteria

Als filmliefhebber wil ik een lijst van alle beschikbare films kunnen raadplegen met beperkte informatie. Het endpoint moet er als volgt uitzien (volgorde maakt niet uit):

---
Verzoek:

`GET /films`

Antwoord:

```json
[
    {
        "titel":"The Ususal Suspects",
        "releaseJaar":1995,    
        "id":"123"
    },
    {
        "titel":"Donnie Darko",
        "releaseJaar":2001,
        "id":"456"
    },
    {
        "titel":"Once Upon a Time in the West",
        "releaseJaar":1968,    
        "id":"789"
    }
]
```
---

## Stappenplan

* Pojo voor lijstweergave maken
* Endpoint voor een lijst van Films maken

### LijstItem POJO
Aangezien het antwoord lijkt op een `Film`, maar toch een beperktere set aan gegevens weergeeft, beginnen we met het maken van een POJO die geconstruct kan worden met een `Film`, maar een beperkt aantal getters heeft.

Maak een nieuwe klasse aan in de model package (dezelfde package als de `Film` klasse) die `FilmlijstItem` heet.

Laat de signature van de constructor er als volgt uitzien:
```java
public FilmLijstItem(Film film) {
    ...
```

Zorg ervoor dat deze klasse 3 getters krijgt, namelijk:
* `public String getTitel()`
* `public int getReleaseJaar()`
* `public String getId()`

Zorg ervoor dat de getters de waarden van de `Film`, waarmee deze geconstruct wordt, teruggeeft.

### Endpoint voor een lijst
Maak in de ApiController een nieuwe methode aan die de bestaande `Film`s vertaalt naar de zojuist aangemaakte `FilmLijstItem`s. 

Annoteer deze methode met `@GetMapping` zonder enige argumenten.

De signature van de methode is als volgt:
```java
@GetMapping
public Set<FilmlijstItem> getFilms() {
    ...
```