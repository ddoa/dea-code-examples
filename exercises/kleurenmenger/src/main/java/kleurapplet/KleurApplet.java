/*
 * KleurApplet.java		13 maart 2003, Paul Bergervoet
 *
 * Applet toont kleurenmenger 
 */

package kleurapplet;

import java.awt.*;
import java.applet.*;

public class KleurApplet extends Applet
{	KleurCanvas kc;
	RGBInvoerPaneel rgbip;
	HSBInvoerPaneel hsbip;

	public void init()
	{
		setLayout(new BorderLayout());
        Kleur kleur = new Kleur();
		kc = new KleurCanvas(kleur.dataObject());
		add(kc, "Center");
		rgbip = new RGBInvoerPaneel(kleur);
		add(rgbip, "East");
		hsbip = new HSBInvoerPaneel(kleur);
		add(hsbip, "West");
		setSize(600,340);
		setVisible(true);

        kleur.addObserver(kc);
        kleur.addObserver(rgbip);
        kleur.addObserver(hsbip);
	}
}

	


    
