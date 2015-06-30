package nl.han.ddoa.sorter.client;

import nl.han.ddoa.sorter.algorithms.SortFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Description for the class SortClient:
 * <p/>
 * Example usage:
 * <p/>
 * <pre>
 *
 * </pre>
 *
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class SortClient {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public static void main(String[] args) {
        SortClient sortClient = new SortClient();
        sortClient.start();
    }

    private void start() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            SortFactory sortFactory = (SortFactory) registry.lookup("factory");
            Comparable[] sortedList = sortFactory.createSorter().sort(new Comparable[]{5, 4, 3, 2, 1});
            for (int i = 0; i < sortedList.length; i++) {
                System.out.println(sortedList[i]);
            }
        } catch (RemoteException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (NotBoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    public SortClient() {
    }
}
