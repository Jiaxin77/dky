package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SusController
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/8/17 10:02 上午
 * @Version 1.0
 **/

@RestController
public class SusController {

    @Autowired
    private SusService susService;
//
//    public ServerResponse<List> postSusAnswer(int planId, List<Object> answer);
//    public ServerResponse<List> getSusAnswer(int planId);

    @PostMapping("/postSusAnswer")
    public ServerResponse<List> postSusAnswer(@RequestBody Map<String, Object> susAnswerInfo)
    {
        Integer planId = (Integer) susAnswerInfo.get("planId");
        List<Object> answer = (List<Object>) susAnswerInfo.get("answer");
        ServerResponse<List> response = susService.postSusAnswer(planId,answer);
        return response;
    }

    @GetMapping("getSusAnswer")
    public ServerResponse<List> getSusAnswer(Integer planId)
    {
        ServerResponse<List> response = susService.getSusAnswer(planId);
        return response;
    }

}
