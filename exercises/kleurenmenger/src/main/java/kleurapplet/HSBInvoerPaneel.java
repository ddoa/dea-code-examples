/*
 * HSBInvoerPaneel.java		13 maart 2003, Paul Bergervoet
 *
 */

package kleurapplet;

import java.awt.*;
import java.awt.event.*;
import kleurapplet.grnuminput.*;

class HSBInvoerPaneel extends Panel 
{	// Variables
	private NumberSlider hue;
	private NumberSlider sat;
	private NumberSlider bright;

	public HSBInvoerPaneel(KleurCanvas k)
	{	// NB: mwt klassieke awt, niet met behulp van Swing-componenten.
		setBackground(new Color(204, 204, 204));	
		GridLayout g = new GridLayout(3, 1);
		g.setHgap(10);
		setLayout(g);
						
		hue = new NumberSlider(0, 1, 0.5, 2, "Tint", "");
		hue.addNumberListener(k);
		add(hue);
		
		sat = new NumberSlider(0, 1, 0.5, 2, "Verzadiging", "");
		sat.addNumberListener(k);
		add(sat);

		bright = new NumberSlider(0, 1, 0.5, 2, "Helderheid", "");
		bright.addNumberListener(k);
		add(bright);
	}	

	public void setSliders(float h, float s, float b)
	{	hue.setValue(h);
		sat.setValue(s);
		bright.setValue(b);
	}
}
