package hci.dky.service;

import hci.dky.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface ExpertService {
    ServerResponse<Boolean> postExpertList(int planId, List<Object> expertList);
    ServerResponse<ArrayList> getExpertList(int planId);
    ServerResponse<ArrayList> postExpertTask(MultipartFile file, String systemName, String taskDes, int planId);


    }
