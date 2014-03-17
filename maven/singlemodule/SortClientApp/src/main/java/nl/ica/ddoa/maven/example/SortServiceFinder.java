package nl.ica.ddoa.maven.example;

import nl.ica.ddoa.sorter.client.SortService;
import nl.ica.ddoa.sorter.client.SortService_Service;

/**
 * Description for the class SortServiceFinder:
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
public class SortServiceFinder {
    public SortService getSortService() {
        return new SortService_Service().getSortServicePort();
    }
}
