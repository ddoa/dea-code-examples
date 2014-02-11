package nl.han.ddoa.dda.example.uitwerking.dating;

/**
 * Description for the class EvenGetallen:
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
public class EvenGetallen extends Thread {
	public void run() {
		for(int i=0;i<10000000;i=i+2) {
			System.out.println(i);
		}
	}
}
