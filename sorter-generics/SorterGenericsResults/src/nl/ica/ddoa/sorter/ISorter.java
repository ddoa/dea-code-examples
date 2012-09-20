package nl.ica.ddoa.sorter;

/**
 * Description for the class ISorter:
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
public interface ISorter<T extends Comparable<T>> {
    Comparable<T>[] sort(Comparable<T>[] toSort);
}
