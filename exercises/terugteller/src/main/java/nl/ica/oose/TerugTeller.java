package nl.ica.oose;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TerugTeller extends UnicastRemoteObject implements ITerugTeller {
    private int value;
    private List<ICallback> callbacks = new ArrayList<ICallback>();

    protected TerugTeller() throws RemoteException {
    }

    public void decrement() throws RemoteException {
        value -= 1;
        if(value %25 ==0)
        {
            for(ICallback iCallback:callbacks)
            {
                iCallback.notifyChange(value);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void addCallbackListener(ICallback iCallback) throws RemoteException {
        callbacks.add(iCallback);
    }
}
