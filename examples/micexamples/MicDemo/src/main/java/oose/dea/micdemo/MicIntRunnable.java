package oose.dea.micdemo;

/**
 * Created by Michel Koolwaaij on 01-07-16.
 */
public class MicIntRunnable implements Runnable {

    private final MicInt micInt;

    public MicIntRunnable (MicInt micInt) {
        this.micInt = micInt;
    }

    public void tel(){
        for (int i=0;i<1000;i++){
            micInt.inc();
        }

    }

    public void run(){
        tel();
    }
}
