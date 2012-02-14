/*
 * Created on 27-sep-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package nl.ica.ddoa.example.rmi.timtom;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Rody
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface IntfTom extends Remote {
	public String zegEensIets(IntfTim tim) throws RemoteException;
}
