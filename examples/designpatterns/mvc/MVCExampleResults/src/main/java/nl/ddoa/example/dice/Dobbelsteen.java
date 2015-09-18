package nl.ddoa.example.dice;

import static java.lang.Math.random;

import java.util.Observable;

public class Dobbelsteen extends Observable
{
    private int waarde;
    
    public void dobbel()
    {
       waarde = 1 + (int)(5 * random());
       setChanged();
       notifyObservers(waarde);
    }

    public int getWaarde()
    {
        return waarde;
    }
}
