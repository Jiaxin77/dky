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
        expert.setPlanId(assessAndPlan.getId());
        expertMapper.insert(expert);


        ExpertExample expertExample = new ExpertExample();
        ExpertExample.Criteria expertCriteria = expertExample.createCriteria();
        expertCriteria.andPlanIdEqualTo((long)planId);
        List<Expert> experts = expertMapper.selectByExample(expertExample);

        ArrayList<Object> expertList = new ArrayList<Object>(experts);
        return ServerResponse.createBySuccess("专家增加成功",expertList);


    }





}
