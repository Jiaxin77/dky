package hci.dky.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import hci.dky.common.ServerResponse;
import hci.dky.dao.AssessAndPlanMapper;
import hci.dky.dao.AssessLibraryMapper;
import hci.dky.dao.SurveyLibraryMapper;
import hci.dky.pojo.*;
import hci.dky.service.AssessService;
import hci.dky.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName ModelServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2021/2/6 10:14 上午
 * @Version 1.0
 **/
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private AssessLibraryMapper assessLibraryMapper;

    @Autowired
    private AssessAndPlanMapper assessAndPlanMapper;

    @Autowired
    private SurveyLibraryMapper surveyLibraryMapper;
    /*
     * @Author jiaxin
     * @Description 获取模板列表
     * @Date 10:16 上午 2021/2/6
     * @Param []
     * @return java.util.ArrayList<java.lang.Object>
     **/
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)//增加事务回滚
    public ServerResponse<List<AssessLibrary>> getModelList() {
        AssessLibraryExample assessLibraryExample = new AssessLibraryExample();
        AssessLibraryExample.Criteria criteria = assessLibraryExample.createCriteria();
        criteria.andIsModelEqualTo(true);
        criteria.andIsExistEqualTo(true);
        List<AssessLibrary> assessLibraryList = assessLibraryMapper.selectByExample(assessLibraryExample);

        return ServerResponse.createBySuccess("获取成功",assessLibraryList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse deleteModel(Integer modelId) {
        AssessLibrary thisAssess = assessLibraryMapper.selectByPrimaryKey((long)modelId);
        thisAssess.setIsExist(false);
        assessLibraryMapper.updateByPrimaryKey(thisAssess);
        return ServerResponse.createBySuccess();
    }




    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse setAssessToModel(Integer assessId) {
        /**
         * @Author jiaxin
         * @Description 把某个评估设为模板
         * @Date 10:33 上午 2021/2/6
         * @Param [assessId]
         * @return java.lang.Boolean
         **/

        //拿到该评估的基本信息
        AssessLibrary thisAssess = assessLibraryMapper.selectByPrimaryKey((long)assessId);

        //新建一个为模板的评估
        AssessLibrary newAssess = new AssessLibrary();
        newAssess.setIsModel(true);
        newAssess.setIsExist(true);
        newAssess.setBeginTime(new Date());
        newAssess.setIndexList(thisAssess.getIndexList());
        newAssess.setIndexMethodList(thisAssess.getIndexMethodList());
        newAssess.setAssessObject(thisAssess.getAssessObject());
        newAssess.setAssessName(thisAssess.getAssessName());
        newAssess.setAssessDes(thisAssess.getAssessDes());
        assessLibraryMapper.insert(newAssess);

        copyPlans(thisAssess,newAssess);


        return ServerResponse.createBySuccess();
    }




    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<AssessLibrary> createAssessFromModel(Integer modelId) {
        /**
         * @Author jiaxin
         * @Description 从模板新建评估
         * @Date 10:33 上午 2021/2/6
         * @Param [assessId]
         * @return java.lang.Boolean
         **/

        //拿到该模板的基本信息
        AssessLibrary thisAssess = assessLibraryMapper.selectByPrimaryKey((long)modelId);

        //新建一个评估
        AssessLibrary newAssess = new AssessLibrary();
        newAssess.setIsModel(false);
        newAssess.setIsExist(true);
        newAssess.setAssessState("编辑中");
        newAssess.setBeginTime(new Date());
        newAssess.setIndexList(thisAssess.getIndexList());
        newAssess.setIndexMethodList(thisAssess.getIndexMethodList());
        newAssess.setAssessObject(thisAssess.getAssessObject());
        newAssess.setAssessName(thisAssess.getAssessName());
        newAssess.setAssessDes(thisAssess.getAssessDes());
        assessLibraryMapper.insert(newAssess);
        copyPlans(thisAssess,newAssess);


        return ServerResponse.createBySuccess("新建成功",newAssess);
    }

    public void copyPlans(AssessLibrary oldAssess, AssessLibrary newAssess) {
        //复制方案
        //拿到原有方案
        AssessAndPlanExample assessAndPlanExample = new AssessAndPlanExample();
        AssessAndPlanExample.Criteria criteria = assessAndPlanExample.createCriteria();
        criteria.andAssessIdEqualTo(oldAssess.getAssessId());
        List<AssessAndPlan> assessAndPlanList = assessAndPlanMapper.selectByExample(assessAndPlanExample);
        for (AssessAndPlan assessAndPlan : assessAndPlanList) {
            AssessAndPlan newAssessAndPlan = new AssessAndPlan();
            newAssessAndPlan.setIndexList(assessAndPlan.getIndexList());
            newAssessAndPlan.setPlanType(assessAndPlan.getPlanType());
            newAssessAndPlan.setAssessObject(assessAndPlan.getAssessObject());
            newAssessAndPlan.setTableId(assessAndPlan.getTableId());
            // 如果是问卷
            if("自定义问卷".equals(assessAndPlan.getPlanType())) {
                // 看下问卷库里有没有
                SurveyLibraryExample surveyLibraryExample = new SurveyLibraryExample();
                SurveyLibraryExample.Criteria criteria1 = surveyLibraryExample.createCriteria();
                criteria1.andPlanIdEqualTo(assessAndPlan.getId());
                criteria1.andIsexistEqualTo(true);
                List<SurveyLibrary> surveyLibraryList = surveyLibraryMapper.selectByExample(surveyLibraryExample);
                if(!surveyLibraryList.isEmpty()) { //有此问卷
                    newAssessAndPlan.setTableId(surveyLibraryList.get(0).getId());
                }
            }
            //新方案绑到新评估上
            newAssessAndPlan.setAssessId(newAssess.getAssessId());
            assessAndPlanMapper.insert(newAssessAndPlan);

        }
    }


}
