package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.ArrayList;
import java.util.List;

public interface ExpertService {
    public ServerResponse<Boolean> postExpertList(Long planId, List<Object> expertList);
    public ServerResponse<ArrayList> getExpertList(Long planId);
}
