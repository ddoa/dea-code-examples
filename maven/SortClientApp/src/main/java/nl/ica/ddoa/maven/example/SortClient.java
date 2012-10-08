package nl.ica.ddoa.maven.example;

import nl.ica.ddoa.sorter.client.SortService;

import java.util.List;

public class SortClient
{
    public static void main( String[] args )
    {
        SortClient sortClient = new SortClient();
        ListGenerator listGenerator = new ListGenerator();
        List<Integer> sortedList = sortClient.sort(listGenerator.generate(10));
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
