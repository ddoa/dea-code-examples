/*
 * Created on 27-sep-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package nl.ica.ddoa.example.rmi.timtom;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Rody
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("serial")
public class Tim extends UnicastRemoteObject implements IntfTim {

	public static void main(String[] args) {
		try {
			new Tim();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Tim() throws RemoteException {
		try {
			IntfTom tom = (IntfTom) Naming.lookup("rmi://localhost:1099/Tom");
			String tomsTekst = tom.zegEensIets(this);
			System.out.println(tomsTekst);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void sla() {
		// TODO Auto-generated method stub
		System.out.println("Klets!");
	}
}
