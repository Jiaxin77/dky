package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.*;
import hci.dky.pojo.*;
import hci.dky.service.ExpertWalkthroughService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dky
 * @description: 专家走查
 * @author: Leaf
 * @create: 2020-08-27 15:19
 * @Version: 1.0
 **/
@Service
public class ExpertWalkthroughServiceImpl implements ExpertWalkthroughService {
    @Autowired
    private ExpertMapper expertMapper;

    @Autowired
    private ExpertAnswerPaperMapper expertAnswerPaperMapper;

    @Autowired
    private ExpertQuestionScoreMapper expertQuestionScoreMapper;

    @Autowired
    private AssessAndPlanMapper assessAndPlanMapper;

    @Autowired
    private  ExpertObjectMapper expertObjectMapper;

    @Autowired
    private ExpertTaskMapper expertTaskMapper;

    @Autowired
    private IndexLibraryMapper indexLibraryMapper;





    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public ServerResponse<List> postExpertWalkthroughAnswer(int planId, List<Object> answer) {

        AssessAndPlan assessAndPlan=assessAndPlanMapper.selectByPrimaryKey((long)planId);
        for (Object oneAnswer:answer) {
            Map answerInfo = (Map) oneAnswer;
            int taskId = (int) answerInfo.get("taskId");
            int expertId = (int) answerInfo.get("expertId");
            ExpertTask expertTask = expertTaskMapper.selectByPrimaryKey((long) taskId);
            Expert expert = expertMapper.selectByPrimaryKey((long) expertId);

            ExpertAnswerPaper expertAnswerPaper;
            //查看有没有此答卷
            ExpertAnswerPaperExample expertAnswerPaperExample = new ExpertAnswerPaperExample();
            ExpertAnswerPaperExample.Criteria criteria = expertAnswerPaperExample.createCriteria();
            criteria.andTaskIdEqualTo(expertTask.getId()).andExpertIdEqualTo(expert.getId()).andPlanIdEqualTo(assessAndPlan.getId());
            List<ExpertAnswerPaper> expertAnswerPapers = expertAnswerPaperMapper.selectByExample(expertAnswerPaperExample);
            //如果没有，加上此份答卷
            if (expertAnswerPapers.isEmpty()) {
                expertAnswerPaper = new ExpertAnswerPaper();
                expertAnswerPaper.setExpertId(expert.getId());
                expertAnswerPaper.setPlanId(assessAndPlan.getId());
                expertAnswerPaper.setTaskId(expertTask.getId());
                expertAnswerPaperMapper.insert(expertAnswerPaper);
            } else//如果有 第一项就是
            {
                expertAnswerPaper = expertAnswerPapers.get(0);
            }

            ArrayList<Object> questionAnswerList = (ArrayList<Object>) answerInfo.get("questionAnswer");
            for (Object questionAnswer : questionAnswerList) {
                Map questionInfo = (Map) questionAnswer;
                int questionId = (int) questionInfo.get("questionId");
//                int score = (int) questionInfo.get("score");
                int conformanceScore = (int) questionInfo.get("conformanceScore");
                int importanceScore = (int) questionInfo.get("importanceScore");
                String questionDes = (String) questionInfo.get("questionDes");

                ExpertQuestionScoreExample expertQuestionScoreExample = new ExpertQuestionScoreExample();
                ExpertQuestionScoreExample.Criteria criteria1 = expertQuestionScoreExample.createCriteria();
                criteria1.andPaperIdEqualTo(expertAnswerPaper.getId()).andQuestionNumberEqualTo((long) questionId);
                List<ExpertQuestionScore> expertQuestionScores = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample);

                if (!expertQuestionScores.isEmpty()) {
                    ExpertQuestionScore expertQuestionScore = expertQuestionScores.get(0);
                    expertQuestionScore.setConformanceScore((double)conformanceScore);
                    expertQuestionScore.setImportanceScore((double)importanceScore);
                    expertQuestionScore.setQuestionDes(questionDes);
//                    expertQuestionScore.setQuestionNumber((long)questionId);
                    expertQuestionScoreMapper.updateByPrimaryKey(expertQuestionScore);
                } else {
                    ExpertQuestionScore expertQuestionScore = new ExpertQuestionScore();
                    expertQuestionScore.setConformanceScore((double)conformanceScore);
                    expertQuestionScore.setImportanceScore((double)importanceScore);
                    expertQuestionScore.setQuestionNumber((long)questionId);
                    expertQuestionScore.setQuestionDes(questionDes);
                    expertQuestionScore.setPaperId(expertAnswerPaper.getId());
                    expertQuestionScoreMapper.insert(expertQuestionScore);

                }
            }
        }

        ArrayList<Object> allAnswers= new ArrayList<>();
        ExpertAnswerPaperExample expertAnswerPaperExample1=new ExpertAnswerPaperExample();
        ExpertAnswerPaperExample.Criteria criteria2=expertAnswerPaperExample1.createCriteria();
        criteria2.andPlanIdEqualTo(assessAndPlan.getId());
        List<ExpertAnswerPaper> expertAnswerPaperList=expertAnswerPaperMapper.selectByExample(expertAnswerPaperExample1);

        //System.out.println(expertAnswerPaperList.size());

        for(ExpertAnswerPaper paper:expertAnswerPaperList){
            HashMap<String,Object> AnswerPaper=new HashMap<>();
            AnswerPaper.put("planId",paper.getPlanId());
            AnswerPaper.put("taskId",paper.getTaskId());
            AnswerPaper.put("expertId",paper.getExpertId());

            ArrayList<Object> allScores = new ArrayList<>();
            ExpertQuestionScoreExample expertQuestionScoreExample1 = new ExpertQuestionScoreExample();
            ExpertQuestionScoreExample.Criteria criteria4 = expertQuestionScoreExample1.createCriteria();
            criteria4.andPaperIdEqualTo(paper.getId());
            List<ExpertQuestionScore> expertQuestionScoreList = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample1);

            //System.out.println(expertQuestionScoreList.size());

            for (ExpertQuestionScore expertQuestionScore:expertQuestionScoreList){
                HashMap<String,Object> thisScore= new HashMap();
                thisScore.put("paperId",expertQuestionScore.getPaperId());
                thisScore.put("questionNum",expertQuestionScore.getQuestionNumber());
                thisScore.put("getConformanceScore",expertQuestionScore.getConformanceScore());
                thisScore.put("getImportanceScore",expertQuestionScore.getImportanceScore());
                thisScore.put("getQuestionDes",expertQuestionScore.getQuestionDes());
                allScores.add(thisScore);
            }
            AnswerPaper.put("Score",allScores);
            allAnswers.add(AnswerPaper);

        }
        return ServerResponse.createBySuccess("填写成功",allAnswers);



    }

    @Override
    public ServerResponse<List> getExpertWalkthroughAnswer(int planId) {
        AssessAndPlan assessAndPlan=assessAndPlanMapper.selectByPrimaryKey((long)planId);

        ArrayList<Object> allAnswers = new ArrayList<>();
        ExpertAnswerPaperExample expertAnswerPaperExample1 = new ExpertAnswerPaperExample();
        ExpertAnswerPaperExample.Criteria criteria3 = expertAnswerPaperExample1.createCriteria();
        criteria3.andPlanIdEqualTo(assessAndPlan.getId());
        List<ExpertAnswerPaper> expertAnswerPaperList = expertAnswerPaperMapper.selectByExample(expertAnswerPaperExample1);


        for(ExpertAnswerPaper paper : expertAnswerPaperList)
        {
            HashMap<String,Object> AnswerPaper = new HashMap<>();
            AnswerPaper.put("planId",paper.getPlanId());
            AnswerPaper.put("taskId",paper.getTaskId());
            AnswerPaper.put("expertId",paper.getExpertId());

            ArrayList<Object> allScores = new ArrayList<>();
            //所有题目的答案
            ExpertQuestionScoreExample expertQuestionScoreExample1 = new ExpertQuestionScoreExample();
            ExpertQuestionScoreExample.Criteria criteria4 = expertQuestionScoreExample1.createCriteria();
            criteria4.andPaperIdEqualTo(paper.getId());
            List<ExpertQuestionScore> expertQuestionScoreList = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample1);
            for(ExpertQuestionScore questionScore:expertQuestionScoreList)
            {
                HashMap<String,Object> thisScore = new HashMap<>();
                thisScore.put("paperId",questionScore.getPaperId());
                thisScore.put("questionNum",questionScore.getQuestionNumber());
                thisScore.put("getConformanceScore",questionScore.getConformanceScore());
                thisScore.put("getImportanceScore",questionScore.getImportanceScore());
                thisScore.put("getQuestionDes",questionScore.getQuestionDes());
                allScores.add(thisScore);

            }
            AnswerPaper.put("scores",allScores);
            allAnswers.add(AnswerPaper);
        }

        return ServerResponse.createBySuccess("获取成功",allAnswers);

    }

    @Override
    public ServerResponse<List> getExpertWalkthroughAnswer1(int planId) {
        AssessAndPlan assessAndPlan=assessAndPlanMapper.selectByPrimaryKey((long)planId);

        ArrayList<Object> allAnswers = new ArrayList<>();
        ExpertAnswerPaperExample expertAnswerPaperExample = new ExpertAnswerPaperExample();
        ExpertAnswerPaperExample.Criteria criteria = expertAnswerPaperExample.createCriteria();
        criteria.andPlanIdEqualTo(assessAndPlan.getId());
        List<ExpertAnswerPaper> expertAnswerPaperList = expertAnswerPaperMapper.selectByExample(expertAnswerPaperExample);
        String Object[] ={"流程", "系统", "控件", "表单", "状态栏", "导航栏", "用语", "图形", "工具栏",
                "按钮", "输入框", "列表", "窗口", "色彩", "布局", "席位（软件）","平台（软件）",
                "控件（硬件）", "指示灯", "控制器", "视听信号", "设备", "标识", "作业空间", "开关",
                "系统", "流程", "席位（硬件）", "平台（硬件）", "席位之间的协调性", "人机分工合理性",
                "流程复杂程度", "任务操作便捷性", "系统响应及时性"
        };
        for (String object: Object) {
            ExpertObjectExample expertObjectExample = new ExpertObjectExample();
            ExpertObjectExample.Criteria criteria1 = expertObjectExample.createCriteria();
            criteria1.andObjectEqualTo(object);
            List<ExpertObject> expertObjectList = expertObjectMapper.selectByExample(expertObjectExample);
            Double aver1;
            Double aver2;
            Integer len = expertObjectList.size();
            Double sum1 = 0.0;
            Double sum2 = 0.0;
            for (ExpertObject expertObject: expertObjectList) {
                for(ExpertAnswerPaper paper : expertAnswerPaperList) {
                    ExpertQuestionScoreExample expertQuestionScoreExample1 = new ExpertQuestionScoreExample();
                    ExpertQuestionScoreExample.Criteria criteria4 = expertQuestionScoreExample1.createCriteria();
                    criteria4.andPaperIdEqualTo(paper.getId());
                    List<ExpertQuestionScore> expertQuestionScoreList = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample1);
                    for(ExpertQuestionScore questionScore:expertQuestionScoreList) {
                        if (questionScore.getQuestionNumber() == (long)expertObject.getId()) {
                            sum1 += questionScore.getConformanceScore();
                            sum2 += questionScore.getImportanceScore();
                        }
                    }
                }
            }
            aver1 = sum1/len;
            aver2 = sum2/len;
            HashMap<String,Object> AnswerPaper = new HashMap<>();
            AnswerPaper.put("name",object);
            AnswerPaper.put("ConformanceScore",aver1);
            AnswerPaper.put("ImportanceScore",aver2);
            allAnswers.add(AnswerPaper);

        }
        return ServerResponse.createBySuccess("获取成功",allAnswers);
    }
}
