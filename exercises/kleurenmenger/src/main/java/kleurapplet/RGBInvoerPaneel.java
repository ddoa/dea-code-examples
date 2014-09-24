/*
 * RGBInvoerPaneel.java		13 maart 2003, Paul Bergervoet
 *
 */

package kleurapplet;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import kleurapplet.grnuminput.*;

class RGBInvoerPaneel extends Panel implements Observer
{	// Variables
	private NumberSlider rood;
	private NumberSlider groen;
	private NumberSlider blauw;

    /**
     * Was: KleurCanvas, maar alleen de interface is hier nodig. Bij de aanroep kan dus gerust Kleur meegegeven worden.
     * @param numberListener
     */
	public RGBInvoerPaneel(NumberListener numberListener)
	{	// NB: mwt klassieke awt, niet met behulp van Swing-componenten.
		setBackground(new Color(204, 204, 204));	
		GridLayout g = new GridLayout(3, 1);
		g.setHgap(10);
		setLayout(g);
						
		rood = new NumberSlider(0, 255, 127, 0, "Rood", "");
		rood.addNumberListener(numberListener);
		add(rood);
		
		groen = new NumberSlider(0, 255, 127, 0, "Groen", "");
		groen.addNumberListener(numberListener);
		add(groen);

		blauw = new NumberSlider(0, 255, 127, 0, "Blauw", "");
		blauw.addNumberListener(numberListener);
		add(blauw);
	}

    /**
     * Was eerst public
     * @param r
     * @param g
     * @param b
     */
	private void setSliders(int r, int g, int b)
	{	rood.setValue(r);
		groen.setValue(g);
		blauw.setValue(b);
	}

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Kleur.KleurUpdate) {
            Kleur.KleurUpdate kleurUpdate = (Kleur.KleurUpdate) arg;
            setSliders(kleurUpdate.rood, kleurUpdate.groen, kleurUpdate.blauw);
        }
    }
}
