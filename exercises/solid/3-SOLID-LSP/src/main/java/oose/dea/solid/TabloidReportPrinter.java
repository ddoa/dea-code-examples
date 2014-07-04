package oose.dea.solid;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class TabloidReportPrinter extends ReportPrinter {

    public final DataAccess dataAccess = new DataAccess();
    public final ReportFormatter reportFormatter = new TabloidReportFormatter();


    public void print() {
        dataAccess.getData();
        reportFormatter.formatReport();
        System.out.println("Printing report to matrix printer");
    }

}
