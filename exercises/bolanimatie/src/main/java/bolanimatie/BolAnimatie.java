package bolanimatie;

/**
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class BolAnimatie extends JPanel
{	// Constants
	public static final int SIZE = 350;				// omvang Canvas: 350x350
	public static final int BOLSIZE = 20;			// omvang vierkant: 20x20
	public static final int COLORSTEP = 255/(BOLSIZE/2);	
	public static final int STARTSNELHEID = 10;		// sleeptime is 1000/snelheid
	public static final int STARTRICHTING = 45;		// schuin
		
	private double xpos = (SIZE-BOLSIZE)/2;		// zet balletje in het midden
	private double ypos = (SIZE-BOLSIZE)/2;		// linksbovenhoek van bounding vierkant!
	private double xspeed = 7;
	private double yspeed = 7;
	private int xdir = 1;						// -1 of +1
	private int ydir = 1;
	
	private int sleeptime = 1000/STARTSNELHEID;	// sleeptime van de thread
	
/**
 * constructor
 */
	public BolAnimatie()
	{	// ----- uiterlijk
		setBackground(Color.white);
		setSize(SIZE, SIZE);		
	}
	
/**
 * Balletje verplaatsen.
 * NB: de x- en y-component in de stap zijn altijd positief. De variabelen xdir en
 * ydir zijn -1 of 1 en bepalen de richting door vermenigvuldiging 
 * (bijvoorbeeld xdir*xspeed)
 * Wanneer het balletje de rand van het speelveld dreigt te passeren, wordt de
 * betreffende dir-variable omgeklapt, waardoor de richting van de bal omdraait.
 */
	private void moveBol()
	{	xpos = xpos + xdir*xspeed;
		if ( xpos <= 0 )				// kan als xdir = -1, bal loopt links weg
		{	xpos = 0;
			xdir = 1;				// change dir
		}
		if ( xpos >= SIZE-BOLSIZE )		// kan als xdir = 1, bal loopt rechts weg
		{	xpos = SIZE-BOLSIZE;
			xdir = -1;				// change dir
		}
		ypos = ypos + ydir*yspeed;
		if ( ypos <= 0 )				// kan als ydir = -1, bal loopt boven weg
		{	ypos = 0;
			ydir = 1;				// change dir
		}
		if ( ypos >= SIZE-BOLSIZE )		// kan als xdir = 1, bal loopt onder weg
		{	ypos = SIZE-BOLSIZE;
			ydir = -1;				// change dir
		}
	}

// ------- Gebruikersacties --------------------

/**
 * Richting instellen: De hoek van de richting (in graden) wordt omgerekend
 * in radialen. Daarna sin en cos gebruiken om de y- en x-component van een
 * stap uit te rekenen
 *
 * @param ri De gekozen hoek uit de regelaar
 */
	public void setRichting(int ri)
	{	if ( ri >= 0 && ri <= 90 )
		{	double rad = (Math.PI/2)*( ((double)ri)/90);
			xspeed = Math.cos(rad)*10;
			yspeed = Math.sin(rad)*10;
		} // else do nothing
	}
	
/**
 * Snelheid instellen: hogere snelheid realiseren door de tijd bij sleep(int t)
 * te verlagen. Dit wordt bereikt door 1000/snelheid als slaaptijd te nemen.
 *
 * @param s De gekozen snelheid uit de regelaar
 */
	public void setSnelheid(int s)
	{	if ( s>=1 && s<=50 )
		{	sleeptime = 1000/s;		// hogere snelheid: kortere slaaptijd!
		} // else do nothing
	}
	
/**
 * Teken een stap: verplaats het balletje en teken opnieuw
 */
	public void paintStep()			// Regelpaneel: knop 'Stap'
	{	moveBol();
		repaint();
	}
	
// ------- Painting and buffering --------------------

/**
 * Teken het speelveld (wit vlak!) en het balletje
 */
	public void paintComponent(Graphics g)
	{		// verplicht, zorgt voor witte achtergrond
		super.paintComponent(g);
			// Bol bestaat uit in kleur verlopende concentrische cirkels (blauw -> rood)
		int ixpos = (int)Math.round(xpos);
		int iypos = (int)Math.round(ypos);
		for ( int k=0; k<=BOLSIZE/2; k++ )
		{	g.setColor(new Color(COLORSTEP*k, 0, 255-COLORSTEP*k));
			g.fillOval(ixpos+k, iypos+k, BOLSIZE-2*k, BOLSIZE-2*k);
		}
	}
}
