package nl.ica.ddoa.maven.example;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Description for the class ListGeneratorTest:
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
public class ListGeneratorTest {
    private ListGenerator listGenerator;

    @Before
    public void createListGenerator()
    {
        this.listGenerator = new ListGenerator();
    }

    @Test
    public void testGenerateEmptyList() throws Exception {
        assertEquals(0, listGenerator.generate(0).size());
    }

    @Test
    public void testEmptyListGeneratedWhenSizeIsNegative() throws Exception {
        assertEquals(0, listGenerator.generate(-1).size());
    }

    @Test
    public void testGenerateSimpleList() throws Exception {
        assertEquals(10, listGenerator.generate(10).size());
    }
}
