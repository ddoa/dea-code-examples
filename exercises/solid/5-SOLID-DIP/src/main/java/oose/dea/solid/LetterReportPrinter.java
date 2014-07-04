package oose.dea.solid;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class LetterReportPrinter extends ReportPrinter {
    public final IReportDataAccess reportDataAcccess = new ReportDataAccess();
    public final ReportFormatter reportFormatter = new LetterReportFormatter();

    public void print() {
        reportDataAcccess.getReportData();
        reportFormatter.formatReport();
        System.out.println("Printing report to laser printer");
    }
}
