package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.*;
import hci.dky.pojo.*;
import hci.dky.service.ExpertWalkthroughService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dky
 * @description: 专家走查
 * @author: Leaf
 * @create: 2020-08-27 15:19
 * @Version: 1.0
 **/
@Service
public class ExpertWalkthroughServiceImpl implements ExpertWalkthroughService {
    @Autowired
    private ExpertMapper expertMapper;

    @Autowired
    private ExpertAnswerPaperMapper expertAnswerPaperMapper;

    @Autowired
    private ExpertQuestionScoreMapper expertQuestionScoreMapper;

    @Autowired
    private AssessAndPlanMapper assessAndPlanMapper;


    @Autowired
    private ExpertTaskMapper expertTaskMapper;



    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public ServerResponse<List> postExpertWalkthroughAnswer(int planId, List<Object> answer) {

        AssessAndPlan assessAndPlan=assessAndPlanMapper.selectByPrimaryKey((long)planId);
        for (Object oneAnswer:answer) {
            Map answerInfo = (Map) oneAnswer;
            int taskId = (int) answerInfo.get("taskId");
            int expertId = (int) answerInfo.get("expertId");
            ExpertTask expertTask = expertTaskMapper.selectByPrimaryKey((long) taskId);
            Expert expert = expertMapper.selectByPrimaryKey((long) expertId);

            ExpertAnswerPaper expertAnswerPaper;
            //查看有没有此答卷
            ExpertAnswerPaperExample expertAnswerPaperExample = new ExpertAnswerPaperExample();
            ExpertAnswerPaperExample.Criteria criteria = expertAnswerPaperExample.createCriteria();
            criteria.andTaskIdEqualTo(expertTask.getId()).andExpertIdEqualTo(expert.getId()).andPlanIdEqualTo(assessAndPlan.getId());
            List<ExpertAnswerPaper> expertAnswerPapers = expertAnswerPaperMapper.selectByExample(expertAnswerPaperExample);
            //如果没有，加上此份答卷
            if (expertAnswerPapers.isEmpty()) {
                expertAnswerPaper = new ExpertAnswerPaper();
                expertAnswerPaper.setExpertId(expert.getId());
                expertAnswerPaper.setPlanId(assessAndPlan.getId());
                expertAnswerPaper.setTaskId(expertTask.getId());
                expertAnswerPaperMapper.insert(expertAnswerPaper);
            } else//如果有 第一项就是
            {
                expertAnswerPaper = expertAnswerPapers.get(0);
            }

            ArrayList<Object> questionAnswerList = (ArrayList<Object>) answerInfo.get("questionAnswer");
            for (Object questionAnswer : questionAnswerList) {
                Map questionInfo = (Map) questionAnswer;
                int questionId = (int) questionInfo.get("questionId");
//                int score = (int) questionInfo.get("score");
                int conformanceScore = (int) questionInfo.get("conformanceScore");
                int importanceScore = (int) questionInfo.get("importanceScore");
                String questionDes = (String) questionInfo.get("questionDes");

                ExpertQuestionScoreExample expertQuestionScoreExample = new ExpertQuestionScoreExample();
                ExpertQuestionScoreExample.Criteria criteria1 = expertQuestionScoreExample.createCriteria();
                criteria1.andPaperIdEqualTo(expertAnswerPaper.getId()).andQuestionNumberEqualTo((long) questionId);
                List<ExpertQuestionScore> expertQuestionScores = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample);

                if (!expertQuestionScores.isEmpty()) {
                    ExpertQuestionScore expertQuestionScore = expertQuestionScores.get(0);
                    expertQuestionScore.setConformanceScore((double)conformanceScore);
                    expertQuestionScore.setImportanceScore((double)importanceScore);
                    expertQuestionScore.setQuestionDes(questionDes);
//                    expertQuestionScore.setQuestionNumber((long)questionId);
                    expertQuestionScoreMapper.updateByPrimaryKey(expertQuestionScore);
                } else {
                    ExpertQuestionScore expertQuestionScore = new ExpertQuestionScore();
                    expertQuestionScore.setConformanceScore((double)conformanceScore);
                    expertQuestionScore.setImportanceScore((double)importanceScore);
                    expertQuestionScore.setQuestionNumber((long)questionId);
                    expertQuestionScore.setQuestionDes(questionDes);
                    expertQuestionScore.setPaperId(expertAnswerPaper.getId());
                    expertQuestionScoreMapper.insert(expertQuestionScore);

                }
            }
        }

        ArrayList<Object> allAnswers= new ArrayList<>();
        ExpertAnswerPaperExample expertAnswerPaperExample1=new ExpertAnswerPaperExample();
        ExpertAnswerPaperExample.Criteria criteria2=expertAnswerPaperExample1.createCriteria();
        criteria2.andPlanIdEqualTo(assessAndPlan.getId());
        List<ExpertAnswerPaper> expertAnswerPaperList=expertAnswerPaperMapper.selectByExample(expertAnswerPaperExample1);

        //System.out.println(expertAnswerPaperList.size());

        for(ExpertAnswerPaper paper:expertAnswerPaperList){
            HashMap<String,Object> AnswerPaper=new HashMap<>();
            AnswerPaper.put("planId",paper.getPlanId());
            AnswerPaper.put("taskId",paper.getTaskId());
            AnswerPaper.put("expertId",paper.getExpertId());

            ArrayList<Object> allScores = new ArrayList<>();
            ExpertQuestionScoreExample expertQuestionScoreExample1 = new ExpertQuestionScoreExample();
            ExpertQuestionScoreExample.Criteria criteria4 = expertQuestionScoreExample1.createCriteria();
            criteria4.andPaperIdEqualTo(paper.getId());
            List<ExpertQuestionScore> expertQuestionScoreList = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample1);

            //System.out.println(expertQuestionScoreList.size());

            for (ExpertQuestionScore expertQuestionScore:expertQuestionScoreList){
                HashMap<String,Object> thisScore= new HashMap();
                thisScore.put("paperId",expertQuestionScore.getPaperId());
                thisScore.put("questionNum",expertQuestionScore.getQuestionNumber());
                thisScore.put("getConformanceScore",expertQuestionScore.getConformanceScore());
                thisScore.put("getImportanceScore",expertQuestionScore.getImportanceScore());
                thisScore.put("getQuestionDes",expertQuestionScore.getQuestionDes());
                allScores.add(thisScore);
            }
            AnswerPaper.put("Score",allScores);
            allAnswers.add(AnswerPaper);

        }
        return ServerResponse.createBySuccess("填写成功",allAnswers);



    }

    @Override
    public ServerResponse<List> getExpertWalkthroughAnswer(int planId) {
        AssessAndPlan assessAndPlan=assessAndPlanMapper.selectByPrimaryKey((long)planId);

        ArrayList<Object> allAnswers = new ArrayList<>();
        ExpertAnswerPaperExample expertAnswerPaperExample1 = new ExpertAnswerPaperExample();
        ExpertAnswerPaperExample.Criteria criteria3 = expertAnswerPaperExample1.createCriteria();
        criteria3.andPlanIdEqualTo(assessAndPlan.getId());
        List<ExpertAnswerPaper> expertAnswerPaperList = expertAnswerPaperMapper.selectByExample(expertAnswerPaperExample1);


        for(ExpertAnswerPaper paper : expertAnswerPaperList)
        {
            HashMap<String,Object> AnswerPaper = new HashMap<>();
            AnswerPaper.put("planId",paper.getPlanId());
            AnswerPaper.put("taskId",paper.getTaskId());
            AnswerPaper.put("expertId",paper.getExpertId());

            ArrayList<Object> allScores = new ArrayList<>();
            //所有题目的答案
            ExpertQuestionScoreExample expertQuestionScoreExample1 = new ExpertQuestionScoreExample();
            ExpertQuestionScoreExample.Criteria criteria4 = expertQuestionScoreExample1.createCriteria();
            criteria4.andPaperIdEqualTo(paper.getId());
            List<ExpertQuestionScore> expertQuestionScoreList = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample1);
            for(ExpertQuestionScore questionScore:expertQuestionScoreList)
            {
                HashMap<String,Object> thisScore = new HashMap<>();
                thisScore.put("paperId",questionScore.getPaperId());
                thisScore.put("questionNum",questionScore.getQuestionNumber());
                thisScore.put("getConformanceScore",questionScore.getConformanceScore());
                thisScore.put("getImportanceScore",questionScore.getImportanceScore());
                thisScore.put("getQuestionDes",questionScore.getQuestionDes());
                allScores.add(thisScore);

            }
            AnswerPaper.put("scores",allScores);
            allAnswers.add(AnswerPaper);
        }

        return ServerResponse.createBySuccess("获取成功",allAnswers);

    }
}
