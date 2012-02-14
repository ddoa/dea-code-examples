package nl.ddoa.example.puplets;

import java.util.Observable;
import java.util.Observer;

public class Tim implements Observer, Runnable
{
    public Tim()
    {
        Thread t = new Thread(this);
        t.start();
    }
    
    public void run() 
    {
        while (true)
        {
            System.out.println("Tim drinkt bier");
            try
            {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public void toonSpierballen()
    {
        System.out.println("Tim toont zijn kracht");
    }

    public void update(Observable o, Object arg)
    {
        if (arg instanceof String) 
        {
            if (((String)arg).equals("lach"))
            {
                toonSpierballen();
                ((Tanja)o).kus();
            }
        }
    }
}
