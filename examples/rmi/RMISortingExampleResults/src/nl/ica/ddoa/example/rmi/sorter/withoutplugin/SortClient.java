package nl.ica.ddoa.example.rmi.sorter.withoutplugin;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SortClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SortClient clt = new SortClient();
        clt.sortList();
    }

    private void sortList() {
        Comparable[] input = {0,9,8,76,5,4,5,6,7,8909,8,7,6,5,67,8};
        try {
            Registry registry = LocateRegistry.getRegistry();
            Remote rmtSorter = registry.lookup("sorter");
            if (rmtSorter instanceof ISorter)
            {
                ISorter sorter = (ISorter) rmtSorter;
                Comparable[] output = sorter.sort(input);
                for (int i = 0; i < output.length; i++) {
                    System.out.println(output[i]);
                }
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    

}
