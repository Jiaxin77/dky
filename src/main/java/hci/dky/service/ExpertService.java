package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.ArrayList;
import java.util.List;

public interface ExpertService {
    ServerResponse<Boolean> postExpertList(int planId, List<Object> expertList);
    ServerResponse<ArrayList> getExpertList(int planId);

}
