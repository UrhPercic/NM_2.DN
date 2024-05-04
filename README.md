# Numerična matematika DN 2.

## Avtor
- [Urh Perčič]
- [63230481]

## Opis
Projekt omogoča implementacijo metode baricentrične interpolacije za numerične izračune z uporabo Čebiševljevih točk. Glavni cilj je omogočiti izračun interpoliranih vrednosti za funkcijo, ki jo določi uporabnik, z uporabo učinkovite metode polinomske interpolacije.

- Generiranje Čebiševljevih točk.
- Izračun interpoliranih vrednosti z uporabo baricentrične formule.
- Enote testov za preverjanje natančnosti in funkcionalnosti interpolacije.

## Struktura
- src/main/java/org/example/Interpolation.java: Vsebuje logiko za generiranje Čebiševljevih točk in izvajanje baricentrične interpolacije.
- src/test/java/org/example/Test.java: Vsebuje teste za preverjanje pravilnosti in učinkovitosti interpolacijske metode.

## Uporaba kode
- Zgradite projekt z Maven: `mvn clean install`
- Zaženite glavni razred: `java -cp target/classes org.example.Interpolation`

## Poganjanje testov
- Za izvedbo testov uporabite Maven: `mvn test`

