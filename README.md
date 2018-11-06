# springboot-workshop

Deze repo is voor de Spring Boot cursus die 8-11-2018 plaats vindt/heeft gevonden. In deze workshop gaat er een Spring Boot applicatie gebouwd worden zodat films op verschillende manieren geserveerd/toegevoegd/verwijderd kunnen worden. Als alle user stories voor deze cursus zijn gebouwd, kan de applicatie films vanuit een database serveren/toevoegen/verwijderen op verschillende manieren.

Voor het deelnemen aan deze cursus moet de volgende software zijn geïnstalleerd en geconfigureerd (op de interne werkplek):

* JDK (8 of hoger)
* IntelliJ Community Edition (of ultimate als je daar een licentie voor hebt)
* Maven (zit bij de IntelliJ installatie, maar binnen het bedrijfsnetwerk is additionele configuratie nodig)
* Postman

## User stories
* [MVE-1: Enkele film ophalen](labs/MVE-1/README.md)
* [MVE-2: Lijst van films](labs/MVE-2/README.md)
* [MVE-3: Lijst kunnen uitbreiden](labs/MVE-3/README.md)
* [MVE-4: Persisteren films](labs/MVE-4/README.md)
* [MVE-5: Verwijderen van films](labs/MVE-5/README.md)
* MVE-6: Verras Dave met een willekeurige film

Films:
```json
[
   {
      "titel":"The Ususal Suspects",
      "releaseJaar":1995,
      "acteurs":[
         "Chazz Palminteri",
         "Kevin Spacey",
         "Gabriel Byrne"
      ],
      "duur":"PT1H46M",
      "regisseur":"Bryan Singer",
      "id":"123"
   },
   {
      "titel":"Donnie Darko",
      "releaseJaar":2001,
      "acteurs":[
         "Jena Malone",
         "Mary McDonnell",
         "Jake Gyllenhaal"
      ],
      "duur":"PT1H53M",
      "regisseur":"Richard Kelly",
      "id":"456"
   },
   {
      "titel":"Once Upon a Time in the West",
      "releaseJaar":1968,
      "acteurs":[
         "Henry Fonda",
         "Charles Bronson",
         "Claudia Cardinale"
      ],
      "duur":"PT2H45M",
      "regisseur":"Sergio Leone",
      "id":"789"
   }
]
```
