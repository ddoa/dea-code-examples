/*
 * RGBInvoerPaneel.java		13 maart 2003, Paul Bergervoet
 *
 */

package kleurapplet;

import java.awt.*;
import java.awt.event.*;
import kleurapplet.grnuminput.*;

class RGBInvoerPaneel extends Panel 
{	// Variables
	private NumberSlider rood;
	private NumberSlider groen;
	private NumberSlider blauw;

	public RGBInvoerPaneel(KleurCanvas k)
	{	// NB: mwt klassieke awt, niet met behulp van Swing-componenten.
		setBackground(new Color(204, 204, 204));	
		GridLayout g = new GridLayout(3, 1);
		g.setHgap(10);
		setLayout(g);
						
		rood = new NumberSlider(0, 255, 127, 0, "Rood", "");
		rood.addNumberListener(k);
		add(rood);
		
		groen = new NumberSlider(0, 255, 127, 0, "Groen", "");
		groen.addNumberListener(k);
		add(groen);

		blauw = new NumberSlider(0, 255, 127, 0, "Blauw", "");
		blauw.addNumberListener(k);
		add(blauw);
	}
	
	public void setSliders(int r, int g, int b)
	{	rood.setValue(r);
		groen.setValue(g);
		blauw.setValue(b);
	}
}
