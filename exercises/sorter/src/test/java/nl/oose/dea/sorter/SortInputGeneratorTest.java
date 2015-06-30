package nl.oose.dea.sorter;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortInputGeneratorTest {

    @Test
    public void whenTypeNotSupportedAllItemsInCollectionAreNull() throws Exception {
        SortInputGenerator sortInputGenerator = new SortInputGenerator();
        Comparable[] collection = sortInputGenerator.generateCollection("none");
        assertNull(collection[0]);
    }

    @Test
    public void whenCollectionOfStringsRequestedTheSizeIs1000AndTypeIsString() throws Exception {
        SortInputGenerator sortInputGenerator = new SortInputGenerator();
        Comparable[] collection = sortInputGenerator.generateCollection("String");
        assertTrue(collection[0] instanceof String);
        assertEquals(SortInputGenerator.MAX_ELEMENTS, collection.length);
    }

    @Test
    public void whenCollectionOfIntegersRequestedTheSizeIs1000AndTypeIsInteger() throws Exception {
        SortInputGenerator sortInputGenerator = new SortInputGenerator();
        Comparable[] collection = sortInputGenerator.generateCollection("Integer");
        assertTrue(collection[0] instanceof Integer);
        assertEquals(SortInputGenerator.MAX_ELEMENTS, collection.length);
    }

}