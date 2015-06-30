package nl.han.ddoa.sorter.algorithms;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Description for the class Sorter:
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
public interface Sorter extends Remote {
    public Comparable[] sort(Comparable[] list) throws RemoteException;
}
