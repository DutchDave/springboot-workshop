# springboot-workshop

Deze repo is voor de spring-boot cursus die 8-11-2018 plaats vindt/heeft gevonden. In deze workshop gaat er een spring-boot applicatie gebouwd worden die films op verschillende mannieren serveert/toegevoegd/verwijderd kunnen worden. Als alle user stories voor deze cursus zijn gebouwd, kan de applicatie films vanuit een database serveren/toevoegen/verwijderen oper verschillende mannieren.

Voor het deelneem aan deze cursus moet de volgende software zijn geinstalleerd en geconfigureerd(op de interne werkplek):

* JDK(8 of hoger)
* Intellij Community Edition(of ultimate als je daar een licentie voor hebt)
* Maven(Zit bij de intellij installatie, maar binnen het bedrijfsnetwerk is aditionele configuratie nodig)
* Postman

## User stories
* [MVE-1: Enkele film ophalen](labs/MVE-1/README.md)
* [MVE-2: Lijst van films](labs/MVE-2/README.md)
* [MVE-3: Lijst kunnen uitbreiden](labs/MVE-3/README.md)
* MVE-4: Persisteren lijst van films
* MVE-5: Business rules (rating filter)
* MVE-6: Verwijderen van films
* MVE-7: Verras Dave met een willekeurige film

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
