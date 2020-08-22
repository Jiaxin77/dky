package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.utils.UserLoginToken;
import hci.dky.service.AssessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AssessController
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/5/18 9:46 上午
 * @Version 1.0
 **/

@RestController
public class AssessController {
    @Autowired
    private AssessService assessService;

    @GetMapping("/getIndexesAndMethods")
    public ServerResponse<ArrayList> getIndexesAndMethods(){
        /*
         * @Author jiaxin
         * @Description 获取指标和方法信息（无任何勾选结果，只是对应信息）
         * @Date 10:47 上午 2020/6/24
         * @Param 无 （需要token）
         * @return 指标信息和方法信息和对应信息
         **/

        ServerResponse<ArrayList> response = assessService.getIndexesAndMethods();
        return response;
    }


    @PostMapping("/postIndexesAndMethods")
    public ServerResponse<Long> postIndexesAndMethods(@RequestBody Map<String,Object> assessIndex)
    {
        /**
         * @Author jiaxin
         * @Description 提交指标及方法勾选结果//TODO 
         * @Date 10:48 上午 2020/6/24
         * @Param  评估id（编辑态为评估ID，新建态为-1）+ 勾选结果
         * @return 评估id
         **/
         
        Integer assessId = (Integer) assessIndex.get("assessId");
        List<Object> indexData = (List<Object>) assessIndex.get("indexData");
        ServerResponse<Long> response = assessService.postIndexes(assessId,indexData);
        return response;
    }

    @GetMapping("/getAssessPlan")
    public ServerResponse<ArrayList> getAssessPlan(int assessId)
    {
        /**
         * @Author jiaxin
         * @Description 获取该评估左侧方案列表
         * @Date 10:49 上午 2020/6/24
         * @Param 评估id
         * @return 方案列表
         **/
         
        ServerResponse<ArrayList> response = assessService.getAssessPlan(assessId);
        return response;
    }

    @PostMapping("/postAssessInfo")
    public ServerResponse<Boolean> postAssessInfo(@RequestBody Map<String,Object> assessInfo)
    {
        /**
         * @Author jiaxin
         * @Description 提交评估基本信息
         * @Date 10:50 上午 2020/6/24
         * @Param 评估id；评估名称；评估描述；评估对象
         * @return 无
         **/
         
        Integer assessId = (Integer) assessInfo.get("assessId");
        String assessName = (String) assessInfo.get("assessName");
        String assessDes = (String) assessInfo.get("assessDes");
        String assessObject = (String) assessInfo.get("assessObject");
        ServerResponse<Boolean> response = assessService.postAssessInfo(assessId,assessName,assessDes,assessObject);
        return  response;
    }

    @PostMapping("/postSusSystemName")
    public ServerResponse<Boolean> postSusSystemName(@RequestBody Map<String,Object> susInfo)
    {
        /**
         * @Author jiaxin
         * @Description 提交Sus系统名称
         * @Date 10:51 上午 2020/6/24
         * @Param 方案id；sus系统名称
         * @return hci.dky.common.ServerResponse<java.lang.Boolean>
         **/
         
        Integer planId = (Integer) susInfo.get("planId");
        String systemName = (String) susInfo.get("systemName");
        ServerResponse<Boolean> response = assessService.postSusSystemName(planId,systemName);
        return response;

    }

    @PostMapping("/postBorgSystemName")
    public ServerResponse<Boolean> postBorgSystemName(@RequestBody Map<String,Object> borgInfo)
    {
        /**
         * @Author jiaxin
         * @Description 提交borg系统名称
         * @Date 11:01 上午 2020/6/24
         * @Param 方案id；borg系统名称
         * @return hci.dky.common.ServerResponse<java.lang.Boolean>
         **/

        Integer planId = (Integer) borgInfo.get("planId");
        String systemName = (String) borgInfo.get("systemName");
        ServerResponse<Boolean> response = assessService.postBorgSystemName(planId,systemName);
        return response;

    }

    @GetMapping("/getPlanAndMethodInfo")
    public ServerResponse<ArrayList> getPlanAndMethodInfo(int assessId)
    {
        /**
         * @Author jiaxin
         * @Description 获取方案总览那个表格内容
         * @Date 11:01 上午 2020/6/24
         * @Param [assessId]
         * @return hci.dky.common.ServerResponse<java.util.ArrayList>
         **/

        ServerResponse<ArrayList> response = assessService.getPlanAndMethodInfo(assessId);
        return response;
    }

    @GetMapping("/getSusSystemName")
    public ServerResponse<String> getSusSystemName(int planId)
    {
        /*
         * @Author jiaxin
         * @Description 获取sus系统名称
         * @Date 11:03 上午 2020/6/24
         * @Param 方案id
         * @return 系统名称
         **/


        ServerResponse<String> response = assessService.getSusSystemName(planId);
        return response;
    }

    @GetMapping("/getBorgSystemName")
    public ServerResponse<String> getBorgSystemName(int planId)
    {
        /**
         * @Author jiaxin
         * @Description  获取borg系统名称
         * @Date 11:03 上午 2020/6/24
         * @Param 方案id
         * @return 系统名称
         **/

        ServerResponse<String> response = assessService.getBorgSystemName(planId);
        return response;
    }

    @UserLoginToken
    @GetMapping("/getAssessList")
    public ServerResponse<ArrayList> getAssessList()
    {
        /**
         * @Author jiaxin
         * @Description 获取评估列表
         * @Date 11:04 上午 2020/6/24
         * @Param 无
         * @return 评估列表
         **/

        ServerResponse<ArrayList> response = assessService.getAssessList();
        return response;
    }

    @GetMapping("/getPlanInfo")
    public ServerResponse<HashMap<String,Object>> getPlanInfo(int planId)
    {
        /**
         * @Author jiaxin
         * @Description 获取方案信息
         * @Date 11:04 上午 2020/6/24
         * @Param [planId]
         * @return 方案信息（专家列表、任务清单、以及方案所需显示的东西）
         **/

        ServerResponse<HashMap<String,Object>> response = assessService.getPlanInfo(planId);
        return  response;
    }


    @PostMapping("/beginAssess")
    public ServerResponse<Boolean> beginAssess(@RequestBody Map<String,Object> assess)
    {
        /**
         * @Author jiaxin
         * @Description 评估状态更新为进行中//TODO
         * @Date 5:26 下午 2020/8/22
         * @Param [assessId]
         * @return hci.dky.common.ServerResponse<java.lang.Boolean>
         **/

         int assessId = (int)assess.get("assessId");

         ServerResponse<Boolean> response = assessService.beginAssess(assessId);
         return response;
    }

    @PostMapping("/finishAssess")
    public ServerResponse<Boolean> finishAssess(@RequestBody Map<String,Object> assess)
    {
        /**
         * @Author jiaxin
         * @Description 评估状态更新为已完成//TODO
         * @Date 5:35 下午 2020/8/22
         * @Param [assessId]
         * @return hci.dky.common.ServerResponse<java.lang.Boolean>
         **/
        int assessId = (int)assess.get("assessId");
        ServerResponse<Boolean> response = assessService.finishAssess(assessId);
        return response;



    }








}
