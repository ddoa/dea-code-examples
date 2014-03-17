package nl.han.ddoa.sorter.server;

import nl.han.ddoa.sorter.algorithms.DefaultSortFactory;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Description for the class nl.han.ddoa.sorter.server.SortServer:
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
public class SortServer {
    private static final int RMI_PORT = 1099;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public static void main(String[] args) {
        SortServer server = new SortServer();
        server.init();
    }

    private  void init() {
        try {
            Registry registry = LocateRegistry.createRegistry(RMI_PORT);
            registry.bind("factory", new DefaultSortFactory());
        } catch (RemoteException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (AlreadyBoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
