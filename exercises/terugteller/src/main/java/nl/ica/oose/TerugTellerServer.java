package nl.ica.oose;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TerugTellerServer {
    public static void main(String[] args) {
        TerugTellerServer terugTellerServer = new TerugTellerServer();
        terugTellerServer.start();
    }

    private void start() {
        ITerugTeller teller;
        try {
            teller = new TerugTeller();
            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("terugteller", teller);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
