package hci.dky.service;

import hci.dky.common.ServerResponse;
import hci.dky.pojo.SurveyLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface QuestionNaireService {

    ServerResponse<ArrayList> getFibModel();
    ServerResponse<Long> createQuestionNaire(int assessId ,int planId, String title, String des, List<Integer> modelid, List<Object> questionList,int surveyId);//surveyId用于指示是新建还是编辑
    HashMap<String, Object> getQuestionNaire(Long id);
    ServerResponse<Boolean> postSurveyPaper(int id,List<Object> questionList);
    ServerResponse<HashMap<String, Object>> getSurveyResult(int id);
    ServerResponse<List<SurveyLibrary>> getQuestionNaireList();
}
