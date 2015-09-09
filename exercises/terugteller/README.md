Exercise RMI Terugteller
=========================
Resources
-------------
The following resources are convenient during the exercise:

* Sheets: RMI

In this exercise you'll learn:
------------------------------
* how to use interfaces
* how to build a RMI client and server
* how to provide a remote object to a Java client
* how to implement callbacks
* how to combine RMI code with unit test

Introduction
------------
We gaan met RMI een eenvoudige teller maken waarmee we van afstand kunnen communiceren. Gebruik de volgende informatie uit het onderstaande stappenplan.

Het object TerugTeller kent de volgende functionaliteiten:

* Het object heeft een eigenschap value. Dit is een geheel getal dat de waarde van de teller aangeeft. Initieel is value gelijk aan 200. Deze eigenschap kan worden bepaald met een methode setValue(int value) en worden verkregen met een methode getValue().
* Het object heeft een methode decrement waarmee de waarde van de teller met 1 verlaagd wordt.  


Steps: RMI
----------
1. Maak een nieuw project met de naam "oose\_rmi\_project", gebruik uiteraard Maven
2.	Definiëer de interface van het onderzoekbject in een Java interface genaamd `ITerugTeller` in package `nl.ica.oose`. De interface moet overerven van `java.rmi.Remote`. Alle methodes moeten een `java.rmi.RemoteException` throwen. De interface bevat de volgende methoden:

  a. public void setValue(int value);

  b.	public int getValue();

  c.	public void decrement();
3.	Implementeer de interface ```ITerugTeller``` met een klasse ```TerugTeller``` die overerft van ```java.rmi.server.UnicastRemoteObject```. Zorg ook voor een constructor van ```TerugTeller``` die een ```RemoteException``` gooit.
4.	Schrijf een klasse genaamd ```TerugTellerServer``` (draait in aparte VM, dus heeft in ieder geval een main-methode) die een ```TerugTeller``` object instantieert en registreert in de RMI Registry:

  ```java
  ITerugTeller teller;
  try {
        teller = new TerugTeller();
        Registry r = LocateRegistry.createRegistry(1099);
        r.bind("terugteller", teller);
  } catch (Exception e) {
	    e.printStackTrace();
  }
  ```
  Zorg iig. voor een import van java.rmi.*.

5. Schrijf een klasse genaamd ```TerugTellerClient``` (draait in aparte VM, dus heeft in ieder geval een main-methode) die als client kan dienen voor het ```TerugTeller``` object. Roep in de constructor van ```TerugTellerClient```:

  1.	setValue(200) aan
  2.	in een for-lusje 100 keer de decrement-methode aan op dit ‘remote object’.

  Roep in main de constructor aan van TerugTellerClient. Laat de main en de constructor in de header een RemoteException gooien. Maak gebruik van de volgende code-snippets:

  ```java
  public TerugTellerClient() throws RemoteException {
  }
  ```

  ```java
  ITerugTeller teller =
    (ITerugTeller)LocateRegisty.getRegistry().lookup("terugteller");
  ```

6.	Start de client door met je rechtermuisknop ‘Run Java Application’ te selecteren op het bestand TerugTellerServer.java.
7.	Start de client door met je rechtermuisknop ‘Run Java Application’ te selecteren op het bestand TerugTellerClient.java.

Steps RMI Callbacks
-------------------
1.	Stop de client, de server en de RMI Registry
2.	Wijzig nu de client `TerugTellerClient` zodat het geïnformeerd wordt als de server-teller een veelvoud is van 25. Introduceer hiervoor een extra interface `ICallback` (extends `Remote`) met een methode genaamd `notifyChange` (throws `RemoteException`) met als argument een `int` (de value van de server indien hij een veelvoud is van 25).
3.	Laat `TerugTellerClient` de interface `ICallback` implementeren door de `int`-waarde af te drukken naar `System.out`. Laat `TerugTellerClient` tevens overerven van `java.rmi.server.UnicastRemoteObject`.
4.	Wijzig de interface `ITerugTeller` met een methode `addCallbackListener` met als argument een object van het type `ICallback`.
5.	Wijzig de implementatie van de klasse `TerugTeller` zodanig dat aan de nieuwe interface `ITerugTeller` voldaan wordt. `TerugTeller` krijgt dus een methode `addCallbackListener` en een lijstje met listeners van het type `ICallback`.
6.	Wijzig de implementatie van de methode `decrement` zo dat als value een veelvoud is van 25, alle `ICallback`s genotificeerd worden.
7.	Start de server en client (in die volgorde) opnieuw . Hoe vaak wordt de methode `notify` aangeroepen?

Steps JUnit
-----------
1.	Maak in het "oose\_rmi\_project" een nieuwe test-sourcefolder aan volgens de Maven conventie.
2.	Creëer in het package een nieuwe testcase conform het onderstaande voorbeeld:

  ```java
  import org.junit.*;

  public class TerugTellerTest {
    	@Before
    	public void setUp() throws Exception {

    	}

    	@Test
    	public void testGetValue() {

        }

    	@Test
    	public void testDecrement() {

        }
  }
  ```

3. Vul `setUp()` in door een nieuwe instantie van `TerugTeller` te instantieren en deze op te slaan in een globale variabele zodat de test* methoden gebruik kunnen maken van deze instantie.

4. Vul `testGetValue` in door te controleren op `getValue` gelijk is aan 10:

  ```java
  tt.setValue(10);
  assertEquals(tt.getValue(),10);
  ```
5. Vul `testDecrement` in door de `decrement` methode aan te roepen en daarna te controleren of `getValue()` gelijk is aan 9:

  ```java
  tt.setValue(10);
  tt.decrement();
  assertEquals(tt.getValue(),9);
  ```
6. Run nu de test (Run->JUnit test) en kijk naar het resultaat!


Done
----
You can checkout the branch exercise-results for a working project and review possible differences.
