package nl.ica.ddoa.sorter;

import java.util.Arrays;

/**
 * Description for the class EasySort:
 * <p/>
 * Example usage:
 * <p/>
 * <pre>
 *
 * </pre>
 *
 * @author mdkr
 * @version Copyright (c) 2012 HAN University, All rights reserved.
 */
public class EasySort<T extends Comparable<T>> implements ISorter<T> {
    public Comparable<T>[] sort(Comparable<T>[] toSort) {
        Arrays.sort(toSort);
        return toSort;
    }
}
