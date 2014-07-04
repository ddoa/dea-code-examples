package oose.dea.solid;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class Report {
    private final ReportPrinter reportPrinter = new ReportPrinter();

    public void print() {
        reportPrinter.print();
    }
}
