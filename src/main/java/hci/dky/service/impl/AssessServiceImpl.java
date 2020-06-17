package hci.dky.service.impl;


import hci.dky.common.ServerResponse;
import hci.dky.dao.*;
import hci.dky.pojo.*;
import hci.dky.service.AssessService;
import io.swagger.models.auth.In;
import net.sf.jsqlparser.statement.create.table.Index;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
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
    public ServerResponse<Long> postIndexes(Integer assessId,List<Object> indexAndMethod) {/**
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
            thisAssess.setAssessState("编辑中");
         //   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
          //  System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            thisAssess.setBeginTime(new Date());
            thisAssess.setIsModel(Boolean.FALSE);

            assessLibraryMapper.insert(thisAssess);


        }
        else
        {
            thisAssess = assessLibraryMapper.selectByPrimaryKey((long)assessId);
            thisAssess.setBeginTime(new Date());
        }

    //    System.out.println(thisAssess);
    //    System.out.println(thisAssess.getAssessId());
        //assessId = thisAssess.getAssessId().intValue();


        ArrayList<Long> indexIdList = new ArrayList<Long>();


        for (Object chosedData : indexAndMethod) {
            Map entry = (Map) chosedData;
            Integer indexId = (Integer) entry.get("indexId");
                 //   (Long) entry.get("indexId");
            List<Integer> methodIds = (List<Integer>) entry.get("methodId");

            indexIdList.add((long)indexId);
           // System.out.println("indexId"+indexId);

            IndexLibrary thisIndex = indexLibraryMapper.selectByPrimaryKey((long)indexId);
            for (Integer methodId : methodIds) {

                MethodLibrary thisMethod = methodLibraryMapper.selectByPrimaryKey((long)methodId);
            //    System.out.println("methodId"+methodId);


                //先看评估有没有此类方法
                AssessAndPlanExample assessAndPlanExample = new AssessAndPlanExample();
                AssessAndPlanExample.Criteria assessAndPlanCriteria = assessAndPlanExample.createCriteria();
                assessAndPlanCriteria.andAssessIdEqualTo(thisAssess.getAssessId());
                assessAndPlanCriteria.andPlanTypeEqualTo(thisMethod.getMethodName());
                List<AssessAndPlan> assessAndPlans = assessAndPlanMapper.selectByExample(assessAndPlanExample);


                Boolean categoryFlag = Boolean.FALSE;
                if (!assessAndPlans.isEmpty()) //不为空，即有此类方法
                {
                    categoryFlag = Boolean.FALSE;
                    for(AssessAndPlan assessAndPlan:assessAndPlans) //该评估中此类方法的列表
                    {
                        if(assessAndPlan.getAssessObject().equals(thisIndex.getCategory())) // 该评估中此类方法且类别相同的
                        {
                            categoryFlag = Boolean.TRUE; // 存在该评估中此类方法且类别相同的

                     //       System.out.println(Arrays.toString(assessAndPlan.getIndexList().split(",")));

                            List<String> planIndexList = new ArrayList<>(Arrays.asList(assessAndPlan.getIndexList().split(",")));
                      //      System.out.println("planIndexList"+planIndexList);
                            if(!planIndexList.contains(Long.toString(thisIndex.getId())))//  此指标id不在该list中
                            {

                                planIndexList.add(Long.toString(thisIndex.getId()));
                                String planIndexList_str =  StringUtils.join(planIndexList, ',');
                      //          System.out.println(planIndexList_str);
                                assessAndPlan.setIndexList(planIndexList_str);
                                assessAndPlanMapper.updateByPrimaryKey(assessAndPlan);
                            }

                        }
                    }

                    if(categoryFlag == Boolean.FALSE) //有此评估方法，但没有此类
                    {
                        AssessAndPlan assessAndPlan = new AssessAndPlan();
                        assessAndPlan.setAssessId(thisAssess.getAssessId());
                        assessAndPlan.setPlanType(thisMethod.getMethodName());
                        assessAndPlan.setAssessObject(thisIndex.getCategory());

                        ArrayList<String> planIndexList = new ArrayList<String>();
                        planIndexList.add(Long.toString(thisIndex.getId()));
                   //     System.out.println(planIndexList);
                        String planIndexList_str =  StringUtils.join(planIndexList, ',');
                  //      System.out.println(planIndexList_str);
                        assessAndPlan.setIndexList(planIndexList_str);
                        assessAndPlanMapper.insert(assessAndPlan);

                    }

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
                    assessAndPlan.setAssessId(thisAssess.getAssessId());
                    assessAndPlan.setPlanType(thisMethod.getMethodName());
                    assessAndPlan.setAssessObject(thisIndex.getCategory());

                    ArrayList<String> planIndexList = new ArrayList<String>();
                    planIndexList.add(Long.toString(thisIndex.getId()));
              //      System.out.println("planIndexList"+planIndexList);
                    String planIndexList_str =  StringUtils.join(planIndexList, ',');
              //      System.out.println("planIndexList_str"+planIndexList_str);
//                    String planIndexList_str = Long.toString(thisIndex.getId())+",";
//                    System.out.println("planIndexList_str"+planIndexList_str);
                    assessAndPlan.setIndexList(planIndexList_str);

                    //增加评估对象为category 评估指标为list add上此指标id

                    assessAndPlanMapper.insert(assessAndPlan);
                }

                //如何存下对应的方案ID？ —— 或者新增方案时再增？ 新增方案再增吧～
            }

        }


        thisAssess.setIndexList((String.valueOf(indexIdList)));
        thisAssess.setBeginTime(new Date());
        assessLibraryMapper.updateByPrimaryKey(thisAssess);

        return ServerResponse.createBySuccess("指标提交成功",thisAssess.getAssessId());


    }

    //获取左侧方案列表
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> getAssessPlan(int assessId)
    {
        /**
         * @Author jiaxin
         * @Description 获取左侧方案列表//TODO
         * @Date 11:58 上午 2020/6/11
         * @Param [assessId]评估ID
         * @return hci.dky.common.ServerResponse<java.util.ArrayList>
         **/

        AssessAndPlanExample assessAndPlanExample = new AssessAndPlanExample();
        AssessAndPlanExample.Criteria criteria= assessAndPlanExample.createCriteria();
        criteria.andAssessIdEqualTo((long) assessId);
        List<AssessAndPlan> assessAndPlanList = assessAndPlanMapper.selectByExample(assessAndPlanExample);
        ArrayList planList = new ArrayList(assessAndPlanList);
        return ServerResponse.createBySuccess("方案获取成功",planList);

    }




    //提交方案名称+评估描述+评估对象
    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<Boolean> postAssessInfo(int assessId, String assessName, String assessDes, String assessObject)
    {
        AssessLibrary thisAssess = assessLibraryMapper.selectByPrimaryKey((long)assessId);
        thisAssess.setAssessName(assessName);
        thisAssess.setAssessDes(assessDes);
        thisAssess.setAssessObject(assessObject);

        TimeZone time = TimeZone.getTimeZone("ETC/GMT+8");

        TimeZone.setDefault(time);

        thisAssess.setBeginTime(new Date());
        assessLibraryMapper.updateByPrimaryKey(thisAssess);

        return ServerResponse.createBySuccess("评估信息提交成功",Boolean.TRUE);
    }


    //获取左侧列表

    //挨个编辑方案？ —— sus有系统名称，borg和专家走查是不是直接用plan就行？


    //提交SUS系统名称
    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<Boolean> postSusSystemName(int planId,String systemName)
    {
        AssessAndPlan assessAndPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);

        SusScaleExample susScaleExample = new SusScaleExample();
        SusScaleExample.Criteria criteria = susScaleExample.createCriteria();
        criteria.andPlanIdEqualTo((long) planId);
        List<SusScale> susScales = susScaleMapper.selectByExample(susScaleExample);

        if(susScales.isEmpty()) // 没有该方案的量表，即为新的
        {
            SusScale susScale = new SusScale();
            susScale.setPlanId(assessAndPlan.getId());
            susScale.setSystemName(systemName);
            susScaleMapper.insert(susScale);
        }
        else
        {
            SusScale susScale = susScales.get(0);
            susScale.setSystemName(systemName);
            susScaleMapper.updateByPrimaryKey(susScale);
        }

        //更新该评估时间
        AssessAndPlan assessAndPlan1 = assessAndPlanMapper.selectByPrimaryKey((long)planId);
        AssessLibrary assessLibrary = assessLibraryMapper.selectByPrimaryKey(assessAndPlan1.getAssessId());
        assessLibrary.setBeginTime(new Date());
        assessLibraryMapper.updateByPrimaryKey(assessLibrary);

        return ServerResponse.createBySuccess("Sus评估系统名称提交成功",Boolean.TRUE);
    }




    //获取方案总览
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> getPlanAndMethodInfo(int assessId)
    {
        /**
         * @Author jiaxin
         * @Description 获取方案总览//TODO
         * @Date 10:15 上午 2020/6/15
         * @Param [assessId]
         * @return hci.dky.common.ServerResponse<java.util.ArrayList> 评估方法+评估对象+指标+数据表单+人员需求
         **/

        //找到此评估的方案列表
        AssessAndPlanExample assessAndPlanExample = new AssessAndPlanExample();
        AssessAndPlanExample.Criteria criteria = assessAndPlanExample.createCriteria();
        criteria.andAssessIdEqualTo((long)assessId);
        List<AssessAndPlan> assessAndPlanList = assessAndPlanMapper.selectByExample(assessAndPlanExample);

        ArrayList<Object> planList = new ArrayList<>();
        //遍历方案列表 存下指标+数据表单+人员需求
        for(AssessAndPlan assessAndPlan:assessAndPlanList)
        {
            HashMap<String,Object> onePlan = new HashMap<>();
            onePlan.put("method",assessAndPlan.getPlanType());//评估方法
            onePlan.put("object",assessAndPlan.getAssessObject());//评估对象

            //方法相关
            MethodLibraryExample methodLibraryExample = new MethodLibraryExample();
            MethodLibraryExample.Criteria criteria1 = methodLibraryExample.createCriteria();
            criteria1.andMethodNameEqualTo(assessAndPlan.getPlanType());
            MethodLibrary methodLibrary = methodLibraryMapper.selectByExample(methodLibraryExample).get(0);

            onePlan.put("dataform",methodLibrary.getDataForm());//数据表单
            onePlan.put("people",methodLibrary.getNeedPeople());//人员需求

            //指标
            ArrayList<String> indexNameList = new ArrayList<>();
            String[] indexIdList = assessAndPlan.getIndexList().split(",");
            for(String indexId:indexIdList)
            {
                IndexLibrary thisIndex = indexLibraryMapper.selectByPrimaryKey(Long.parseLong(indexId));
                indexNameList.add(thisIndex.getFirstIndex());
            }

            onePlan.put("index",indexNameList);

            planList.add(onePlan);
        }

        return ServerResponse.createBySuccess("方案总览获取成功",planList);


    }


    //获取SUS系统名称
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<String> getSusSystemName(int planId)
    {
        SusScaleExample susScaleExample = new SusScaleExample();
        SusScaleExample.Criteria criteria = susScaleExample.createCriteria();
        criteria.andPlanIdEqualTo((long)planId);
        SusScale susScale = susScaleMapper.selectByExample(susScaleExample).get(0);

        return ServerResponse.createBySuccess("sus方案名称",susScale.getSystemName());


    }

    //获取评估列表
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> getAssessList()
    {
        AssessLibraryExample assessLibraryExample = new AssessLibraryExample();
        AssessLibraryExample.Criteria criteria = assessLibraryExample.createCriteria();
        criteria.andIsExistEqualTo(Boolean.TRUE);
        List<AssessLibrary> assessLibraryList = assessLibraryMapper.selectByExample(assessLibraryExample);
        ArrayList<Object> assessList = new ArrayList<>(assessLibraryList);
        return ServerResponse.createBySuccess("评估列表获取成功",assessList);

    }



















}


