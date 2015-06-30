package nl.ddoa.example.threadrace;

public class AddRacer extends Thread
{
    private ThreadRace tr;
    
    public AddRacer(ThreadRace tr) {
        this.tr = tr;
    }
    public void run()
    {
        while(true)
        {
            tr.sharedValue++;
            System.out.println(tr.sharedValue);
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
