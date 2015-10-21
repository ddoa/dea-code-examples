package nl.ica.ddoa.generics;

/**
 * Description for the class EasySortClient:
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
public class EasySortClient {
    public static void main(String args[])
    {
        EasySortClient easySortClient = new EasySortClient();
        easySortClient.sortSomething();
    }

    private void sortSomething() {
        EasySort<String> easySort = new EasySort<String>();
        Comparable[] result = easySort.sort(new Comparable[] {1, "hoi"});

        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }

    }
}
