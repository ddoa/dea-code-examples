package nl.oose.dea.sorter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Rody
 */

public interface ISorter extends Remote {
	public Comparable[] sort(Comparable[] input) throws RemoteException;
}
