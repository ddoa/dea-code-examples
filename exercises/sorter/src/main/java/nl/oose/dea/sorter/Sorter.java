package nl.oose.dea.sorter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

/**
 * @author Rody
 */

public class Sorter extends UnicastRemoteObject implements ISorter {

    /**
     * @throws RemoteException
     */
    public Sorter() throws RemoteException {
        super();
    }

    public Comparable[] sort(Comparable[] input) {
        Arrays.sort(input);
        return input;
    }
}
