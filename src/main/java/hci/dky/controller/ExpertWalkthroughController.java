package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.ExpertWalkthroughService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dky
 * @description: 专家走查
 * @author: Leaf
 * @create: 2020-08-27 15:33
 * @Version: 1.0
 **/
@Api(value="ExpertWalkthroughController",tags={"专家走查操作接口"})
@RestController
public class ExpertWalkthroughController {
    @Autowired
    private ExpertWalkthroughService expertWalkthroughService;

    @PostMapping("/postExpertWalkthroughAnswer")
    public ServerResponse<List> postExperWalkThroughAnser(@RequestBody Map<String, Object> expertWalkthroughAnswerInfo)
    {
        Integer planId = (Integer) expertWalkthroughAnswerInfo.get("planId");
        List<Object> answer = (List<Object>) expertWalkthroughAnswerInfo.get("answer");
        ServerResponse<List> response = expertWalkthroughService.postExpertWalkthroughAnswer(planId,answer);
        return response;
    }

    @GetMapping("/getExpertWalkthroughAnswer")
    public ServerResponse<List> getExpertWalkthroughAnswer(Integer planId)
    {
        ServerResponse<List> response = expertWalkthroughService.getExpertWalkthroughAnswer(planId);
        return response;
    }
    @ApiOperation(value = "获取专家走查分析结果")
    @ApiParam(name="planId",value="任务Id",required=true)
    @GetMapping("/getExpertWalkthroughAnswer1")
    public ServerResponse<HashMap<String, Object>> getExpertWalkthroughAnswer1(Integer planId)
    {
        ServerResponse<HashMap<String, Object>> response = expertWalkthroughService.getExpertWalkthroughAnswer1(planId);
        return response;
    }
}
