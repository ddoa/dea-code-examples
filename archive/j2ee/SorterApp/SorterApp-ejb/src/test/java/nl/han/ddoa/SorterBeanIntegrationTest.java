/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.han.ddoa;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author mdkr
 */
public class SorterBeanIntegrationTest extends SorterBeanTestBase {
    private EJBContainer container;
    
    @Before
    public void setUp() throws NamingException {
        Map<String, Object> properties = new HashMap<String, Object>();  
    	properties.put(EJBContainer.MODULES, new File("target/classes"));
        container = EJBContainer.createEJBContainer(properties);
        instance = (SorterBeanLocal)container.getContext().lookup("java:global/classes/SorterBean");
    }
    
    @After
    public void tearDown() {
        container.close();
    }

}
