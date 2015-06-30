package nl.han.ddoa.dda.example.uitwerking.dating;


/**
 * Description for the class Getallen:
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
public class Getallen {

	public static void main(String[] args) {
		EvenGetallen ev = new EvenGetallen();
		Dating t = new Dating();
		Thread th = new Thread(t);
		th.start();
		ev.start();	
		
		
	}
}
