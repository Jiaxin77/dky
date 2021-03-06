package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.*;
import hci.dky.pojo.*;
import hci.dky.service.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName SusServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/7/2 6:21 下午
 * @Version 1.0
 **/

@Service
public class SusServiceImpl implements SusService {
    @Autowired
    private SusScaleMapper susScaleMapper;
    @Autowired
    private SusScaleAnswerPaperMapper susScaleAnswerPaperMapper;
    @Autowired
    private SusScaleQuestionScoreMapper susScaleQuestionScoreMapper;
    @Autowired
    private AssessAndPlanMapper assessAndPlanMapper;


    @Autowired
    private ExpertTaskMapper expertTaskMapper;
    @Autowired
    private ExpertMapper expertMapper;

    

    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<List> postSusAnswer(int planId,List<Object> answer)
    {
        /**
         * @Author jiaxin
         * @Description //提交用户的打分
         * @Date 11:01 上午 2020/7/3
         * @Param [planId, answer（任务，专家ID，题号，分数）]
         * @return hci.dky.common.ServerResponse<java.util.List>
         **/

        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);

        for(Object oneAnswer : answer) {
            Map answerInfo = (Map) oneAnswer;
            int taskId = (int) answerInfo.get("taskId");
            int expertId = (int) answerInfo.get("expertId");
      //      int questionId = (int) answerInfo.get("questionId");
      //      int score = (int) answerInfo.get("score");

            ExpertTask expertTask = expertTaskMapper.selectByPrimaryKey((long) taskId);
            Expert expert = expertMapper.selectByPrimaryKey((long) expertId);

            SusScaleAnswerPaper susScaleAnswerPaper;
            //查看有没有此答卷
            SusScaleAnswerPaperExample susScaleAnswerPaperExample = new SusScaleAnswerPaperExample();
            SusScaleAnswerPaperExample.Criteria criteria = susScaleAnswerPaperExample.createCriteria();
            criteria.andTaskIdEqualTo(expertTask.getId()).andExpertIdEqualTo(expert.getId()).andPlanIdEqualTo(assessAndPlan.getId());
            List<SusScaleAnswerPaper> susScaleAnswerPapers = susScaleAnswerPaperMapper.selectByExample(susScaleAnswerPaperExample);
            //如果没有，加上此份答卷
            if (susScaleAnswerPapers.isEmpty()) {
                susScaleAnswerPaper = new SusScaleAnswerPaper();
                susScaleAnswerPaper.setExpertId(expert.getId());
                susScaleAnswerPaper.setPlanId(assessAndPlan.getId());
                susScaleAnswerPaper.setTaskId(expertTask.getId());
                susScaleAnswerPaperMapper.insert(susScaleAnswerPaper);
            } else//如果有 第一项就是
            {
                susScaleAnswerPaper = susScaleAnswerPapers.get(0);
            }

            ArrayList<Object> questionAnswerList = (ArrayList<Object>) answerInfo.get("questionAnswer");
            for(Object questionAnswer : questionAnswerList)
            {
                Map questionInfo = (Map) questionAnswer;
                int questionId = (int) questionInfo.get("questionId");
                int score = (int) questionInfo.get("score");

                //看看有没有这道题的
                SusScaleQuestionScoreExample susScaleQuestionScoreExample = new SusScaleQuestionScoreExample();
                SusScaleQuestionScoreExample.Criteria criteria1 = susScaleQuestionScoreExample.createCriteria();
                criteria1.andSusPaperIdEqualTo(susScaleAnswerPaper.getId()).andQuestionNumberEqualTo((long) questionId);
                List<SusScaleQuestionScore> susScaleQuestionScores = susScaleQuestionScoreMapper.selectByExample(susScaleQuestionScoreExample);

                //如果有 - 替换为新答案
                if (!susScaleQuestionScores.isEmpty()) {
                    SusScaleQuestionScore susScaleQuestionScore = susScaleQuestionScores.get(0);
                    susScaleQuestionScore.setScore((long) score);
                    susScaleQuestionScoreMapper.updateByPrimaryKey(susScaleQuestionScore);

                }
                //如果没有 - 增加这道题的答案
                else {
                    SusScaleQuestionScore susScaleQuestionScore = new SusScaleQuestionScore();
                    susScaleQuestionScore.setScore((long) score);
                    susScaleQuestionScore.setQuestionNumber((long) questionId);
                    susScaleQuestionScore.setSusPaperId(susScaleAnswerPaper.getId());
                    susScaleQuestionScoreMapper.insert(susScaleQuestionScore);
                }

            }


        }

        //返回当前的答案列表；按照任务 - 用户 - 分数？
        ArrayList<Object> allAnswers = new ArrayList<>();
        SusScaleAnswerPaperExample susScaleAnswerPaperExample1 = new SusScaleAnswerPaperExample();
        SusScaleAnswerPaperExample.Criteria criteria3 = susScaleAnswerPaperExample1.createCriteria();
        criteria3.andPlanIdEqualTo(assessAndPlan.getId());
        List<SusScaleAnswerPaper> susScaleAnswerPaperList = susScaleAnswerPaperMapper.selectByExample(susScaleAnswerPaperExample1);


        for(SusScaleAnswerPaper paper : susScaleAnswerPaperList)
        {
            HashMap<String,Object> AnswerPaper = new HashMap<>();
            AnswerPaper.put("planId",paper.getPlanId());
            AnswerPaper.put("taskId",paper.getTaskId());
            AnswerPaper.put("expertId",paper.getExpertId());

            ArrayList<Object> allScores = new ArrayList<>();
            //所有题目的答案
            SusScaleQuestionScoreExample susScaleQuestionScoreExample1 = new SusScaleQuestionScoreExample();
            SusScaleQuestionScoreExample.Criteria criteria4 = susScaleQuestionScoreExample1.createCriteria();
            criteria4.andSusPaperIdEqualTo(paper.getId());
            List<SusScaleQuestionScore> susScaleQuestionScoreList = susScaleQuestionScoreMapper.selectByExample(susScaleQuestionScoreExample1);

            for(SusScaleQuestionScore questionScore:susScaleQuestionScoreList)
            {
                HashMap<String,Object> thisScore = new HashMap<>();
                thisScore.put("paperId",questionScore.getSusPaperId());
                thisScore.put("questionNum",questionScore.getQuestionNumber());
                thisScore.put("score",questionScore.getScore());
                allScores.add(thisScore);

            }
            AnswerPaper.put("scores",allScores);
            allAnswers.add(AnswerPaper);
        }

        return ServerResponse.createBySuccess("填写成功",allAnswers);



    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)//增加事务回滚
    public ServerResponse<List> getSusAnswer(int planId)
    {
        /**
         * @Author jiaxin
         * @Description 获取sus量表的答案（用于查看） —— 分析也可用？//TODO
         * @Date 11:30 上午 2020/7/20
         * @Param [planId]
         * @return hci.dky.common.ServerResponse<java.util.List>
         **/
        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);

        //返回当前的答案列表；按照任务 - 用户 - 分数？
        ArrayList<Object> allAnswers = new ArrayList<>();
        SusScaleAnswerPaperExample susScaleAnswerPaperExample1 = new SusScaleAnswerPaperExample();
        SusScaleAnswerPaperExample.Criteria criteria3 = susScaleAnswerPaperExample1.createCriteria();
        criteria3.andPlanIdEqualTo(assessAndPlan.getId());
        List<SusScaleAnswerPaper> susScaleAnswerPaperList = susScaleAnswerPaperMapper.selectByExample(susScaleAnswerPaperExample1);


        for(SusScaleAnswerPaper paper : susScaleAnswerPaperList)
        {
            HashMap<String,Object> AnswerPaper = new HashMap<>();
            AnswerPaper.put("planId",paper.getPlanId());
            AnswerPaper.put("taskId",paper.getTaskId());
            AnswerPaper.put("expertId",paper.getExpertId());

            ArrayList<Object> allScores = new ArrayList<>();
            //所有题目的答案
            SusScaleQuestionScoreExample susScaleQuestionScoreExample1 = new SusScaleQuestionScoreExample();
            SusScaleQuestionScoreExample.Criteria criteria4 = susScaleQuestionScoreExample1.createCriteria();
            criteria4.andSusPaperIdEqualTo(paper.getId());
            List<SusScaleQuestionScore> susScaleQuestionScoreList = susScaleQuestionScoreMapper.selectByExample(susScaleQuestionScoreExample1);
            for(SusScaleQuestionScore questionScore:susScaleQuestionScoreList)
            {
                HashMap<String,Object> thisScore = new HashMap<>();
                thisScore.put("paperId",questionScore.getSusPaperId());
                thisScore.put("questionNum",questionScore.getQuestionNumber());
                thisScore.put("score",questionScore.getScore());
                allScores.add(thisScore);

            }
            AnswerPaper.put("scores",allScores);
            allAnswers.add(AnswerPaper);
        }

        return ServerResponse.createBySuccess("获取答案成功",allAnswers);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<HashMap<String, Object>>  getSusAnalysis(int planId) {
        /**
         * TODO Sus分析
         * @return hci.dky.common.ServerResponse<java.util.List>
         * @Description 
         * @Author Leaf
         * @Date 2020/12/24 下午12:05
         **/
        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);
        HashMap<String, Object> res = new HashMap<String, Object>();
        //返回当前的答案列表；按照任务 - 用户 - 分数？
        ArrayList<Object> allAnswers = new ArrayList<>();
        SusScaleAnswerPaperExample susScaleAnswerPaperExample1 = new SusScaleAnswerPaperExample();
        SusScaleAnswerPaperExample.Criteria criteria3 = susScaleAnswerPaperExample1.createCriteria();
        criteria3.andPlanIdEqualTo(assessAndPlan.getId());
        List<SusScaleAnswerPaper> susScaleAnswerPaperList = susScaleAnswerPaperMapper.selectByExample(susScaleAnswerPaperExample1);
        HashSet<Long> taskSet = new HashSet<>();
        for(SusScaleAnswerPaper paper : susScaleAnswerPaperList)
        {
            taskSet.add(paper.getTaskId());//获得taskId的set
        }
        for (Long taskId:taskSet){
            HashMap<String,Object> answerPaper = new HashMap<>();
            answerPaper.put("taskId",taskId);
            double totalAverage = 0;
            double totalSum;
            ArrayList<Object> allScores = new ArrayList<>();
            int size = 0;
            for(SusScaleAnswerPaper paper : susScaleAnswerPaperList) {
                if (Objects.equals(paper.getTaskId(), taskId)) {
                    SusScaleQuestionScoreExample susScaleQuestionScoreExample1 = new SusScaleQuestionScoreExample();
                    SusScaleQuestionScoreExample.Criteria criteria4 = susScaleQuestionScoreExample1.createCriteria();
                    criteria4.andSusPaperIdEqualTo(paper.getId());
                    List<SusScaleQuestionScore> susScaleQuestionScoreList = susScaleQuestionScoreMapper.selectByExample(susScaleQuestionScoreExample1);
                    size = susScaleQuestionScoreList.size();
                }
            }
            for (int questionNumber = 1 ; questionNumber <= size ; questionNumber++){
                double max = Double.MIN_VALUE, min = Double.MAX_VALUE, sum = 0, standardDeviation , count = 0, average = 0, deviationSum = 0;
                for(SusScaleAnswerPaper paper : susScaleAnswerPaperList) {
                    if (Objects.equals(paper.getTaskId(), taskId)) {
                        SusScaleQuestionScoreExample susScaleQuestionScoreExample1 = new SusScaleQuestionScoreExample();
                        SusScaleQuestionScoreExample.Criteria criteria4 = susScaleQuestionScoreExample1.createCriteria();
                        criteria4.andSusPaperIdEqualTo(paper.getId());
                        List<SusScaleQuestionScore> susScaleQuestionScoreList = susScaleQuestionScoreMapper.selectByExample(susScaleQuestionScoreExample1);
                        for(SusScaleQuestionScore questionScore:susScaleQuestionScoreList) {
                            if (questionScore.getQuestionNumber() == questionNumber) {
                                if(questionScore.getScore() > max){
                                    max = questionScore.getScore();
                                }
                                if(questionScore.getScore() < min){
                                    min = questionScore.getScore();
                                }
                                sum += questionScore.getScore();
                                count += 1;
                            }
                        }
                        average = sum / count;
                        for(SusScaleQuestionScore questionScore:susScaleQuestionScoreList) {
                            if (questionScore.getQuestionNumber() == questionNumber) {
                                deviationSum += (questionScore.getScore() - average) * (questionScore.getScore() - average);
                            }
                        }
                    }
                }
                standardDeviation = Math.sqrt(deviationSum/count);
                HashMap<String,Object> thisScore = new HashMap<>();
                thisScore.put("min", min);
                thisScore.put("max", max);
                thisScore.put("average", String.format("%.2f", average));
                thisScore.put("standardDeviation", String.format("%.2f", standardDeviation));
                thisScore.put("questionNum",questionNumber);
                allScores.add(thisScore);
                totalAverage += average;
            }
            answerPaper.put("scores", allScores);
            answerPaper.put("average", String.format("%.2f", totalAverage/size));
            allAnswers.add(answerPaper);
        }
        res.put("allAnswers", allAnswers);
        return ServerResponse.createBySuccess("获取答案成功",res);
    }
}
