package hci.artedu.service;



import hci.artedu.common.ServerResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HardwareService {

    ServerResponse<ArrayList> getParam();
    ServerResponse<ArrayList> postParamResult(List<Map<String,Object>> array);
    HashMap<String,Object> compareParam(Object hw);
}
