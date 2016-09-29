package oose.dea.micdemo;

/**
 * Created by Michel Koolwaaij on 01-07-16.
 * Les 3: Threads
 */
public class MicDemo {
    public static void main(String[] args) throws InterruptedException {
        MicInt micInt = new MicInt(0);

        Thread t1 = new Thread (new MicIntRunnable(micInt));
        t1.start();
        t1.join();

        System.out.println(micInt.getValue());

        final int maxThreads = 1000;
        Thread t2[] = new Thread[maxThreads];
        for (int i=0;i <maxThreads; i++){
            t2[i] = new Thread (new MicIntRunnable(micInt));
            t2[i].start();
        }

        for (int i=0; i < maxThreads; i++){
            t2[i].join();
        }

        System.out.println(micInt.getValue());

    }
}
