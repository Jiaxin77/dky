package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.List;

public interface SusService {

    public ServerResponse<List> postSusAnswer(int planId, List<Object> answer);
    public ServerResponse<List> getSusAnswer(int planId);
}
