package nl.han.ddoa.sorter.algorithms;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

/**
 * Description for the class JavaSorter:
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
public class JavaSorter extends UnicastRemoteObject implements Sorter {
    protected JavaSorter() throws RemoteException {
    }

    @Override
    public Comparable[] sort(Comparable[] list) throws RemoteException {
        Arrays.sort(list);
        return list;
    }
}
