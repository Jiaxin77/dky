package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.*;
import hci.dky.pojo.*;
import hci.dky.service.FillDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FillDataServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/7/3 10:57 上午
 * @Version 1.0
 **/

@Service
public class FillDataServiceImpl implements FillDataService {


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
    public ServerResponse<List> addTask(int planId, String taskName, String taskObject, String taskDes)
    {
        /**
         * @Author jiaxin
         * @Description 添加任务，添加到任务清单中
         * @Date 10:54 上午 2020/7/3
         * @Param [planId, taskName, taskObject, taskDes]
         * @return 添加后的任务清单
         **/

        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);

        ExpertTask expertTask = new ExpertTask();
        expertTask.setPlanId(assessAndPlan.getId());
        expertTask.setSystemName(taskObject);
        expertTask.setTaskName(taskName);
        expertTask.setTaskDes(taskDes);

        expertTaskMapper.insert(expertTask);

        //获取该方案所有任务
        ExpertTaskExample expertTaskExample = new ExpertTaskExample();
        ExpertTaskExample.Criteria criteria = expertTaskExample.createCriteria();
        criteria.andPlanIdEqualTo(assessAndPlan.getId());
        List<ExpertTask> expertTasks = expertTaskMapper.selectByExample(expertTaskExample);
        ArrayList<ExpertTask> expertTaskArrayList = new ArrayList<>(expertTasks);

        return ServerResponse.createBySuccess("成功添加", expertTaskArrayList);


    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<List> addPeople(int planId,String expertName,String expertBackground,String expertDes)
    {
        /**
         * @Author jiaxin
         * @Description 增加被试
         * @Date 11:00 上午 2020/7/3
         * @Param [planId, expertName, expertBackground, expertDes]
         * @return 返回当前的专家清单
         **/
        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);

        Expert expert = new Expert();
        expert.setName(expertName);
        expert.setBackground(expertBackground);
        expert.setRemarks(expertDes);
        expert.setAssessObject(assessAndPlan.getAssessObject());


        ExpertExample expertExample = new ExpertExample();
        ExpertExample.Criteria expertCriteria = expertExample.createCriteria();
        expertCriteria.andPlanIdEqualTo((long)planId);
        List<Expert> experts = expertMapper.selectByExample(expertExample);

        ArrayList<Object> expertList = new ArrayList<Object>(experts);
        return ServerResponse.createBySuccess("专家增加成功",expertList);


    }

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

        for(Object oneAnswer : answer)
        {
            Map answerInfo = (Map) oneAnswer;
            int taskId = (int)answerInfo.get("taskId");
            int expertId = (int)answerInfo.get("expertId");
            int questionId = (int)answerInfo.get("questionId");
            int score = (int)answerInfo.get("score");

            ExpertTask expertTask = expertTaskMapper.selectByPrimaryKey((long)taskId);
            Expert expert = expertMapper.selectByPrimaryKey((long)expertId);

            SusScaleAnswerPaper susScaleAnswerPaper;
            //查看有没有此答卷
            SusScaleAnswerPaperExample susScaleAnswerPaperExample = new SusScaleAnswerPaperExample();
            SusScaleAnswerPaperExample.Criteria criteria = susScaleAnswerPaperExample.createCriteria();
            criteria.andTaskIdEqualTo(expertTask.getId()).andExpertIdEqualTo(expert.getId()).andPlanIdEqualTo(assessAndPlan.getId());
            List<SusScaleAnswerPaper> susScaleAnswerPapers = susScaleAnswerPaperMapper.selectByExample(susScaleAnswerPaperExample);
           //如果没有，加上此份答卷
            if(susScaleAnswerPapers.isEmpty()){
                susScaleAnswerPaper = new SusScaleAnswerPaper();
                susScaleAnswerPaper.setExpertId(expert.getId());
                susScaleAnswerPaper.setPlanId(assessAndPlan.getId());
                susScaleAnswerPaper.setTaskId(expertTask.getId());
                susScaleAnswerPaperMapper.insert(susScaleAnswerPaper);
            }
            else//如果有 第一项就是
            {
                susScaleAnswerPaper = susScaleAnswerPapers.get(0);
            }



            //看看有没有这道题的
            SusScaleQuestionScoreExample susScaleQuestionScoreExample = new SusScaleQuestionScoreExample();
            SusScaleQuestionScoreExample.Criteria criteria1 = susScaleQuestionScoreExample.createCriteria();
            criteria1.andSusPaperIdEqualTo(susScaleAnswerPaper.getId()).andQuestionNumberEqualTo((long) questionId);
            List<SusScaleQuestionScore> susScaleQuestionScores = susScaleQuestionScoreMapper.selectByExample(susScaleQuestionScoreExample);

            //如果有 - 替换为新答案
            if(!susScaleQuestionScores.isEmpty())
            {
                SusScaleQuestionScore susScaleQuestionScore = susScaleQuestionScores.get(0);
                susScaleQuestionScore.setScore((long) score);
                susScaleQuestionScoreMapper.updateByPrimaryKey(susScaleQuestionScore);

            }
                //如果没有 - 增加这道题的答案
            else {
                SusScaleQuestionScore susScaleQuestionScore = new SusScaleQuestionScore();
                susScaleQuestionScore.setScore((long)score);
                susScaleQuestionScore.setQuestionNumber((long) questionId);
                susScaleQuestionScore.setSusPaperId(susScaleAnswerPaper.getId());
                susScaleQuestionScoreMapper.insert(susScaleQuestionScore);
            }

            //返回当前的答案列表；按照任务 - 用户 - 分数？






        }








    }



}
