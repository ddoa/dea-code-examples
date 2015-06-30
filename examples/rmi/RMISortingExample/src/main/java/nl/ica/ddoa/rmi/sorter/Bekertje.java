package nl.ica.ddoa.rmi.sorter;

import java.io.Serializable;

public class Bekertje implements Comparable, Serializable {
    private int inhoud;

    @Override
    public String toString() {
        return "Bekertje{" +
                "inhoud=" + inhoud +
                '}';
    }

    public Bekertje(int inhoud)
    {
        this.inhoud = inhoud;
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Bekertje) {
            Bekertje b = (Bekertje) o;
            return b.inhoud - this.inhoud;
        }
        throw new IllegalArgumentException("");
    }
}
