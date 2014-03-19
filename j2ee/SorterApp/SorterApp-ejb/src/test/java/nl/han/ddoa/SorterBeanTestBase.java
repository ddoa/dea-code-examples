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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author mdkr
 */
@Ignore
public class SorterBeanTestBase {
    SorterBeanLocal instance;
    
    /**
     * Test of sort method, of class SorterBean.
     */
    @org.junit.Test
    public void testSort() throws Exception {
        Comparable[] listToSort = new Comparable[]{5,4,3,2,1};
        Comparable[] expResult = new Comparable[]{1,2,3,4,5};
        Comparable[] result = instance.sort(listToSort);
        assertArrayEquals(expResult, result);
    }   
}
