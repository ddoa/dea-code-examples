/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.han.ddoa;

import javax.ejb.Local;

/**
 *
 * @author mdkr
 */
@Local
public interface SorterBeanLocal {

    Comparable[] sort(Comparable[] listToSort);
    
}
