Exercise: Maven Intro
=====================
Resources
-------------
The following resources are convenient during the exercise:

* Sheets les 1.1: Week 1a - Developing distributed applications
* Sheets les 1.1: Week 1b – Maven
* Sheets les 1.2: Softwarekwaliteit JUnit
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account by mailing @rodmidde:
	* http://www.pluralsight.com/courses/maven-fundamentals (including Maven Dependencies)

In this exercise you'll learn:
------------------------------
* how to create a Maven project from the command line
* how to use Maven projects from the command line and the IDE

Introduction
------------
In het eerste deel van deze maak je handmatig een maven-project aan en integreer je deze in Eclipse. In het tweede deel van deze opdracht leer je een maven-project vanuit eclipse met de m2e plugin te maken.

Alle andere huiswerkopdrachten en het eerste toetspracticum moeten met dergelijke maven-projecten gemaakt worden. Voor het toetspracticum moet je bekend zijn en kunnen werken met de maven command line.

Noot: deze opdracht bevat "gaten" waarbij je zelf e.e.a. moet uitzoeken! Dit is bewust gedaan zodat je gedwongen wordt na te denken over wat je aan het doen bent, we verwachten veel zelfstandigheid van HBO-studenten. Voor je de docent om hulp vraagt, ga eerst zelf op zoek naar wat je kunt doen om je probleem op te lossen.

DEEL 1: command line
--------------------
Benodigdheden: zip met java-bestanden voor deze Maven Intro opdracht.

Stappen:
1. Zorg dat je een java-sdk (1.8) en eclipse hebt geinstalleerd. Docenten hebben deze opdracht getest met de indigo versie van eclipse, als je avontuurlijk bent pak je de nieuwste versie.
2. Installeer maven 3 (maven.apache.org)
3. Handig is als maven in je path staat zodat je deze command line kunt aanroepen. Bekijk de Maven documentatie (http://maven.apache.org/guides/getting-started/windows-prerequisites.html) of de screencast (https://vimeo.com/137879254)
4. Bestudeer zover je dat nog niet gedaan hebt college 1 + literatuur, zodat je een idee hebt wat je aan het doen bent en wat maven is!
5. Maak een nieuw standaard project aan met het commando mvn archetype:generate

  Je krijgt nu een hele lijst met standaard projecten. Kies quickstart. Waarschijnlijk is dat het default nummer wat al staat ingesteld.

6. Je ziet mogelijk nu een lange lijst van verschillende types projecten, zo ja druk dan op ENTER, je kiest nu de default (maven-archetype-quickstart); zo nee ga dan naar de volgende stap. 
7. Kies uit het lijstje van verschillende versies de nieuwste (op het moment van schrijven deze oefening is dat 1.1)
8. Kies als groupid een goede default package naam (bijv nl.ica.oose.dea)
9. kies als artifactId een projectnaam (bijv MavenIntro)
10. Importeer in eclipse: Import Existing Maven Projects into Workspace. Als je kiest voor het vinkje “Copy project into workspace” let dan op dat je straks mvn in de goede folder (workspace-folder/project-naam) uitvoert.
11. Er bestaat een kans dat het niet werkt omdat eclipse je maven repository niet kent. Fix het M2_REPO classpath variable in eclipse. (mvn kan dit voor je doen, zoek zelf uit hoe)
12. Upgrade "the maven way" (dus zonder zelf jars te downloaden) junit naar versie 4.11. TIP: als je de POM.xml aanpast, heb je het commando mvn eclipse:eclipse in de command line nodig zodat je dependencies aangepast worden. We zullen in Deel 2 zien dat dit handiger kan.
13. Plaats de java bestanden uit de zip in je project. Je mag ze niet aanpassen met uitzondering van de packagenaam, zorg dat het project compileert. Let op: classes die eindigen op Test(s) moeten in de test map!
14. Met "mvn exec:java -Dexec.mainClass="nl.han.ica.mavenintro.App" kun je een klasse waar een main-methode instaat uitvoeren (in dit voorbeeld is dat de klasse nl.han.ica.mavenintro.App). Er zijn een aantal van deze klassen. Welke? Probeer dit uit.
15. Op http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html staat de maven lifecyle beschreven. Zorg dat validate, compile, test en package werken zonder fouten!

Gefeliciteerd! Je hebt het eerste maven project aan de praat, en werkend in Eclipse! Dankzij de POM.xml kan iedereen met maven en java je project compileren, testen, draaien, packagen. Ook kan dit volledig automatisch, op bijvoorbeeld een build server!

DEEL 2: maven vanuit Eclipse
----------------------------
1. Zorg dat DEEL 1 werkt en dat je alles begrijpt!
2. Selecteer File -> New Project en dan Maven Project. Als je deze optie niet beschikbaar hebt installeer dan eerst de M2E plugin met het "install new software"-menu item in eclipse
3. Maak exact hetzelfde project (met een iets andere naam) als in DEEl 1, dus ook met de 4.11 versie van JUnit en de java-bestanden. Gebruik alleen eclipse. Wat gebeurt er nu als je de POM.xml verandert?

Done
----
For this exercise we have no example results available.
