package nl.han.ddoa.sorter.algorithms;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Description for the class DefaultSortFactory:
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
public class DefaultSortFactory extends UnicastRemoteObject implements SortFactory {
    public DefaultSortFactory() throws RemoteException {
    }

    @Override
    public Sorter createSorter() throws RemoteException {
        return new JavaSorter();
    }
}
