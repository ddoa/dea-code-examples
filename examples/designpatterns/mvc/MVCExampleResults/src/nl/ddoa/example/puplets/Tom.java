package nl.ddoa.example.puplets;

import java.util.Observable;
import java.util.Observer;

public class Tom extends Thread implements Observer
{
    public Tom()
    {
        this.start();
    }

    public void run()
    {
        while (true)
        {
            System.out.println("Tom is verlegen");
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void bloos()
    {
        System.out.println("Tom krijgt een rooie kop");
    }

    public void update(Observable o, Object arg)
    {
        if (arg instanceof String)
        {
            if (((String) arg).equals("lach"))
            {
                bloos();
                ((Tanja)o).kus();
            }
        }
    }
}
