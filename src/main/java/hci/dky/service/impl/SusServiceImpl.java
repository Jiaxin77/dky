package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.AssessAndPlanMapper;
import hci.dky.dao.SusScaleAnswerPaperMapper;
import hci.dky.dao.SusScaleMapper;
import hci.dky.dao.SusScaleQuestionScoreMapper;
import hci.dky.pojo.AssessAndPlan;
import hci.dky.pojo.SusScale;
import hci.dky.service.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


//    public ServerResponse<List> addSusTask(int planId,String taskName,String taskObject,String taskDes)
//    {
//        /**
//         * @Author jiaxin
//         * @Description 添加任务，添加到任务清单中
//         * @Date 10:54 上午 2020/7/3
//         * @Param [planId, taskName, taskObject, taskDes]
//         * @return 添加后的任务清单
//         **/
//
//    }
//
//
//
//    public ServerResponse<Boolean> fillSusData(int planId, List<Object> data)
//    {
//        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);
//
//
//
//    }


}
