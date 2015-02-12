package nl.ica.oose;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICallback extends Remote {
    public void notifyChange(int value) throws RemoteException;
}
