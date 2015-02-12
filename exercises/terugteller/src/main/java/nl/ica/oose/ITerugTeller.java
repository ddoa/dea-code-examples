package nl.ica.oose;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITerugTeller extends Remote {
    public void decrement() throws RemoteException;

    public int getValue() throws RemoteException;

    public void setValue(int value) throws RemoteException;

    public void addCallbackListener(ICallback iCallback) throws RemoteException;
}
