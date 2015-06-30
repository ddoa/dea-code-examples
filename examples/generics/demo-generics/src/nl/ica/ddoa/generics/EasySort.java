package nl.ica.ddoa.generics;

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
public class EasySort<T> {


    public Comparable<T>[] sort(Comparable<T>[] input)
    {
        Arrays.sort(input);
        return input;
    }
}
