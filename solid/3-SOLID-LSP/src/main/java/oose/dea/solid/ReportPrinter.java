package oose.dea.solid;

public class ReportPrinter {
    public final DataAccess dataAccess = new DataAccess();
    public final ReportFormatter reportFormatter = new ReportFormatter();

    public ReportPrinter() {
    }

    public void print() {
        dataAccess.getData();
        reportFormatter.formatReport();
        System.out.println("Printing report to laser printer");
    }
}