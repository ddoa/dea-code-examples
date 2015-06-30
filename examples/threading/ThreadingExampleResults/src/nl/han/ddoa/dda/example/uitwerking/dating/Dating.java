package nl.han.ddoa.dda.example.uitwerking.dating;
import java.util.Date;

/**
 * Description for the class Dating:
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
public class Dating implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			System.out.println(new Date());
	}

}
