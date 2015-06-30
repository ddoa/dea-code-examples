package nl.ica.ddoa.ddoa.springexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext  ("application-context.xml");  
		Moppenvrager vrager = (Moppenvrager)factory.getBean("moppenvrager");
		vrager.vraagAanIemandEenMop();
	}

}
