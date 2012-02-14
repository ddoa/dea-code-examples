/*
 * Created on 27-sep-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package nl.ica.ddoa.example.rmi.timtom;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Rody
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("serial")
public class Tom extends UnicastRemoteObject implements IntfTom {

	/**
	 * @throws RemoteException
	 */
	protected Tom() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see nl.ddoa.mdl.IntfTom#zegEensIets()
	 */
	public String zegEensIets(IntfTim tim) throws RemoteException{
		// TODO Auto-generated method stub
		tim.sla();
		return "Iets";
	}

}
