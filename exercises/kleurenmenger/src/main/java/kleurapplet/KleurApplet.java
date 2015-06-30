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
	{	// NB: mwt klassieke awt, niet met behulp van Swing-componenten.
		setLayout(new BorderLayout());
		kc = new KleurCanvas();
		add(kc, "Center");
		rgbip = new RGBInvoerPaneel(kc);
		add(rgbip, "East");
		hsbip = new HSBInvoerPaneel(kc);
		add(hsbip, "West");
		setSize(600,340);
		setVisible(true);
	}
}

	


    
