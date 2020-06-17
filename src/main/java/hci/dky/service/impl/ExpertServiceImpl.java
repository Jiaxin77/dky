package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.AssessAndPlanMapper;
import hci.dky.dao.ExpertMapper;
import hci.dky.pojo.AssessAndPlan;
import hci.dky.pojo.Expert;
import hci.dky.pojo.ExpertExample;
import hci.dky.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExpertServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/6/8 4:13 下午
 * @Version 1.0
 **/
@Service
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    private ExpertMapper expertMapper ;

    @Autowired
    private AssessAndPlanMapper assessAndPlanMapper;

    //还不能用～

    //录入专家清单
    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<Boolean> postExpertList(int planId,List<Object> expertList)
    {

        /**
         * @Author jiaxin
         * @Description 录入专家清单//TODO
         * @Date 9:48 上午 2020/6/10
         * @Param [expertListId, expertList]专家清单id，专家信息
         * @return hci.dky.common.ServerResponse<java.lang.Boolean>
         **/
        AssessAndPlan thisPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);

        //先删除已有的 —— 编辑用
        ExpertExample expertExample = new ExpertExample();
        ExpertExample.Criteria expertCriteria = expertExample.createCriteria();
        expertCriteria.andPlanIdEqualTo((long)planId);
        expertMapper.deleteByExample(expertExample);

        for (Object expertInfo:expertList)
        {
            Map entry = (Map) expertInfo;
            String name = (String) entry.get("name");
            String background = (String) entry.get("background");
            String assessPart = (String) entry.get("assessPart");
            String remark = (String) entry.get("remark");

            Expert expert = new Expert();
            expert.setName(name);
            expert.setAssessObject(assessPart);
            expert.setBackground(background);
            expert.setRemarks(remark);

            expert.setPlanId(thisPlan.getId());

            expertMapper.insert(expert);
        }

        return ServerResponse.createBySuccess("专家清单提交成功",Boolean.TRUE);


    }

    //获取专家清单
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> getExpertList(int planId)
    {


        ExpertExample expertExample = new ExpertExample();
        ExpertExample.Criteria expertCriteria = expertExample.createCriteria();
        expertCriteria.andPlanIdEqualTo((long)planId);
        List<Expert> experts = expertMapper.selectByExample(expertExample);

        ArrayList<Object> expertList = new ArrayList<Object>(experts);
        return ServerResponse.createBySuccess("专家清单获取成功",expertList);

    }

    //录入任务清单（上传文件怎么上传？任务一个一个添加？可删除？）
}
