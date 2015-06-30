package nl.oose.dea.sorter;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 * @author Rody
 */
public class SortServer {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        for(int i=0;i<SortClient.NR_SORTERS;i++) {
            registry.bind("rmi://localhost:1099/sorter" + (i + 1), new Sorter());
            System.out.println("Sorter " + i + " is ready!");
	    }
	}

}
