package nl.ica.oose;

import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.*;

public class TerugTellerTest implements ICallback {

    @Test
    public void testDecrement() throws Exception {
        TerugTeller terugTeller = new TerugTeller();
        terugTeller.addCallbackListener(this);
        terugTeller.setValue(200);
        for (int i = 0; i < 100; i++) {
            terugTeller.decrement();
        }
        assertEquals(100, terugTeller.getValue());
    }

    @Override
    public void notifyChange(int value) throws RemoteException {
        assertTrue(value % 25 == 0);
    }
}