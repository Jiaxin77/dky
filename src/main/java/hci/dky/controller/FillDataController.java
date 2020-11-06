package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.FillDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName FillDataController
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/8/17 10:03 上午
 * @Version 1.0
 **/

@RestController
public class FillDataController {

    @Autowired
    private FillDataService fillDataService;
//
//
//    public ServerResponse<List> addTask(int planId, String taskName, String taskObject, String taskDes);
//    public ServerResponse<List> addPeople(int planId,String expertName,String expertBackground,String expertDes);
//
//
    @PostMapping("/addTask")
    public ServerResponse<List> addTask(@RequestBody Map<String,Object> taskInfo)
    {
        Integer planId = (Integer) taskInfo.get("planId");
        String taskName = (String) taskInfo.get("taskName");
        String taskObject = (String) taskInfo.get("taskObject");
        String taskDes = (String) taskInfo.get("taskDes");

        ServerResponse<List> response = fillDataService.addTask(planId,taskName,taskObject,taskDes);
        return response;

    }

    @PostMapping("/addPeople")
    public ServerResponse<List> addPeople(@RequestBody Map<String,Object> peopleInfo)
    {
        Integer planId = (Integer) peopleInfo.get("planId");
        String expertName = (String) peopleInfo.get("expertName");
        String expertBackground = (String) peopleInfo.get("expertBackground");
        String expertDes = (String) peopleInfo.get("expertDes");

        ServerResponse<List> response = fillDataService.addPeople(planId,expertName,expertBackground,expertDes);
        return response;

    }




}
