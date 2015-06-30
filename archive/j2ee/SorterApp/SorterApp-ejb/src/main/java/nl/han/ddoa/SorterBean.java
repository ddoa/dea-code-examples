/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.han.ddoa;

import java.util.Arrays;
import javax.ejb.Stateless;

/**
 *
 * @author mdkr
 */
@Stateless
public class SorterBean implements SorterBeanLocal {

    @Override
    public Comparable[] sort(Comparable[] listToSort) {
        Arrays.sort(listToSort);
        return listToSort;
    }
}
