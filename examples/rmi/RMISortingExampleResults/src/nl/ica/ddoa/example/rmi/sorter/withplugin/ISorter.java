package nl.ica.ddoa.example.rmi.sorter.withplugin;

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
    public int[] sort(int[] intList) throws RemoteException;
}
