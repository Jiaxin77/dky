package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
