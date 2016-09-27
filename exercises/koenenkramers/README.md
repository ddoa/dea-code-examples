Exercise Koenen-Kramers: Adapter & Factory Method
=================================================
Resources
-------------
The following resources are convenient during the exercise:
* Sheets: Design Patterns, Adapter, Factory Method
* Larman, Chapter 26
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account by mailing @rodmidde:
	* http://www.pluralsight.com/courses/design-patterns-on-ramp (Adapter, Factory Method)
	* http://www.pluralsight.com/courses/patterns-library (Adapter, Factory Method)

In this exercise you'll learn:
------------------------------
* how to improve the design of existing software by applying design patterns like Adapter and Factory Method.

Introduction
------------
Doel van deze oefening is het toepassen van een combinatie van design patterns in een software ontwerp en dit vervolgens zelf realiseren.
Stel, een programmeur moet een client class ```TranslateToDutch``` schrijven die een woord uit het Engels naar het Nederlands kan vertalen. Hij wil natuurlijk gebruik maken van een bestaande dictionary als die er is.
Voorlopig maakt hij zich niet druk om een specifieke dictionary. Hij gaat er vanuit dat een dictionary class wel een methode ```translate(String word): String``` zal hebben en dat hij de naam van de dictionary te weten kan komen via een methode ```getName(): String```.

Er worden hem gelukkig door andere ontwikkelaars twee goede dictionary-classes beschikbaar gesteld; een volgens Koenen en een volgens Kramers. Als ```TranslateToDutch``` een verzoek tot vertaling van een woord krijgt laat hij gewoon een dictionary aanmaken. Als een woord niet in de ```KoenenDictionary``` voorkomt moet de andere worden geprobeerd. Als hij het woord niet vindt geeft hij dat aan; vindt hij het woord wel, dan geeft hij de vertaling en de bron weer.
Helaas kennen de classes geen methode ```translate()```: Koenen zoekt met een methode ```lookup(String word): String``` en Kramers met ```find(String word): String.```. Je mag de sourcecode en dus de interface van beide classes niet aanpassen.

Steps
-----
1. Maak een UML design class diagram volgens deze eisen. Pas Adapter, Factory Method en Singleton toe naar analogie van het voorbeeld in [LAR]26.1 t/m 26.5.
2. Bekijk de broncode van de KoenenDictionary en KramersDictionary maar neem de broncode _niet_ op in je project. In plaats daarvan voeg je een Maven-dependency toe:

	```
	<dependency>
    		<groupId>nl.oose.dea.koenenkramers</groupId>
    		<artifactId>dictionaries</artifactId>
    		<version>1.0</version>
	</dependency>
	```
	
	Voeg ook in je pom.xml een extra repository-sectie aan om de dependency te kunnen downloaden:

	```
	<repositories>
       		<repository>
            		<id>github-rody</id>
            		<url>https://raw.githubusercontent.com/ddoa/workshop-koenen-kramers/master/</url>
            		<snapshots>
                		<enabled>true</enabled>
                		<updatePolicy>always</updatePolicy>
            		</snapshots>
        	</repository>
    	</repositories>
	```
3. Door deze library te gebruiken kun je niet meer de broncode aanpassen en is het noodzakelijk te werken met het Adapter-design pattern. Pas dit nu toe in de broncode samen met het Factory Method-design pattern.

Done
----
You can checkout the branch exercise-results for a working project and review possible differences.
