package nl.han.ddoa.dda.example.uitwerking.cubbyhole;

public class Synced {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CubbyHole ch = new CubbyHole();
        Thread p = new Producer(ch, 10);
        Thread c = new Consumer(ch, 10);
        p.start();
        c.start();
    }

}
