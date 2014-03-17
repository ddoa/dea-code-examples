package nl.han.ddoa.sorter.algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Description for the class JavaSorterTest:
 * <p/>
 * Example usage:
 * <p/>
 * <pre>
 *
 * </pre>
 *
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class JavaSorterTest {
    private JavaSorter javaSorter;

    @Before
    public void setUp() throws Exception {
        javaSorter = new JavaSorter();
    }

    @Test
    public void sortingAnEmptyArrayWillResultInAnEmptyArray() throws Exception {
        assertArrayEquals(new Comparable[]{}, javaSorter.sort(new Comparable[]{}));
    }

    @Test
    public void sortingAnArrayWithASingleElementWillResultInTheSameArrayWithASingleElement() throws Exception {
        assertArrayEquals(new Comparable[]{1}, javaSorter.sort(new Comparable[]{1}));
    }

    @Test(expected = NullPointerException.class)
    public void sortingAnNullReferenceArrayWillResultInANullPointerException() throws Exception {
        javaSorter.sort(null);
    }
}
