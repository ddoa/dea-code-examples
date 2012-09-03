package nl.han.ddoa.dda.example.uitwerking.cubbyhole;

/** Example from Sun Thread tutorial */

public class CubbyHole extends Object {
    private int contents;
    private boolean available = false;

    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();

        return contents;
    }

    public synchronized void put(int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}
