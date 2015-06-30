package nl.oose.dea.sorter;

public class ComparableCollectionPrinter {
    /**
     * Shows the contents of an array containing one or more Comparable[]
     * instances.
     *
     * @param oArray
     */
    public void print(Object[] oArray)
    {
        System.out.println("The list contains now the following values:");
        for (int i = 0; i < oArray.length; i++)
        {
            Comparable[] list = (Comparable[]) oArray[i];
            if (list != null)
                printList(list);
        }
    }

    /**
     * Print the elements of a Comparable array
     *
     * @param unsortedList
     */
    private void printList(Comparable[] unsortedList)
    {
        for (int i = 0; i < unsortedList.length; i++)
        {
            System.out.println(unsortedList[i]);
        }
    }
}
