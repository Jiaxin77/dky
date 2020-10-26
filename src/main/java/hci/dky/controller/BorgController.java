package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.BorgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BorgController
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/8/17 10:02 上午
 * @Version 1.0
 **/
@RestController
public class BorgController {
//    public ServerResponse<List> postBorgAnswer(int planId, List<Object> answer);
//    public ServerResponse<List> getBorgAnswer(int planId);
//    public ServerResponse<HashMap<String,Object>> getBorgResults(int planId);

    @Autowired
    private BorgService borgService;

    @PostMapping("/postBorgAnswer")
    public ServerResponse<List> postBorgAnswer(@RequestBody  Map<String,Object> borgAnswerInfo)
    {
        Integer planId = (Integer) borgAnswerInfo.get("planId");
        List<Object> answer = (List<Object>) borgAnswerInfo.get("answer");
        ServerResponse<List> response = borgService.postBorgAnswer(planId,answer);
        return response;
    }

    @GetMapping("/getBorgAnswer")
    public ServerResponse<List> getBorgAnswer(Integer planId)
    {
        ServerResponse<List> response = borgService.getBorgAnswer(planId);
        return response;
    }

    @GetMapping("/getBorgResults")
    public ServerResponse<HashMap<String,Object>> getBorgResults(Integer planId)
    {
        ServerResponse<HashMap<String,Object>> response = borgService.getBorgResults(planId);
        return response;
    }



}
