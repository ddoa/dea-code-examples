package nl.oose.dea.sorter;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author mdkr
 */

public class SorterThread extends Observable implements Runnable {
    private static int lastThreadNumber = 0;
    private final Registry registry;
    private Comparable[] listToSort;
    private int threadNumber;

    /**
     *
     * @param list
     * @param caller
     * @param registry
     */
    public SorterThread(ArrayList list, SortClient caller, Registry registry) {
        this.registry = registry;
        toComparableArray(list);
        addObserver(caller);
    }

    public int getThreadNumber() {
        return this.threadNumber;
    }


    /**
     * @param list
     * @return
     */
    private void toComparableArray(ArrayList list) {
        listToSort = new Comparable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            listToSort[i] = (Comparable) list.get(i);
        }
    }

    /**
     * Calls the sort method on the remote sorter and notifies the SortClient of the results.
     *
     * @see SortClient
     */
    public void run() {
        threadNumber = ++lastThreadNumber;
        try {
            ISorter sorter = (ISorter) registry.lookup("rmi://localhost:1099/sorter" + threadNumber);
            listToSort = sorter.sort(listToSort);
            setChanged();
            notifyObservers(listToSort);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }

}
