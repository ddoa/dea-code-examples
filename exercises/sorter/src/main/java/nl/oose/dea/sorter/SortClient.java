package nl.oose.dea.sorter;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Rody
 */
public class SortClient implements Observer {

    public static final int NR_SORTERS = 5;
    private Object[] results = new Object[NR_SORTERS];
    private int updateCount = 0;

    // Helper classes
    private BoundaryCreator boundaryCreator = new BoundaryCreator();
    private Splicer splicer = new Splicer();
    private SortInputGenerator sortInputGenerator = new SortInputGenerator();
    private ComparableCollectionPrinter comparableCollectionPrinter = new ComparableCollectionPrinter();


    /**
     * @param args
     */
    public static void main(String[] args) {
        SortClient sc = new SortClient();
        sc.generateAndSort("Integer");
    }


    private void generateAndSort(String type) {
        Comparable[] unsortedList = sortInputGenerator.generateCollection(type);
        Comparable[] boundaries = boundaryCreator.getBoundaries(unsortedList, NR_SORTERS);

        sort(unsortedList, boundaries);
    }

    /**
     * Sorting means: - Create chunks to pre-sort the unsortedList into the
     * chunks - Sort the chunks in separate Threads
     *
     * @param unsortedList
     * @param boundaries
     */
    private void sort(Comparable[] unsortedList, Comparable[] boundaries) {
        ArrayList<ArrayList> chunks = splicer.spliceIntoChunks(unsortedList, boundaries, NR_SORTERS);

        for (int i = 0; i < chunks.size(); i++) {
            try {
                Thread t = new Thread(new SorterThread(chunks.get(i), this, LocateRegistry.getRegistry()));
                t.start();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Implementation of Observer-Observable.
     * <p/>
     * The update is called when the SorterThread is ready doing the sorting.
     * The threadNumber is used to keep the results in order.
     *
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        if (o instanceof SorterThread) {
            SorterThread st = (SorterThread) o;
            results[st.getThreadNumber() - 1] = arg;
            updateCount++;
        }
        if (updateCount == NR_SORTERS) {
            comparableCollectionPrinter.print(results);
        }
    }

}