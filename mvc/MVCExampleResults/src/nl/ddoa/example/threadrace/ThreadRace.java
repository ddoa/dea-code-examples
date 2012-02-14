package nl.ddoa.example.threadrace;

public class ThreadRace 
{
    public int sharedValue;
    
    public static void main(String[] args)
    {
        ThreadRace tr = new ThreadRace();
        AddRacer ar = new AddRacer(tr);
        RemoveRacer rr = new RemoveRacer(tr);
        ar.start();
        rr.start();
    }
    

}
