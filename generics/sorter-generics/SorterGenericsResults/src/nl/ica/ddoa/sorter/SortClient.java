package nl.ica.ddoa.sorter;

/**
 * Description for the class SortClient:
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
public class SortClient {
    public static void main(String[] args) {
        sortIntegers();
        sortStrings();

    }

    private static void sortIntegers() {
        Comparable<Integer>[] list =
                new Comparable[4];
        list[0] = 3;
        list[1] = 2;
        list[2] = 1;
        list[3] = -1;
        EasySort<Integer> bs = new EasySort<Integer>();
        list = bs.sort(list);
        for (int i=0;i<list.length;i++)
        {
            System.out.println(list[i]);
        }
    }

    private static void sortStrings() {
        Comparable<String>[] list =
                new Comparable[4];
        list[0] = "aaaaa";
        list[1] = "Rody";
        list[2] = "Vitesse";
        list[3] = "HAN";
        EasySort<String> bs = new EasySort<String>();
        list = bs.sort(list);
        for (int i=0;i<list.length;i++)
        {
            System.out.println(list[i]);
        }
    }

}
