package oose.dea.micdemo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Michel Koolwaaij on 12-09-16.
 * Les 4: RMI
 */
public interface IMicInt extends Remote{
    public void inc() throws RemoteException;
    public long getValue() throws RemoteException;
}
