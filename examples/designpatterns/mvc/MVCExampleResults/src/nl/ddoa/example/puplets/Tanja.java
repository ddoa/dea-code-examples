package nl.ddoa.example.puplets;

import java.util.Observable;

public class Tanja extends Observable
{
    private int kussen = 0;
    
    public void lachLief()
    {   
        setChanged();
        notifyObservers("lach");
    }
    
    public void kus()
    {
        kussen++;
        System.out.println(kussen);
    }
}
