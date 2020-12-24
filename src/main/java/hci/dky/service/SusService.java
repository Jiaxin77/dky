package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.HashMap;
import java.util.List;

public interface SusService {

    ServerResponse<List> postSusAnswer(int planId, List<Object> answer);
    ServerResponse<List> getSusAnswer(int planId);
    ServerResponse<HashMap<String, Object>>  getSusAnalysis(int planId);
}
