package oose.dea.solid;

import java.util.List;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public interface IDataAccess extends IReportDataAccess {

    List<IDataElement> queryData(String queryString);

    void saveData(IDataElement elementToSave);
}
