package oose.dea.solid;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class TabloidReport extends Report {
    private final ReportPrinter reportPrinter = new TabloidReportPrinter();

    public void print() {
        reportPrinter.print();
    }
}
