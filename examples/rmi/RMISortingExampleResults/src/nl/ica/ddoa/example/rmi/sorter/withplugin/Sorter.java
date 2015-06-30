package nl.ica.ddoa.example.rmi.sorter.withplugin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class Sorter extends UnicastRemoteObject  implements ISorter {

    protected Sorter() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    public int[] sort(int[] intList) throws RemoteException {
        // TODO Auto-generated method stub
        Arrays.sort(intList);
        return intList;
    }

}
