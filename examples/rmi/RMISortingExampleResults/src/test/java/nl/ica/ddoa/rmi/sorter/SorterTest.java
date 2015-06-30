package nl.ica.ddoa.rmi.sorter;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import nl.ica.ddoa.example.rmi.sorter.withoutplugin.ISorter;
import nl.ica.ddoa.example.rmi.sorter.withoutplugin.Sorter;

public class SorterTest {
    private ISorter s;

    @Before
    public void setUp() throws RemoteException {
        s = new Sorter();
    }
    
    @Test
    public void testEmptyArray() throws RemoteException {
        Comparable[] emptyList = {};
        assertArrayEquals(emptyList, s.sort(emptyList));
    }

    @Test
    public void testArrayContainingOneElement() throws RemoteException {
        Comparable[] listWithOneValue = {"hoi"};
        assertArrayEquals(listWithOneValue, s.sort(listWithOneValue));
    }
    
    @Test
    public void testArrayContainingTwoAlreadySortedElements() throws RemoteException {
        Comparable[] listWithTwoAlreadySortedElements = {1,2};
        assertArrayEquals(listWithTwoAlreadySortedElements, s.sort(listWithTwoAlreadySortedElements));
    }
    
    @Test
    public void testArrayContainingTwoUnsortedElements() throws RemoteException {
        Comparable[] listWithTwoUnsortedElements = {2,1};
        assertArrayEquals(new Comparable[]{1,2}, s.sort(listWithTwoUnsortedElements));
    }
}
