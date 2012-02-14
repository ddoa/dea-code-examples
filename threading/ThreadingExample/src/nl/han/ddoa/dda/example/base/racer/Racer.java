package nl.han.ddoa.dda.example.base.racer;

/**
 * @author Rody
 */
public class Racer implements Runnable {
    private int teller;
    private int racerId;
    private static int instanceCount;

    public Racer() {
        this.racerId = instanceCount;
        instanceCount++;
    }

    /**
     * Implementation of incrementing a counter, paused by
     * some Thread.sleep. Can be executed in parallel to see
     * who's first :)
     */
    public void run() {
        while (teller < 50) {
            teller++;
            System.out.println(this + " " + teller);
            int rnd = (int) (500 * Math.random());
            try {
                Thread.sleep(rnd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " is ready!");
    }

    /**
     * @return String
     * @see java.lang.String
     */
    public String toString() {
        return this.getClass().getName() + " " + racerId;
    }
}
