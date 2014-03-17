package nl.han.ddoa.sorter.algorithms;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Description for the class SortFactory:
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
public interface SortFactory extends Remote {
    public Sorter createSorter() throws RemoteException;
}
