package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.ExpertWalkthroughService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: dky
 * @description: 专家走查
 * @author: Leaf
 * @create: 2020-08-27 15:33
 * @Version: 1.0
 **/
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
}
