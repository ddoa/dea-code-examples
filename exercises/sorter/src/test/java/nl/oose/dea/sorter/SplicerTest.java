package nl.oose.dea.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SplicerTest {
    private Comparable[] unsortedList = { 10,8,6,4,2,0};
    private Splicer splicer;

    @Before
    public void setup()
    {
        splicer = new Splicer();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenBoundariesAreEmptyAndChunksAreZeroAnExceptionIsThrown() throws Exception {
        ArrayList<ArrayList> chunks = splicer.spliceIntoChunks(unsortedList, new Comparable[]{}, 0);
    }

    @Test
    public void whenBoundariesAreEmptyAndChunksAreOneEverythingIsReturnedInOneChunk() throws Exception {
        ArrayList<ArrayList> chunks = splicer.spliceIntoChunks(unsortedList, new Comparable[]{}, 1);
        assertEquals(1, chunks.size());
        assertEquals(unsortedList.length, chunks.get(0).size());
    }

    @Test
    public void whenOnlyOneBoundaryAvailableAndChunksAreOneAllIsReturnedInOneChunk()
    {
        ArrayList<ArrayList> chunks = splicer.spliceIntoChunks(unsortedList, new Comparable[]{5}, 1);
        assertEquals(1, chunks.size());
        assertEquals(unsortedList.length, chunks.get(0).size());
    }

    @Test
    public void whenTwoBoundariesAvailableAndChunksAreTwoAllIsReturnedInTwoEqualSizedChunk()
    {
        ArrayList<ArrayList> chunks = splicer.spliceIntoChunks(unsortedList, new Comparable[]{5}, 2);
        assertEquals(2, chunks.size());
        assertEquals(unsortedList.length / 2, chunks.get(0).size());
        assertEquals(unsortedList.length / 2, chunks.get(1).size());

    }

}