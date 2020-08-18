package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.AssessAndPlanMapper;
import hci.dky.dao.BorgScaleAnswerPaperMapper;
import hci.dky.dao.ExpertMapper;
import hci.dky.dao.ExpertTaskMapper;
import hci.dky.pojo.*;
import hci.dky.service.BorgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BorgServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/7/22 4:28 下午
 * @Version 1.0
 **/

@Service
public class BorgServiceImpl implements BorgService {

    @Autowired
    private AssessAndPlanMapper assessAndPlanMapper;


    @Autowired
    private ExpertTaskMapper expertTaskMapper;
    @Autowired
    private ExpertMapper expertMapper;


    @Autowired
    private BorgScaleAnswerPaperMapper borgScaleAnswerPaperMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<List> postBorgAnswer(int planId, List<Object> answer)
    {
        /**
         * @Author jiaxin
         * @Description 录入borg数据//TODO
         * @Date 4:43 下午 2020/7/22
         * @Param [planId, answer] 方案id； 答案列表（任务id、专家id、）
         * @return hci.dky.common.ServerResponse<java.util.List>
         **/

        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);
        for(Object oneAnswer : answer) {
            Map answerInfo = (Map) oneAnswer;
            int taskId = (int)answerInfo.get("taskId");
            int expertId = (int)answerInfo.get("expertId");
            int score = (int)answerInfo.get("score");


            Expert expert = expertMapper.selectByPrimaryKey((long) expertId);
            ExpertTask task = expertTaskMapper.selectByPrimaryKey((long) taskId);

            //先看有没有这个的答案
            BorgScaleAnswerPaperExample borgScaleAnswerPaperExample = new BorgScaleAnswerPaperExample();
            BorgScaleAnswerPaperExample.Criteria criteria = borgScaleAnswerPaperExample.createCriteria();
            criteria.andPlanIdEqualTo(assessAndPlan.getId()).andTaskIdEqualTo(task.getId()).andExpertIdEqualTo(expert.getId());
            List<BorgScaleAnswerPaper> borgScaleAnswerPapers = borgScaleAnswerPaperMapper.selectByExample(borgScaleAnswerPaperExample);

            BorgScaleAnswerPaper borgScaleAnswerPaper;

            if(borgScaleAnswerPapers.isEmpty()) // 不存在已有答案
            {
                borgScaleAnswerPaper = new BorgScaleAnswerPaper();
                borgScaleAnswerPaper.setExpertId(expert.getId());
                borgScaleAnswerPaper.setPlanId(assessAndPlan.getId());
                borgScaleAnswerPaper.setTaskId(task.getId());

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowTime = df.format(System.currentTimeMillis());
                borgScaleAnswerPaper.setDate(nowTime);
                borgScaleAnswerPaperMapper.insert(borgScaleAnswerPaper);


            }
            else
            {
                borgScaleAnswerPaper = borgScaleAnswerPapers.get(0);
            }

            borgScaleAnswerPaper.setScore((long) score);
            borgScaleAnswerPaperMapper.updateByPrimaryKey(borgScaleAnswerPaper);


        }
        //获取所有答案
        BorgScaleAnswerPaperExample borgScaleAnswerPaperExample1 = new BorgScaleAnswerPaperExample();
        BorgScaleAnswerPaperExample.Criteria criteria1 = borgScaleAnswerPaperExample1.createCriteria();
        criteria1.andPlanIdEqualTo(assessAndPlan.getId());
        List<BorgScaleAnswerPaper> borgScaleAnswerPaperList = borgScaleAnswerPaperMapper.selectByExample(borgScaleAnswerPaperExample1);

        return ServerResponse.createBySuccess("提交答案成功",borgScaleAnswerPaperList);

    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<List> getBorgAnswer(int planId)
    {
        /**
         * @Author jiaxin
         * @Description 获取borg的答案//TODO
         * @Date 4:19 下午 2020/7/23
         * @Param [planId]
         * @return hci.dky.common.ServerResponse<java.util.List>
         **/

        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);

        BorgScaleAnswerPaperExample borgScaleAnswerPaperExample1 = new BorgScaleAnswerPaperExample();
        BorgScaleAnswerPaperExample.Criteria criteria1 = borgScaleAnswerPaperExample1.createCriteria();
        criteria1.andPlanIdEqualTo(assessAndPlan.getId());
        List<BorgScaleAnswerPaper> borgScaleAnswerPaperList = borgScaleAnswerPaperMapper.selectByExample(borgScaleAnswerPaperExample1);

        return ServerResponse.createBySuccess("获取答案成功",borgScaleAnswerPaperList);


    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<HashMap<String,Object>> getBorgResults(int planId)
    {
        /*
         * @Author jiaxin
         * @Description 返回每个任务的平均分和用户打分//TODO
         * @Date 10:54 上午 2020/8/10
         * @Param [planId]
         * @return hci.dky.common.ServerResponse<java.util.Map<java.lang.String,java.lang.Object>>
         **/

        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long) planId);
        HashMap<String,Object> planResult = new HashMap<>();
        planResult.put("planInfo",assessAndPlan);

        // 此方案下的所有任务
        ArrayList<Object> taskScores = new ArrayList<>();

        ExpertTaskExample expertTaskExample = new ExpertTaskExample();
        ExpertTaskExample.Criteria criteria = expertTaskExample.createCriteria();
        criteria.andPlanIdEqualTo(assessAndPlan.getId());
        List<ExpertTask> expertTaskList = expertTaskMapper.selectByExample(expertTaskExample);


        for (ExpertTask expertTask : expertTaskList)
        {
            //每个任务的平均分；各用户打分
            HashMap<String,Object> taskScore = new HashMap<>();
            taskScore.put("taskInfo",expertTask);

            BorgScaleAnswerPaperExample borgScaleAnswerPaperExample = new BorgScaleAnswerPaperExample();
            BorgScaleAnswerPaperExample.Criteria criteria1 = borgScaleAnswerPaperExample.createCriteria();
            criteria1.andPlanIdEqualTo(assessAndPlan.getId()).andTaskIdEqualTo(expertTask.getId());
            ArrayList<BorgScaleAnswerPaper> userScores = new ArrayList<>(borgScaleAnswerPaperMapper.selectByExample(borgScaleAnswerPaperExample));

            taskScore.put("userScores",userScores);

            //平均分
            int sum = 0;
            for(BorgScaleAnswerPaper oneUserPaper:userScores)
            {
               sum +=  oneUserPaper.getScore();
            }
            double avgScore = (double) sum /(userScores.size());

            taskScore.put("avgScore",avgScore);

            taskScores.add(taskScore);

        }

        planResult.put("taskScores",taskScores);

        return ServerResponse.createBySuccess("获取分析结果成功",planResult);




    }



}
