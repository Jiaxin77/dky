package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.AssessService;
import javafx.concurrent.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AssessController
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/5/18 9:46 上午
 * @Version 1.0
 **/

@RestController
public class AssessController {
    @Autowired
    private AssessService assessService;

    @GetMapping("/getIndexesAndMethods")
    public ServerResponse<ArrayList> getIndexesAndMethods(){
        ServerResponse<ArrayList> response = assessService.getIndexesAndMethods();
        return response;
    }


    @PostMapping("/postIndexesAndMethods")
    public ServerResponse<Boolean> postIndexesAndMethods(@RequestBody Map<String,Object> assessIndex)
    {
        Long assessId = (Long) assessIndex.get("assessId");
        List<Object> indexData = (List<Object>) assessIndex.get("indexData");
        ServerResponse<Boolean> response = assessService.postIndexes(assessId,indexData);
        return response;
    }

    @PostMapping("/postAssessInfo")
    public ServerResponse<Boolean> postAssessInfo(@RequestBody Map<String,Object> assessInfo)
    {
        Long assessId = (Long) assessInfo.get("assessId");
        String assessName = (String) assessInfo.get("assessName");
        String assessDes = (String) assessInfo.get("assessDes");
        String assessObject = (String) assessInfo.get("assessObject");
        ServerResponse<Boolean> response = assessService.postAssessInfo(assessId,assessName,assessDes,assessObject);
        return  response;
    }

    @PostMapping("/postSusSystemName")
    public ServerResponse<Boolean> postSusSystemName(@RequestBody Map<String,Object> susInfo)
    {
        Long planId = (Long) susInfo.get("planId");
        String systemName = (String) susInfo.get("systemName");
        ServerResponse<Boolean> response = assessService.postSusSystemName(planId,systemName);
        return response;


    }




}
