package nl.han.ddoa.dda.example.base.racer;

public class RandomRacer
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Racer rr1 = new Racer();
        Racer rr2 = new Racer();
        Thread t1 = new Thread(rr1);
        Thread t2 = new Thread(rr2);
        t1.start();
        t2.start();
    }

}
