package nl.han.ddoa.dda.example.uitwerking.cubbyhole;

/** Example from Sun Thread tutorial */

public class Consumer extends Thread {
    private CubbyHole cubbyhole;
    private int number;

    public Consumer(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = cubbyhole.get();
            System.out.println("Consumer #" + this.number
                               + " got: " + value);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }

        }
    }
}

