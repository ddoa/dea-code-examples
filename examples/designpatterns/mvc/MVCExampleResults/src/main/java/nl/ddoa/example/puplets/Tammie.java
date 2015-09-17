package nl.ddoa.example.puplets;

import java.util.Observable;

public class Tammie extends Observable {
    public void slaatVanZichAf()
    {
        System.out.println("Bats!");
        setChanged();
        notifyObservers("Bats!");
    }
    
    public void lachLief() {
        System.out.println("Hahahaha");
        setChanged();
        notifyObservers("Hihihihi");
    }

}
