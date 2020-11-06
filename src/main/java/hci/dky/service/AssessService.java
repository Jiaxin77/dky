package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.ArrayList;
import java.util.HashMap;
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
    public ServerResponse<Boolean> postBorgSystemName(int planId,String systemName);
    public ServerResponse<String> getBorgSystemName(int planId);
    public ServerResponse<HashMap<String,Object>> getPlanInfo(int planId);

    public ServerResponse<Boolean> beginAssess(int assessId);
    public ServerResponse<Boolean> finishAssess(int assessId);




    }
