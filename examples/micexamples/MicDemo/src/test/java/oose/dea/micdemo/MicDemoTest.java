package oose.dea.micdemo;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Michel Koolwaaij on 01-07-16.
 */
public class MicDemoTest extends TestCase {
    public MicDemoTest (String testName){
        super(testName);
    }

    // Les 2: unit testen
    @Test
    public void testMicIntGetValue(){
        MicInt m = new MicInt(3);

        // Test en controle
        assertEquals(3, m.getValue());
    }

    // Les 2: unit testen
    @Test
    public void testMicIntInc(){
        MicInt m = new MicInt(3);

        // Test
        m.inc();

        // Controle
        assertEquals(4, m.getValue());
    }

    // Les 3: Threads
    @Test
    public void testMicIntRunnable() throws InterruptedException {
        MicInt m = new MicInt(0);

        //Test
        Thread t = new Thread(new MicIntRunnable(m));
        t.start();
        t.join();

        //Controle
        assertEquals(1000,m.getValue());
    }
}
