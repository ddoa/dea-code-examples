package oose.dea.solid;

public class ReportPrinter {
    private final DataAccess dataAccess = new DataAccess();
    private final ReportFormatter reportFormatter = new ReportFormatter();

    public ReportPrinter() {
    }

    public void print() {
        dataAccess.getData();
        reportFormatter.formatReport();
        System.out.println("Printing report to laser printer");
    }
}