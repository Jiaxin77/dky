package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface QuestionNaireService {

    ServerResponse<ArrayList> getFibModel();
    ServerResponse<Long> createQuestionNaire(int planId, String title, String des, List<Integer> modelid, List<Object> questionList);
    ServerResponse<HashMap<String, Object>> getQuestionNaire(Long id);
    ServerResponse<Boolean> postSurveyPaper(int id,List<Object> questionList);
    ServerResponse<HashMap<String, Object>> getSurveyResult(int id);
}
