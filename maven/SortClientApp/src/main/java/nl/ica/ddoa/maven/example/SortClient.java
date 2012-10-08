package nl.ica.ddoa.maven.example;

import nl.ica.ddoa.sorter.client.SortService;

import java.util.List;

public final class SortClient
{

    public static final int LENGTH = 10;

    private SortClient()
    {}

    public static void main( String[] args )
    {
        SortClient sortClient = new SortClient();
        ListGenerator listGenerator = new ListGenerator();
        List<Integer> sortedList = sortClient.sort(listGenerator.generate(LENGTH));
        sortClient.printList(sortedList);
    }

    private List<Integer> sort(List<Integer> generate) {
        SortServiceFinder finder = new SortServiceFinder();
        SortService sortService = finder.getSortService();
        return sortService.sort(generate);
    }


    private void printList(List<Integer> sortedList) {
        for(Integer i:sortedList)
        {
            System.out.println(i);
        }
    }
}
