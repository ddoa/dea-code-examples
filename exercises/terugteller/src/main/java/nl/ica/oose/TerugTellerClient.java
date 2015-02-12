package nl.ica.oose;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class TerugTellerClient extends UnicastRemoteObject implements ICallback{
    protected TerugTellerClient() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        TerugTellerClient terugTellerClient = new TerugTellerClient();
        terugTellerClient.start();
    }

    private void start() throws RemoteException, NotBoundException {
        ITerugTeller teller =
                (ITerugTeller) LocateRegistry.getRegistry().lookup("terugteller");
        teller.addCallbackListener(this);
        teller.setValue(200);
        for (int i = 0; i < 100; i++) {
            teller.decrement();
        }
        System.out.println(teller.getValue());

    }

    @Override
    public void notifyChange(int value) throws RemoteException {
        System.out.println("De volgende waarde is een veelvoud van 25: " + value);
    }
}
