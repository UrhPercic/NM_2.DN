# Numerična matematika DN 2

## Avtor
- Urh Perčič
- 63230481

## Opis
Projekt omogoča izračune z dvema ključnima metodama: baricentrično interpolacijo in iskanje kvantilov za standardno normalno porazdelitev. Glavni cilj je omogočiti izračun interpoliranih vrednosti za poljubne funkcije ter izračun kvantilov, ki so ključnega pomena v statistiki in verjetnosti.

### Značilnosti:
- **Generiranje Čebiševljevih točk:** Uporablja se za polinomsko interpolacijo.
- **Baricentrična interpolacija:** Učinkovita metoda za izračun interpoliranih vrednosti funkcij.
- **Izračun kvantilov:** Implementacija Newton-Raphsonove metode za iskanje kvantilov standardne normalne porazdelitve.
- **Numerična integracija:** Uporaba Simpsonovega pravila za izračun kumulativne porazdelitvene funkcije.

## Struktura
- `src/main/java/org/example/Interpolation.java`: Vsebuje logiko za generiranje Čebiševljevih točk in izvajanje baricentrične interpolacije.
- `src/main/java/org/example/QuantileCalculator.java`: Vsebuje metode za izračun kvantilov z uporabo Newton-Raphsonove metode in Simpsonovega pravila.
- `src/test/java/org/example/Test.java`: Vsebuje teste za preverjanje pravilnosti in učinkovitosti interpolacijske metode in metode za izračun kvantilov.

## Uporaba kode
- **Zgradite projekt z Maven:** `mvn clean install`
- **Zaženite interpolacijski razred:** `java -cp target/classes org.example.Interpolation`
- **Zaženite kvantilni kalkulator:** `java -cp target/classes org.example.QuantileCalculator`

## Poganjanje testov
- Za izvedbo testov uporabite Maven: `mvn test`
