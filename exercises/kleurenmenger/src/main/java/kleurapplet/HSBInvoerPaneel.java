/*
 * HSBInvoerPaneel.java		13 maart 2003, Paul Bergervoet
 *
 */

package kleurapplet;

import kleurapplet.grnuminput.NumberListener;
import kleurapplet.grnuminput.NumberSlider;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

class HSBInvoerPaneel extends Panel implements Observer
{	// Variables
	private NumberSlider hue;
	private NumberSlider sat;
	private NumberSlider bright;

    /**
     * Was: KleurCanvas, maar alleen de interface is hier nodig. Bij de aanroep kan dus gerust Kleur meegegeven worden.
     * @param numberListener
     */
	public HSBInvoerPaneel(NumberListener numberListener)
	{	// NB: mwt klassieke awt, niet met behulp van Swing-componenten.
		setBackground(new Color(204, 204, 204));	
		GridLayout g = new GridLayout(3, 1);
		g.setHgap(10);
		setLayout(g);
						
		hue = new NumberSlider(0, 1, 0.5, 2, "Tint", "");
		hue.addNumberListener(numberListener);
		add(hue);
		
		sat = new NumberSlider(0, 1, 0.5, 2, "Verzadiging", "");
		sat.addNumberListener(numberListener);
		add(sat);

		bright = new NumberSlider(0, 1, 0.5, 2, "Helderheid", "");
		bright.addNumberListener(numberListener);
		add(bright);
	}

    /**
     * Was eerst public
     * @param h
     * @param s
     * @param b
     */
	private void setSliders(float h, float s, float b)
	{	hue.setValue(h);
		sat.setValue(s);
		bright.setValue(b);
	}

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Kleur.KleurUpdate) {
            Kleur.KleurUpdate kleurUpdate = (Kleur.KleurUpdate) arg;
            setSliders(kleurUpdate.hue, kleurUpdate.saturation, kleurUpdate.brightness);
        }
    }
}
