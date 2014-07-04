package oose.dea.solid;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class LetterReport extends Report {
    private final ReportPrinter reportPrinter = new LetterReportPrinter();

    public void print() {
        reportPrinter.print();
    }
}
