package oose.dea.micdemo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Michel Koolwaaij on 12-09-16.
 * Les 4: Threads
 */
public class MicIntClient extends UnicastRemoteObject {
    protected MicIntClient() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException, NotBoundException{
        MicIntClient mc = new MicIntClient();
        mc.start();
    }

    private void start() throws RemoteException, NotBoundException{
        IMicInt mi = (IMicInt) LocateRegistry.getRegistry().lookup("micint");
        mi.inc();
        System.out.println(mi.getValue());
    }
}
