package nl.ica.ddoa.example.rmi.sorter.withoutplugin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class Sorter implements ISorter {

    public Comparable[] sort(Comparable[] intList) throws RemoteException {
        // TODO Auto-generated method stub
        Arrays.sort(intList);
        return intList;
    }

}
