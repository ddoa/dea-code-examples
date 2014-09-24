package kleurapplet;

import kleurapplet.grnuminput.NumberListener;

import java.awt.*;
import java.util.Observable;

public class Kleur extends Observable implements NumberListener {
    private int roodval;
    private int groenval;
    private int blauwval;
    private float[] hsbvalues;

    public Kleur() {
        this.roodval = 127;
        this.groenval = 127;
        this.blauwval = 127;
    }

    public void numberChanged(String naam, double v) {
        if (naam.equals("Rood")) {
            roodval = (int) v;        // harde cast!! v loopt van 0 tot 255 met 0 decimalen!
            adjustHSBValues();
        } else if (naam.equals("Groen")) {
            groenval = (int) v;
            adjustHSBValues();
        } else if (naam.equals("Blauw")) {
            blauwval = (int) v;
            adjustHSBValues();
        } else if (naam.equals("Tint")) {
            hsbvalues[0] = (float) v;    // harde cast!! v loopt van 0 tot 1 met 3 decimalen!
            adjustRGBValues();
        } else if (naam.equals("Verzadiging")) {
            hsbvalues[1] = (float) v;
            adjustRGBValues();
        } else    // must be "Helderheid"
        {
            hsbvalues[2] = (float) v;
            adjustRGBValues();
        }

        setChanged();
        notifyObservers(dataObject());
    }

    public KleurUpdate dataObject() {
        adjustHSBValues();
        return new KleurUpdate(roodval, groenval, blauwval, hsbvalues[0], hsbvalues[1], hsbvalues[2]);
    }

    /**
     * Met deze extra class geven we alleen de essentiele data weg aan de observers en
     * houden we bij ons wat van ons is, zoals de numberChanged en de conversie RGB->HSB.
     *
     * Hiermee verlagen we de koppeling, maar ook helaas de cohesie.
     * Alternatief is het Kleur object aan alle Observers mee te geven, dit is een een hogere koppeling maar ook hogere cohesie.
     */
    class KleurUpdate {
        public int rood;
        public int groen;
        public int blauw;
        public float hue;
        public float saturation;
        public float brightness;

        /**
         * Alleen Kleur en KleurUpdate mogen deze constructor aanroepen.
         * @param rood
         * @param groen
         * @param blauw
         * @param hue
         * @param saturation
         * @param brightness
         */
        private KleurUpdate(int rood, int groen, int blauw, float hue, float saturation, float brightness)
        {
            this.rood = rood;
            this.groen = groen;
            this.blauw = blauw;
            this.hue = hue;
            this.saturation = saturation;
            this.brightness = brightness;
        }
    }

    /**
     * Bij verandering van RGB moet HSB worden aangepast
     */
    private void adjustHSBValues() {
        hsbvalues = Color.RGBtoHSB(roodval, groenval, blauwval, hsbvalues);
    }

    /**
     * Bij verandering van HSB moet RGB worden aangepast
     */
    private void adjustRGBValues() {
        Color c = Color.getHSBColor(hsbvalues[0], hsbvalues[1], hsbvalues[2]);
        roodval = c.getRed();
        groenval = c.getGreen();
        blauwval = c.getBlue();
    }

}
