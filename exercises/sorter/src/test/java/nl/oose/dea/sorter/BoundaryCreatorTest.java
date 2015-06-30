package nl.oose.dea.sorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoundaryCreatorTest {

    private BoundaryCreator boundaryCreator;

    @Before
    public void setup()
    {
        boundaryCreator = new BoundaryCreator();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenBoundariesAreCalculatedForAnEmptyListAnExceptionIsThrown() throws Exception {
        boundaryCreator.getBoundaries(new Comparable[]{}, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void whenBoundariesAreCalculatedForAnNonEmptyListAndZeroServersAvailableADivisionByZeroIsThrown() throws Exception {
        boundaryCreator.getBoundaries(new Comparable[]{1}, 0);
    }

    @Test
    public void whenBoundariesAreCalculatedForAnNonEmptyListAndOneServerTheBoundaryEqualsTheInput() throws Exception {
        Comparable[] list = {2};
        Comparable[] boundaries = boundaryCreator.getBoundaries(list, 1);
        assertEquals(boundaries.length, 1);
        assertEquals(boundaries[0], list[0]);
    }

    @Test
    public void whenBoundariesAreCalculatedForAnNonEmptyListAndMoreOneServer() throws Exception {
        Comparable[] list = {0, 500, 1000};
        Comparable[] boundaries = boundaryCreator.getBoundaries(list, 2);
        assertEquals(boundaries.length, 2);
        assertEquals(boundaries[0], list[1]);
        assertEquals(boundaries[1], list[2]);
    }

    @Test
    public void whenBoundariesAreCalculatedForAnNonEmptyStringListAndMoreOneServer() throws Exception {
        Comparable[] list = {"a", "m", "z"};
        Comparable[] boundaries = boundaryCreator.getBoundaries(list, 2);
        assertEquals(boundaries.length, 2);
        assertEquals(boundaries[0], "=");
        assertEquals(boundaries[1], "z");
    }

    @Test
    public void whenBoundariesAreCalculatedForAnNonEmptyDoubleListAndMoreOneServer() throws Exception {
        Comparable[] list = {0.0, 500.0, 1000.0};
        Comparable[] boundaries = boundaryCreator.getBoundaries(list, 2);
        assertEquals(boundaries.length, 2);
        assertEquals(boundaries[0], 541564928);
        assertEquals(boundaries[1], 1083129856);
    }




}