package nl.oose.dea.sorter;

import org.junit.Before;
import org.junit.Test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SorterThreadTest {

    private SorterThread sorterThread;
    private SortClient sortClient;

    private ArrayList<Comparable> input = new ArrayList() {{
        for (int i = 0; i < 10; i++) {
            add(i);
        }
    }};
    private Comparable[] output;

    @Before
    public void setUp() throws Exception {
        sortClient = mock(SortClient.class);
        Registry registry = createMockRegistry();
        sorterThread = new SorterThread(input, sortClient, registry);
    }

    private Registry createMockRegistry() throws RemoteException, NotBoundException {
        Registry registry = mock(Registry.class);
        ISorter sorter = createMockSorter();
        when(registry.lookup("rmi://localhost:1099/sorter1")).thenReturn(sorter);
        return registry;
    }

    private ISorter createMockSorter() throws RemoteException {
        ISorter sorter = mock(ISorter.class);
        Comparable[] results = new Comparable[input.size()];
        output = input.toArray(results);
        when(sorter.sort(any(Comparable[].class))).thenReturn(output);
        return sorter;
    }

    @Test
    public void testSend()
    {
        sorterThread.run();
        assertEquals(1, sorterThread.getThreadNumber());
        // Besides asserts we can verify that a method on a
        // dependent object is called with the proper arguments
        verify(sortClient).update(sorterThread, output);
    }


}