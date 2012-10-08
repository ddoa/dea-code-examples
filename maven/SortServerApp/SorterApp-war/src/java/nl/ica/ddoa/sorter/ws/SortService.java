/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ica.ddoa.sorter.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import nl.ica.ddoa.sorter.ejb.SorterLocal;

/**
 *
 * @author mdkr
 */
@WebService(serviceName = "SortService")
public class SortService {
    @EJB
    private SorterLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "sort")
    public Integer[] sort(@WebParam(name = "list") Integer[] list) {
        return ejbRef.sort(list);
    }
    
}
