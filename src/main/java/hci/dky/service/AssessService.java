package hci.dky.service;

import hci.dky.common.ServerResponse;
import hci.dky.dao.IndexLibraryMapper;

import java.util.ArrayList;
import java.util.List;

public interface AssessService {

    public ServerResponse<ArrayList> getIndexesAndMethods();
    public ServerResponse<Boolean> postIndexes(Long assessId, List<Object> indexAndMethod);
    public ServerResponse<Boolean> postAssessInfo(Long assessId,String assessName,String assessDes,String assessObject);
    public ServerResponse<Boolean> postSusSystemName(Long planId,String systemName);


}
