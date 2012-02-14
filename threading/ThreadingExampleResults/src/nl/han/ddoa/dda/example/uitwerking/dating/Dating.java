package nl.han.ddoa.dda.example.uitwerking.dating;
import java.util.Date;

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
