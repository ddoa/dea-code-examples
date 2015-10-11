Exercise RMI, Threads and JUnit: Sorting
========================================
Resources
-------------
The following resources are convenient during the exercise:
* Sheets Threads
* Sheets RMI
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account by mailing @rodmidde:
	* http://www.pluralsight.com/courses/ads2 (only Sorting Algorithms)
	* http://www.pluralsight.com/courses/java2

In this exercise you'll learn:
------------------------------
* how to use the thread API in a slightly bigger context
* how to use the RMI API in a slightly bigger context
* how to combine threads and RMI to build a small distributed application

Introduction
------------
In deze opgave maak je een gedistribueerde sorteermachine gebruikmakend van Java RMI, Threads, Unit Testing en Maven. In deze oefening zijn de belangrijkste ontwerponderdelen beschreven om te kunnen komen tot een implementatie van deze gedistribueerde applicatie. Dit document dient als leidraad voor de bouw van deze specifieke applicatie.

Er wordt een rij van willekeurige elementen gecreëerd en een vast aantal (2) remote objecten die kunnen sorteren. Alvorens te gaan sorteren wordt de rij elementen in 2 stukken gehakt en elk stuk wordt door een remote object gesorteerd en gesorteerd teruggegeven:

![Alt text](images/sorter-steps.png)

Bovenstaand voorbeeld maakt gebruik van een invoer ter lengte van twaalf en twee (gedistribueerde) sorteerdeers. Daarnaast zie je dat er wordt uitgegaan van een bepaald bereik van getallen waarbij een soort voorsortering wordt gedaan alvorens de sortering parallel plaatsvinden.

Requirements
------------
* De applicatie is command-line based, geen GUI dus.
* De sorteeralgoritmen moeten arrays van Integers sorteren, andere types hoeven niet.
* Gebruik een bestaand sorteeralgoritme van internet (vermeld de bron in je code) of gebruik de in Java ingebouwde API: Collections.sort of Arrays.sort. Besteed dus geen tijd aan het bouwen van een eigen algoritme.

Steps
-----
1.	Maak een nieuw Maven Project aan.
2.	Maak eerst de interface ```ISorter```. Voeg een methode doe die een List van Integer als invoer krijgt en een ```List``` van ```Integer``` als uitvoer.
3.	Maak nu een nieuwe lege klasse met de naam van jouw sorteeralgoritme en zorg dat de klasse aan de interface ```ISorter``` voldoet.
4.	Schrijf JUnit tests voor je de implementatie op zoekt en/of inbouwt. Wat verwacht je dat de sorter doet met een lege lijst? Wat doet de sorter bij een null? Wat doet de sorter als de lijst al gesorteerd is? Houd dus rekening met een aantal cases waar jouw gekozen algoritme tegen moet kunnen.
5.	Nadat je de JUnit test hebt gemaakt voeg je de implementatie van internet of de Java API toe. Run je unittests en bekijk of alle tests groen zijn, zo niet, fix je code!
6.	Maak een klasse ```SortServer``` met een ```main```-methode die twee instanties van de ```Sorter``` implementatie maakt en registreert bij de RMI Registry onder unieke namen, bijvoorbeeld sorter1 en sorter2.
7.	Maak nu een nieuwe klasse aan ```SortClient``` met een ```main``` methode en een methode ```sort``` (zonder parameters en ```void``` als return type). Laat de ```main``` methode een nieuwe instantie van ```SortClient``` maken en hierop de functie ```sort``` aanroepen.
8.	Implementeer de ```sort```-methode van ```SortClient``` door een ```Integer``` ```List``` te declareren en te initialiseren met een vaste lijst van 20 verschillende ```Integer``` waarden. Roep de ```sort```-methode aan op een van de server objecten (bijv. “sorter1”) met als argument de lijst van 20 ```Integers```. Druk het resultaat van het sorteren af en controleer dat de lijst gesorteerd terug komt.
9.	Optioneel: Vervang de lijst van 20 ```Integers``` door random lijst van een aantal ```Integers``` die door een nieuwe functie ```generateRandom``` geretourneerd wordt, de lengte van de lijst moet via een parameter aan ```generateRandom``` mee te geven zijn:

  ```java
  private Integer[] generateRandomIntegers(int length) {

  }
  ```

10. Optioneel: Implementeer de methode en test de sorteermachine opnieuw waarbij je de length-parameter laat variëren van 10,100,1000 tot 10000.  Je code moet dus in staat zijn om snel een lijst van 10000 willekeurige Integers op te leveren.
11.	Tot nu toe heeft het nog geen zin gehad de lijsten remote te laten sorteren, het wordt tijd om echt gedistribueerd te gaan werken. Implementeer een scheidingsalgoritme op basis van bovenstaande figuur dat een lijst van Integer-waarde van willekeurige lengte kan opsplitsen tot meerdere kleine lijstjes met Integer-waarden. Deze kleine lijstjes kunnen elk na elkaar (gebruik nog geen multithreading) aan een remote Sorter gegeven worden, waarna alle gesorteerde lijstjes door de client eenvoudig achter elkaar geplakt kunnen worden:

  ```java
  Integer[] list = generateRandom(1000);
  Comparable[][] lists = spliceList(list);
  for(int i=0;i< lists.size();i++)
  {
    	ISorter sorter = (ISorter) Naming.lookup(“sorter”+i);
    	Integer[] result = sorter.sort(lists.get(i));
    	join(result);
  }
  ```
12.	Je ziet in het voorbeeld dat alle sub-lijstjes achter elkaar gestuurd worden, hiermee komen ze ook achterelkaar weer terug waardoor ze in een functies als join weer achterelkaar gevoegd kunnen worden. Maak de functies splice en join en maak deze functionaliteit werkend. Test eerst voor je verder gaat.  
13.	Alhoewel we gedistribueerd werken hebben we nog weinig winst: alle sorteertaakjes worden achter elkaar uitgevoerd. Maak de functionaliteit van stap 9 nu multithreaded. Hierdoor wordt er niet gewacht op het eerste lijstje voor het versturen van het tweede lijstje. Het kan dus zijn dat de volgorde waarin de lijsten worden verstuurd anders is dan waarop ze ontvangen worden, de lijsten zullen niet allemaal even lang zijn (en er zijn andere factoren die de werking beïnvloeden zoals het netwerk en de snelheid van de remote sorter). De retournerende lijstjes kunnen dus niet zomaar achterelkaar geplakt worden.

  a.	Implementeer in elke te sorteren lijst een volgnummer.

  b.	Maak de join methode zo dat hij de gesorteerde deellijst bewaart in een tijdelijke array, bijvoorbeeld door de index indeze array te laten corresponderen met het volgnummer: lijstje 0 komt op plek 0, lijstje 1 komt op plek 1. Pas als beiden binnen zijn druk je de hele lijst af.  

14.	Vermoedelijk heb je alle code in 1 package gestopt. Verbeter de packageindeling, bijvoorbeeld door na te denken over welke klassen/interfaces bij elkaar horen en welke niet (of minder). Welke klassen zijn nodig op de client, welke op de server, welke klassen/interfaces zijn gedeeld?

Done
----
You can checkout the branch exercise-results for a working project and review possible differences.
