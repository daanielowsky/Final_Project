<h1>Oferty lokalne Sellout

Na tym repozytorium znajduje się projekt strony na oferty lokalne.

"Funkcjonalności":

* Logowanie,
* Rejestracja,
* Spersonalizowany profil,
* Zdjęcia profilowe,
* 10 Kategorii do zamieszczanych ofert,
* Zdjęcie wystawianego produktu,
* Możliwość komentowania profili użytkowników,
* Wyszukiwarka ofert po nazwach i kategoriach.

Całość owinięta w piękną szatę graficzną.

<h2>Przed startem

* Utwórz bazę danych "finalproject" lub spersonalizuj pod swoją bazę danych w pliku ```/Final_Project/src/main/resources/application.properties```
* Dodaj kategorie w bazie danych poprzez to Query:
```
insert into category(name) values
("Motoryzacja"),
("Dom i ogród"),
("Elektronika"),
("Moda"),
("Rolnictwo"),
("Zwierzęta"),
("Dla dzieci"),
("Sport"),
("Muzyka"),
("Za darmo");
```