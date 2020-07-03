package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.utils.UploadUtils;
import hci.dky.dao.AssessAndPlanMapper;
import hci.dky.dao.ExpertMapper;
import hci.dky.dao.ExpertTaskMapper;
import hci.dky.pojo.*;
import hci.dky.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

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

    @Autowired
    private ExpertTaskMapper expertTaskMapper;

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
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<ArrayList> postExpertTask(MultipartFile file,String taskName,String taskDes,int planId) {
        AssessAndPlan thisPlan = assessAndPlanMapper.selectByPrimaryKey((long) planId);
        ExpertTask expertTask = new ExpertTask();
        expertTask.setPlanId(thisPlan.getId());
        expertTask.setTaskName(taskName);
        expertTask.setTaskDes(taskDes);


        try {
            if (file.isEmpty()) {
                return ServerResponse.createByErrorMessage("文件为空！");
            }
            String fileName = file.getOriginalFilename();
            //String fileName = "TaskContent"+planId+String.format("%04d",new Random(System. currentTimeMillis()).nextInt(9999)); //文件名：tc+planid+4位随机数
            String suffixName = fileName.substring(Objects.requireNonNull(file.getOriginalFilename()).lastIndexOf("."));
            fileName = "TC"+planId+String.format("%04d",new Random(System. currentTimeMillis()).nextInt(9999))+suffixName; //文件名：tc+planid+4位随机数
            System.out.println("上传的文件名为" + fileName + "后缀名为" + suffixName);


//            //设置存储路径
//            String filePath = "/Users/jiaxin/Documents/研一/项目/评估/temp代码/dky/media/";
//            String path = filePath + fileName;

            //File dest = new File(path);
            File dest = UploadUtils.getFileDirFile();
            System.out.println(dest.getAbsolutePath());
            //检测是否存在目录
//            if (!dest.getParentFile().exists()) {
//                dest.getParentFile().mkdirs();//新建文件夹
//
//            }
            String path = dest.getAbsolutePath()+File.separator+ fileName;
            File newFile = new File(path);
            System.out.println(newFile.getAbsolutePath());

            file.transferTo(newFile);//文件写入

            expertTask.setFilepath(path);
            expertTaskMapper.insert(expertTask);

            //获取该方案所有任务
            ExpertTaskExample expertTaskExample = new ExpertTaskExample();
            ExpertTaskExample.Criteria criteria = expertTaskExample.createCriteria();
            criteria.andPlanIdEqualTo(thisPlan.getId());
            List<ExpertTask> expertTasks = expertTaskMapper.selectByExample(expertTaskExample);
            ArrayList<ExpertTask> expertTaskArrayList = new ArrayList<>(expertTasks);

            return ServerResponse.createBySuccess("成功存储", expertTaskArrayList);


        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ServerResponse.createByErrorMessage("文件上传失败！");
    }





}
