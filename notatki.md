1. Jaki pierwszy test - szczesliwa sciezka jest dobrym poczatkiem, potem sciezki poboczne
2. kategorycazcja wejsc
3. testng - pozwala na latwiejssza paraametryzacje niz JUnit, dziala na android

1. Zlozononosc kodu -> FP/OOP bo eliminujemy stan
2. Krotkie metody - takie zeby zaslonic reka, JIT skompiluje krotka do kodu natywnego
3. Sciezki przejscia przez metody

### 
Szablony testow - aaa / gwt

### Maven
cykle zycia - clean / build / sight | fazy
najpierw kompilacja -> testowanie -> weryfikacja -> instalacja

mvn test -> wszystkie fazy do wlacznie test -> wywolanie wszystkich testow

### Podsumowniae 
Kent Beck
Tomasz Kaczanowski
Micheal Feathers
Laurent Bossavit - testy charakteryzacyjne
Nat Pryce, Stave Freeman
misko hevery

observator / visitor / bus - wzorce do obczajenia zeby wypierdolic managera

fairy - wrozka do locsowania danych

### Mocki
1. wydmuszka - nie wolajcie nie tykajcie bo sie zlamie
	wzorzec NullObject

2. zaslepka - jak cos trzeba zawolac
	return cokolwiek

3. kadlubel / szkielecik - minimum metod zeby sie nie wyjebalo
	kadlub z klasy

4. flaszywka - prosty generator dokumentow
   wytaczana z reki

5. podrobka wlasciwa - ma jakas (prosta) implemntacje
6. szpieg - owijka na obiekt
	bierze prawdziwy obiekt

## wygenereowane equals() tostring() hashcode() tez nalezy sprawdzic


### TestNG
1. Grupy testow
2. wielowatkowosc - 

## Oprogramowanie ktore sprawdza reke pokerowa

Sprawdzic wartosc reki,
Porownanie wartosci dwoch rak


nazwa	przykład	opis
poker królewski
	as, król, dama, walet, 10 wszystkie w jednym kolorze
poker		pięć kolejnych kart w jednym kolorze
kareta 
	cztery karty tej samej wartości
ful		trzy karty tej samej wartości i para
kolor		pięć kart w jednym kolorze
strit
	pięć kolejnych kart
trójka		trzy karty tej samej wartości
dwie pary
	dwie różne pary 
para 
	dwie karty tej samej wartości 
najwyższa karta 
	pięć kart nie spełniających żadnego z powyższych kryteriów
