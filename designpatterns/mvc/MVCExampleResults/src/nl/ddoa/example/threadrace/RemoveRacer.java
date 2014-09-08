package nl.ddoa.example.threadrace;

public class RemoveRacer extends Thread
{
    private ThreadRace tr;
    
    public RemoveRacer(ThreadRace tr) {
        this.tr = tr;
    }
    
    public void run()
    {
        while(true) {
            tr.sharedValue--;
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