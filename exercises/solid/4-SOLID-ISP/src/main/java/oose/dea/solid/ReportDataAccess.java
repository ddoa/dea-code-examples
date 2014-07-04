package oose.dea.solid;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class ReportDataAccess implements IDataAccess {
    public List<IDataElement> getReportData() {
        List<IDataElement> dataElements = new ArrayList<IDataElement>();
        dataElements.add(new ReportDataElement("Rody"));
        return dataElements;
    }

    @Override
    public List<IDataElement> queryData(String queryString) {
        throw new NotImplementedException();
    }

    @Override
    public void saveData(IDataElement elementToSave) {
        throw new NotImplementedException();
    }
}