/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ica.ddoa.sorter.ejb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author mdkr
 */
@Stateless
public class Sorter implements SorterLocal {

    @Override
    public Integer[] sort(Integer[] list) {
        Arrays.sort(list);
        return list;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
