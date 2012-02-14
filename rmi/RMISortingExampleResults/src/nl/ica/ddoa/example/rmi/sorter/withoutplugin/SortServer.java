package nl.ica.ddoa.example.rmi.sorter.withoutplugin;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SortServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SortServer srtsrvr = new SortServer();
        srtsrvr.start();
    }

    public void start() {
        try {
            ISorter sorter = new Sorter();
            ISorter stub = (ISorter) UnicastRemoteObject.exportObject(sorter, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("sorter", stub);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
