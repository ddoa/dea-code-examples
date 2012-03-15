package nl.ica.ddoa.ddoa.springexample;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MoppenVertellerTest {

	@Test
	public void test() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		Moppenvrager vrager = (Moppenvrager)factory.getBean("moppenvrager");
		Assert.assertNotNull(vrager.getVerteller());
	}

}
