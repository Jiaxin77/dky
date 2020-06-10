package hci.dky.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import hci.dky.common.ServerResponse;
import hci.dky.dao.*;
import hci.dky.pojo.*;
import hci.dky.service.AssessService;
import net.sf.jsqlparser.statement.create.table.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName AssessServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/6/8 4:13 下午
 * @Version 1.0
 **/

@Service
public class AssessServiceImpl implements AssessService {

    @Autowired
    private IndexLibraryMapper indexLibraryMapper;
    @Autowired
    private IndexAndMethodMapper indexAndMethodMapper;
    @Autowired
    private MethodLibraryMapper methodLibraryMapper;

    @Autowired
    private AssessLibraryMapper assessLibraryMapper;
    @Autowired
    private AssessAndPlanMapper assessAndPlanMapper;

    @Autowired
    private BorgScaleMapper borgScaleMapper;
    @Autowired
    private ExpertPlanMapper expertPlanMapper;
    @Autowired
    private SusScaleMapper susScaleMapper;
    @Autowired
    private RecordTableMapper recordTableMapper;





    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> getIndexesAndMethods()
    {/**
     * @Author jiaxin
     * @Description 获取指标及对应方法//TODO
     * @Date 9:44 上午 2020/6/9
     * @Param []
     * @return hci.dky.common.ServerResponse<java.util.ArrayList>
     **/


        ArrayList<String> categoryList = new ArrayList<String>(Arrays.asList("软件人机交互","硬件人机交互","整体评价"));
        ArrayList<Object> allIndexList = new ArrayList<Object>();

        for (String category:categoryList) {

            IndexLibraryExample indexLibraryExample = new IndexLibraryExample();
            IndexLibraryExample.Criteria indexCriteria = indexLibraryExample.createCriteria();
            indexCriteria.andCategoryEqualTo(category);
            List<IndexLibrary> indexs = indexLibraryMapper.selectByExample(indexLibraryExample);

            HashMap<String, Object> categoryData = new HashMap<String, Object>();
            categoryData.put("category",category); //该大类名称
            ArrayList<Object> indexList = new ArrayList<Object>();
            if(!indexs.isEmpty()) //存在该类别的指标
            {
                for(IndexLibrary index:indexs)
                {
                    HashMap<String, Object> indexData = new HashMap<String, Object>();
                    indexData.put("index",index);

                    ArrayList<Object> methodList = new ArrayList<Object>();


                    //查询该指标对应方法
                    IndexAndMethodExample indexAndMethodExample = new IndexAndMethodExample();
                    IndexAndMethodExample.Criteria indexAndMethodCriteria = indexAndMethodExample.createCriteria();
                    indexAndMethodCriteria.andIndexIdEqualTo(index.getId());
                    List<IndexAndMethod> indexAndMethods = indexAndMethodMapper.selectByExample(indexAndMethodExample);

                    if(!indexAndMethods.isEmpty()) //存在方法
                    {
                        for(IndexAndMethod indexAndMethod:indexAndMethods)
                        {
                            HashMap<String, Object> methodData = new HashMap<String, Object>();
                            methodData.put("id",indexAndMethod.getId());


                            //方法信息
                            MethodLibrary method = methodLibraryMapper.selectByPrimaryKey(indexAndMethod.getMethodId());
                            methodData.put("method",method);
                            methodData.put("isMust",indexAndMethod.getIsMust());
                            methodList.add(methodData);
                        }

                    }

                    indexData.put("method",methodList);

                    indexList.add(indexData);






                }
            }
            categoryData.put("indexs",indexList);
            allIndexList.add(categoryData);

        }
        return ServerResponse.createBySuccess("获取成功",allIndexList);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<Boolean> postIndexes(Long assessId,List<Object> indexAndMethod) {/**
     * @Author jiaxin
     * @Description 提交选择的指标，生成方案//TODO
     * @Date 9:44 上午 2020/6/9
     * @Param []
     * @return hci.dky.common.ServerResponse<java.lang.Boolean>
     **/


        AssessLibrary thisAssess;

        if (assessId == -1) //新的评估
        {
            thisAssess = new AssessLibrary();
            thisAssess.setIsExist(Boolean.TRUE);
            assessLibraryMapper.insert(thisAssess);
            assessId = thisAssess.getAssessId();
        }
        else
        {
            thisAssess = assessLibraryMapper.selectByPrimaryKey(assessId);
        }


        ArrayList<Long> indexIdList = new ArrayList<Long>();


        for (Object chosedData : indexAndMethod) {
            Map entry = (Map) chosedData;
            Long indexId = (Long) entry.get("indexId");
            List<Long> methodIds = (List<Long>) entry.get("methodId");

            indexIdList.add(indexId);

            IndexLibrary thisIndex = indexLibraryMapper.selectByPrimaryKey(indexId);
            for (Long methodId : methodIds) {

                MethodLibrary thisMethod = methodLibraryMapper.selectByPrimaryKey(methodId);


                //先看评估有没有此类方法
                AssessAndPlanExample assessAndPlanExample = new AssessAndPlanExample();
                AssessAndPlanExample.Criteria assessAndPlanCriteria = assessAndPlanExample.createCriteria();
                assessAndPlanCriteria.andAssessIdEqualTo(assessId).andPlanTypeEqualTo(thisMethod.getMethodName());
                List<AssessAndPlan> assessAndPlanList = assessAndPlanMapper.selectByExample(assessAndPlanExample);

                if (!assessAndPlanList.isEmpty()) //不为空，即有此类方法
                {
                    //如果plan的评估对象等于该指标的category
                    //  获取plan的评估指标ID 强行转换为list<Long>
                    //  此指标id是否在该list中
                    // 是 不做任何处理
                    // 否 将该指标id add 到list<long>中 update存储
                    //continue？【继续循环下一个？】
                    //如果不等于category【else】
                    //增加一个方案 评估对象为category 评估指标为list add上此指标id
                    //增加相应的表单中内容（底下有类似代码）

                } else  // 为空，即没有此类方法
                {
                    AssessAndPlan assessAndPlan = new AssessAndPlan();
                    assessAndPlan.setAssessId(assessId);
                    assessAndPlan.setPlanType(thisMethod.getMethodName());

                    //增加评估对象为category 评估指标为list add上此指标id

                    assessAndPlanMapper.insert(assessAndPlan);
                }

                //如何存下对应的方案ID？ —— 或者新增方案时再增？ 新增方案再增吧～
            }

        }


        thisAssess.setIndexList((String.valueOf(indexIdList)));
        assessLibraryMapper.updateByPrimaryKey(thisAssess);

        return ServerResponse.createBySuccess("指标提交成功",Boolean.TRUE);


    }




    //提交方案名称+评估描述+评估对象
    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<Boolean> postAssessInfo(Long assessId,String assessName,String assessDes,String assessObject)
    {
        AssessLibrary thisAssess = assessLibraryMapper.selectByPrimaryKey(assessId);
        thisAssess.setAssessName(assessName);
        thisAssess.setAssessDes(assessDes);
        thisAssess.setAssessObject(assessObject);
        assessLibraryMapper.updateByPrimaryKey(thisAssess);

        return ServerResponse.createBySuccess("评估信息提交成功",Boolean.TRUE);
    }


    //获取左侧列表

    //挨个编辑方案？ —— sus有系统名称，borg和专家走查是不是直接用plan就行？


    //提交SUS系统名称
    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<Boolean> postSusSystemName(Long planId,String systemName)
    {
        SusScaleExample susScaleExample = new SusScaleExample();
        SusScaleExample.Criteria criteria = susScaleExample.createCriteria();
        criteria.andAssessIdEqualTo(planId);
        List<SusScale> susScales = susScaleMapper.selectByExample(susScaleExample);

        if(susScales.isEmpty()) // 没有该方案的量表，即为新的
        {
            SusScale susScale = new SusScale();
            susScale.setAssessId(planId);
            susScale.setSystemName(systemName);
            susScaleMapper.insert(susScale);
        }
        else
        {
            SusScale susScale = susScales.get(0);
            susScale.setSystemName(systemName);
            susScaleMapper.updateByPrimaryKey(susScale);
        }
        return ServerResponse.createBySuccess("Sus评估系统名称提交成功",Boolean.TRUE);
    }


    //获取SUS系统名称


















}


