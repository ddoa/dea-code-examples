package oose.dea.micdemo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Michel Koolwaaij on 12-09-16.
 * Les 4: RMI
 */
public class MicIntServer {
    public static void main(String[] args) {
        MicIntServer mis = new MicIntServer();
        mis.start();
    }

    private void start() {
        IMicInt mi;
        try {
            mi = new MicIntRemote(0);
            Registry r;
            try {
                r = LocateRegistry.createRegistry(1099);
            }
            catch( Exception e) {
                r = LocateRegistry.getRegistry(1099);
            }
            try {
                r.bind("micint", mi);
            }
            catch (Exception e){
                r.rebind("micint",mi);
            }
            System.out.println("Server is running!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
