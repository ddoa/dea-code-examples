package oose.dea.micdemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Michel Koolwaaij on 12-09-16.
 * Les 4: Threads
 */
public class MicIntRemote extends UnicastRemoteObject implements IMicInt{
    private long l;

    public MicIntRemote(int i) throws RemoteException{

        this.l = i;
    }

    public void inc(){

        l = l+1;
    }

    public long getValue(){
        return l;
    }
}
