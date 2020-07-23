package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.List;

public interface BorgService {
    public ServerResponse<List> postBorgAnswer(int planId, List<Object> answer);
    public ServerResponse<List> getBorgAnswer(int planId);
}
