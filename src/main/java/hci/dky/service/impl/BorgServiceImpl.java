package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.AssessAndPlanMapper;
import hci.dky.dao.BorgScaleAnswerPaperMapper;
import hci.dky.dao.ExpertMapper;
import hci.dky.dao.ExpertTaskMapper;
import hci.dky.pojo.*;
import hci.dky.service.BorgService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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


            }
            else
            {
                borgScaleAnswerPaper = borgScaleAnswerPapers.get(0);
            }

            borgScaleAnswerPaper.setScore((long) score);


        }
        //获取所有答案
        BorgScaleAnswerPaperExample borgScaleAnswerPaperExample1 = new BorgScaleAnswerPaperExample();
        BorgScaleAnswerPaperExample.Criteria criteria1 = borgScaleAnswerPaperExample1.createCriteria();
        criteria1.andPlanIdEqualTo(assessAndPlan.getId());
        List<BorgScaleAnswerPaper> borgScaleAnswerPaperList = borgScaleAnswerPaperMapper.selectByExample(borgScaleAnswerPaperExample1);

        return ServerResponse.createBySuccess("提交答案成功",borgScaleAnswerPaperList);

    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)//增加事务回滚
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


}
