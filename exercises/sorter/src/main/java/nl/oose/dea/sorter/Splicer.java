package nl.oose.dea.sorter;

import java.util.ArrayList;

public class Splicer {
    public ArrayList<ArrayList> spliceIntoChunks(Comparable[] unsortedList, Comparable[] boundaries, int numberOfChunks) {
        ArrayList<ArrayList> chunks = createChunks(numberOfChunks);
        for (int i = 0; i < unsortedList.length; i++) {
            int boundIndex = 0;
            while (boundIndex < (numberOfChunks - 1) && unsortedList[i].compareTo(boundaries[boundIndex]) >= 1) {
                boundIndex++;
            }
            chunks.get(boundIndex).add(unsortedList[i]);
        }
        return chunks;
    }

    /**
     * Create as much chunks as there are remote sorters
     *
     * @param length
     * @return
     */
    private ArrayList<ArrayList> createChunks(int length) {
        ArrayList chunks = new ArrayList();
        for (int i = 0; i < length; i++) {
            chunks.add(new ArrayList());
        }
        return chunks;
    }
}
