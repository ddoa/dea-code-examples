package nl.han.ddoa.dda.example.base.cubbyhole;


public class Unsynced {

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
