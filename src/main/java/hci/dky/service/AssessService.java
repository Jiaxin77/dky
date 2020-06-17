package hci.dky.service;

import hci.dky.common.ServerResponse;
import hci.dky.dao.IndexLibraryMapper;
import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

public interface AssessService {

    public ServerResponse<ArrayList> getIndexesAndMethods();
    public ServerResponse<Long> postIndexes(Integer assessId, List<Object> indexAndMethod);
    public ServerResponse<ArrayList> getAssessPlan(int assessId);
    public ServerResponse<Boolean> postAssessInfo(int assessId,String assessName,String assessDes,String assessObject);
    public ServerResponse<Boolean> postSusSystemName(int planId,String systemName);
    public ServerResponse<ArrayList> getPlanAndMethodInfo(int assessId);
    public ServerResponse<String> getSusSystemName(int planId);
    public ServerResponse<ArrayList> getAssessList();



}
