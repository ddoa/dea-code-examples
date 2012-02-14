package nl.han.ddoa.dda.example.uitwerking.dating;


/**
 * @author Rody
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Getallen {

	public static void main(String[] args) {
		EvenGetallen ev = new EvenGetallen();
		Dating t = new Dating();
		Thread th = new Thread(t);
		th.start();
		ev.start();	
		
		
	}
}
