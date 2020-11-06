package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.ArrayList;
import java.util.List;

public interface ExpertService {
    ServerResponse<Boolean> postExpertList(int planId, List<Object> expertList);
    ServerResponse<ArrayList> getExpertList(int planId);
    //ServerResponse<ArrayList> postExpertTask(MultipartFile file,String taskName,String taskDes, int planId);
    ServerResponse<ArrayList> postExpertTask(String taskName,String taskDes,String taskObject, int planId);

    }
