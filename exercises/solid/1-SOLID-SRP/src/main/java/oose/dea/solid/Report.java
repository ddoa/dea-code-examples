package oose.dea.solid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class Report {
    public void print() {
        getData();
        formatReport();
        System.out.println("Printing report");
    }

    private void formatReport() {
        System.out.println("Formatting report...");
    }

    private List<ReportDataElement> getData() {
        List<ReportDataElement> dataElements = new ArrayList<ReportDataElement>();
        dataElements.add(new ReportDataElement("Rody"));
        return dataElements;
    }
}
