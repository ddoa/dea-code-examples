package nl.ica.ddoa.example.rmi.sorter.withoutplugin;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author rodmiddel
 *
 */
public interface ISorter extends Remote {
    /**
     * Sorts an integer list
     * @param intList
     * @return
     */
    public Comparable[] sort(Comparable[] intList) throws RemoteException;
}
