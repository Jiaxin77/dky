package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExpertController
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/6/10 10:00 上午
 * @Version 1.0
 **/
@RestController
public class ExpertController {

    @Autowired
    private ExpertService expertService;

    @PostMapping("/postExpertList")
    public ServerResponse<Boolean> postExpertList(@RequestBody Map<String,Object> expertInfo)
    {
        /*
         * @Author jiaxin
         * @Description 提交专家清单//TODO
         * @Date 11:23 上午 2020/6/10
         * @Param [expertInfo]
         * @return hci.dky.common.ServerResponse<java.lang.Boolean>
         **/


        Integer planId =(Integer) expertInfo.get("planId");
        List<Object> expertList = (List<Object>) expertInfo.get("expertList");
        ServerResponse<Boolean> response = expertService.postExpertList(planId,expertList);
        return response;
    }

    @GetMapping("/getExpertList")
    public ServerResponse<ArrayList> getExpertList(int planId)
    {
        /**
         * @Author jiaxin
         * @Description 获取专家清单//TODO
         * @Date 11:23 上午 2020/6/10
         * @Param [planId]
         * @return hci.dky.common.ServerResponse<java.util.ArrayList>
         **/

        ServerResponse<ArrayList> response = expertService.getExpertList(planId);
        return response;


    }

    @PostMapping("/postExpertTask")
   // public ServerResponse<ArrayList> postExpertTask(@RequestParam("file")MultipartFile file,@RequestParam("systemName") String systemName,@RequestParam("taskName") String taskName,@RequestParam("taskDes") String taskDes,@RequestParam("planId") int planId)
    public ServerResponse<ArrayList> postExpertTask(@RequestBody Map<String,Object> taskInfo)

    {
        /**
         * @Author jiaxin
         * @Description 提交专家任务//TODO
         * @Date 10:41 上午 2020/6/23
         * @Param [file, systemName, taskDes, planId]
         * @return hci.dky.common.ServerResponse<java.util.ArrayList>
         **/
        String taskName = (String) taskInfo.get("taskName");
        String taskDes = (String) taskInfo.get("taskDes");
        String taskObject = (String) taskInfo.get("taskObject");
        Integer planId = (Integer) taskInfo.get("planId");
        ServerResponse<ArrayList> response = expertService.postExpertTask(taskName,taskDes,taskObject,planId);
        return  response;

    }

}
