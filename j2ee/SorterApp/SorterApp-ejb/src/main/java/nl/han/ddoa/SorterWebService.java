package nl.han.ddoa;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mdkr
 */
@WebService(serviceName = "SorterWebService")
@Stateless()
public class SorterWebService {
    @EJB
    private SorterBeanLocal ejbRef;

    @WebMethod(operationName = "sort")
    /**
     * Java uses JAXB to convert standard Java types to XML, it cannot handle Comparables
     * so we use Integer arrays here.
     */
    public Integer[] sort(@WebParam(name = "element") Integer[] listToSort) {
        Comparable[] sortedList = ejbRef.sort(listToSort);
        return comparableArrayToIntArray(sortedList);
    }

    private Integer[] comparableArrayToIntArray(Comparable[] sortedList) {
        Integer[] sortedInts = new Integer[sortedList.length];
        for(int i=0;i<sortedList.length;i++)
        {
            sortedInts[i] = (Integer) sortedList[i];
        }
        return sortedInts;
    }
    
}
