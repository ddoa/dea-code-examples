/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ica.ddoa.sorter.ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mdkr
 */
@Local
public interface SorterLocal {

    Integer[] sort(Integer[] list);
    
}
