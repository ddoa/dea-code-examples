package nl.oose.dea.sorter;

public class BoundaryCreator {
    /**
     * Determines the boundaries that makes that an element of the non-sorted
     * list is put in one of the chunks
     *
     * For Integers the maximum value is determined and then divided by the
     * number of remote sorters.
     *
     * For Strings the ASCII-value of a String is used.
     *
     * For every other class the toString() method is issued and then the former
     * method (String) is used to sort the array of Objects.
     *
     * @param unsortedList
     * @return
     */
    public Comparable[] getBoundaries(Comparable[] unsortedList, int numberOfBoundaries)
    {
        Comparable[] bounds = new Comparable[numberOfBoundaries];
        Comparable maxValue = determineMaxValue(unsortedList);
        int boundary = 0;
        if (maxValue instanceof String)
        {
            boundary = (int) (((String) maxValue).charAt(0)) / numberOfBoundaries;
            for (int i = 1; i <= bounds.length; i++)
            {
                char nextChar = (char) (boundary * i);
                bounds[i - 1] = new String(new char[]
                        { nextChar });
            }
        }
        else if (maxValue instanceof Integer)
        {
            boundary = ((Integer) maxValue).intValue() / numberOfBoundaries;
            for (int i = 1; i <= bounds.length; i++)
            {
                bounds[i - 1] = new Integer(boundary * i);
            }
        }
        else
        {
            boundary = maxValue.hashCode() / numberOfBoundaries;
            for (int i = 1; i <= bounds.length; i++)
            {
                bounds[i - 1] = new Integer(boundary * i);
            }
        }

        return bounds;
    }

    /**
     * The compareTo method can be used to determine the MAX value in a
     * Comparable array in a generic way
     *
     * @param unsortedList
     * @return
     */
    private Comparable determineMaxValue(Comparable[] unsortedList)
    {
        Comparable max = unsortedList[0];
        for (int i = 0; i < unsortedList.length; i++)
        {
            if (unsortedList[i].compareTo(max) > 0)
                max = unsortedList[i];
        }
        return max;
    }
}
