package nl.han.ddoa.dda.example.uitwerking.dating;
/*
 * Created on 13-sep-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Rody
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EvenGetallen extends Thread {
	public void run() {
		for(int i=0;i<10000000;i=i+2) {
			System.out.println(i);
		}
	}
}
