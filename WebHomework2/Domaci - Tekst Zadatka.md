# Mrezno programiranje

## Opis zadatka

Korišćenjem Java socket-a kreirati chat aplikaciju koja omogućava javnu komunikaciju svim konektovanim korisnicima.
Potrebno je kreirati server koji omogućava klijentima konekciju. Nakon uspostavljanja konekcije, potrebna je identifikacija klijenta, tj. server će od svakog novog klijenta zatražiti korisničko ime. Korisničko ime mora biti jedinstveno i nije moguće da u istom trenutku postoji više od jednog klijenta sa istim korisničkim imenom. Nakon definisanja korisničkog imena, konektovani klijent može videti istoriju poruka i slati nove poruke.
Nakon uspešne konekcije i unetok korisničkog imena, u konzoli klijenta odštampati poruku dobrodošlice, a sve ostale konektovane klijente obavestiti o konekciji novog klijenta. Konektovanom klijentu nakon poruke dobrodošlice izlistati istoriju poruka.
Istorija poruka podrazumeva već poslate poruke, njihove autore i datum i vreme slanja. Istorija poruka se čuva u memoriji servera. Maksimalan broj poruka u istoriji je 100 poslednjiih poruka.
Server konstantno čeka nove poruke od klijenata. Svaku dobijenu poruku skladišti u istoriji poruka i nakon toga obaveštava sve ostale konektovane klijente o pristigloj poruci - ažurira istoriju.
Na serveru je potrebno obezbediti predefinisan skup cenzurisanih reči. Potrebno je proveriti svaku poruku i u slučaju da ona sadrži neku od cenzurisanih reči, tu reč je potrebno modifikovati tako da sva slova osim prvog i poslednjeg sadrže karakter zvezdicu - “*”.
Pri dobijanju nove poruke, potrebno je da klijenti istu prikažu u svojoj konzoli u formatu: <Datum i vreme pristigle poruke> - <Korisničko ime klijenta koji je poslao poruku>: <sadržaj poruke>.
Ukoliko dođe do neke greške na serveru/klijentu, potrebno je prekinuti konekciju i ispisati poruku u konzoli.
