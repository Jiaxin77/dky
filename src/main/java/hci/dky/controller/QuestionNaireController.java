package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.QuestionNaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName QuestionNaireController
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/4/15 9:44 上午
 * @Version 1.0
 **/

@RestController
public class QuestionNaireController {
    @Autowired
    private QuestionNaireService questionNaireService;

    @GetMapping("/getFibModel")
    public ServerResponse<ArrayList> getFibModel()
    {
        ServerResponse<ArrayList> response = questionNaireService.getFibModel();
        return  response;
    }

    @PostMapping("/createQuestionNaire")
    public ServerResponse<Long> createQuestionNaire(@RequestBody Map<String,Object> questionNaire)
   // public ServerResponse<Long> createQuestionNaire(int assessId,String title, String des,@RequestBody List<Integer> modelid, @RequestBody List<Object> questionList)
    {
        Integer assessId = (Integer) questionNaire.get("assessId");
        Integer planId = (Integer) questionNaire.get("planId");
        String title = (String) questionNaire.get("title");
        String des = (String) questionNaire.get("des");
        List<Integer> modelid = (List<Integer>) questionNaire.get("modelid");
        List<Object> questionList = (List<Object>) questionNaire.get("questionList");

        ServerResponse<Long> response = questionNaireService.createQuestionNaire(assessId,planId,title,des,modelid,questionList);
        return  response;

    }

    @GetMapping("/getQuestionNaire")
    public ServerResponse<HashMap<String, Object>> getQuestionNaire(Long id)
    {
        try {
            HashMap<String, Object> response = questionNaireService.getQuestionNaire(id);
            return ServerResponse.createBySuccess("获取成功",response);
        }
        catch (Exception e)
        {
            return ServerResponse.createByErrorMessage("获取失败");
        }

    }

    @PostMapping("/postSurveyPaper")
    public ServerResponse<Boolean> postSurveyPaper(@RequestBody Map<String,Object> paper)
    {
        Integer surveyId = (Integer) paper.get("surveyId");
        List<Object> questionList = (List<Object>) paper.get("questionList");

        ServerResponse<Boolean> response = questionNaireService.postSurveyPaper(surveyId,questionList);
        return response;
    }

    @GetMapping("/getSurveyResult")
    public ServerResponse<HashMap<String, Object>> getSurveyResult(int id)
    {
        ServerResponse<HashMap<String, Object>> response = questionNaireService.getSurveyResult(id);
        return response;
    }
}
