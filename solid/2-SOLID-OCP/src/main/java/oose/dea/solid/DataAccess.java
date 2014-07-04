package oose.dea.solid;

import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    public List<ReportDataElement> getData() {
        List<ReportDataElement> dataElements = new ArrayList<ReportDataElement>();
        dataElements.add(new ReportDataElement("Rody"));
        return dataElements;
    }
}