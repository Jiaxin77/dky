package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface QuestionNaireService {

    ServerResponse<ArrayList> getFibModel();
    ServerResponse<Long> createQuestionNaire(int assessId, String title, String des, List<Integer> modelid, List<Object> questionList);
    ServerResponse<HashMap<String, Object>> getQuestionNaire(Long id);
    public ServerResponse<Boolean> postSurveyPaper(int id,List<Object> questionList);
    public List<Object>  countFrequency(List<String> wordList);
    public ServerResponse<HashMap<String, Object>> getSurveyResult(int id);
}
