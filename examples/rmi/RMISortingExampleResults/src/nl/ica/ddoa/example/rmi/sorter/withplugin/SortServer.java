package nl.ica.ddoa.example.rmi.sorter.withplugin;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("sorter", sorter);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
