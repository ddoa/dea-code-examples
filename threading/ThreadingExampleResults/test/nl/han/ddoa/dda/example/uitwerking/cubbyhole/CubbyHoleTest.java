package nl.han.ddoa.dda.example.uitwerking.cubbyhole;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Description for the class CubbyHoleTest:
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
public class CubbyHoleTest {
    @Test
    public void theNumberPutMustBeAvailableWhenGot()
    {
        CubbyHole cubbyHole = new CubbyHole();
        cubbyHole.put(1);
        assertEquals(1, cubbyHole.get());
    }
}
