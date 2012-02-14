package nl.han.ddoa.dda.example.base.cubbyhole;

/**
 * Example from Sun Thread tutorial Unsynchronized CubbyHole
 */

public class CubbyHole {
    private int contents;
    private boolean available = false;

    public int get() {
        available = false;
        return contents;
    }

    public void put(int value) {
        contents = value;
        available = true;
    }
}
