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
    public ServerResponse<HashMap<String, Object>> getExpertWalkthroughAnswer1(int planId) {
        AssessAndPlan assessAndPlan=assessAndPlanMapper.selectByPrimaryKey((long)planId);
        HashMap<String, Object> res = new HashMap<>();
        ArrayList<Object>  allAnswers = new ArrayList<>();
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
        double totalConformance = 0;
        double totalConformanceDeviation = 0;
        double totalImportance = 0;
        double totalImportanceDeviation = 0;
        for(ExpertAnswerPaper paper : expertAnswerPaperList) {
            HashMap<String, Object> task = new HashMap<>();
            ArrayList<Object>  taskAnswers = new ArrayList<>();
            for (String object : Object) {
                ExpertObjectExample expertObjectExample = new ExpertObjectExample();
                ExpertObjectExample.Criteria criteria1 = expertObjectExample.createCriteria();
                criteria1.andObjectEqualTo(object);
                List<ExpertObject> expertObjectList = expertObjectMapper.selectByExample(expertObjectExample);
                double conformance;
                double importance;
                int len = expertObjectList.size();
                double conformanceSum = 0.0;
                double importanceSum = 0.0;
                for (ExpertObject expertObject : expertObjectList) {
//                    for (ExpertAnswerPaper paper : expertAnswerPaperList) {
                        ExpertQuestionScoreExample expertQuestionScoreExample1 = new ExpertQuestionScoreExample();
                        ExpertQuestionScoreExample.Criteria criteria4 = expertQuestionScoreExample1.createCriteria();
                        criteria4.andPaperIdEqualTo(paper.getId());
                        List<ExpertQuestionScore> expertQuestionScoreList = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample1);
                        for (ExpertQuestionScore questionScore : expertQuestionScoreList) {
                            if (questionScore.getQuestionNumber() == (long) expertObject.getId()) {
                                conformanceSum += questionScore.getConformanceScore();
                                importanceSum += questionScore.getImportanceScore();
                            }
                        }
//                    }
                }
                conformance = conformanceSum / len;
                importance = importanceSum / len;
                double conformanceStandardDeviationSum = 0;
                double importanceStandardDeviationSum = 0;
                for (ExpertObject expertObject : expertObjectList) {
//                    for (ExpertAnswerPaper paper : expertAnswerPaperList) {
                        ExpertQuestionScoreExample expertQuestionScoreExample1 = new ExpertQuestionScoreExample();
                        ExpertQuestionScoreExample.Criteria criteria4 = expertQuestionScoreExample1.createCriteria();
                        criteria4.andPaperIdEqualTo(paper.getId());
                        List<ExpertQuestionScore> expertQuestionScoreList = expertQuestionScoreMapper.selectByExample(expertQuestionScoreExample1);
                        for (ExpertQuestionScore questionScore : expertQuestionScoreList) {
                            if (questionScore.getQuestionNumber() == (long) expertObject.getId()) {
                                conformanceStandardDeviationSum += (questionScore.getConformanceScore() - conformance) * (questionScore.getConformanceScore() - conformance);
                                importanceStandardDeviationSum += (questionScore.getImportanceScore() - importance) * (questionScore.getImportanceScore() - importance);
                            }
                        }
//                    }
                }

                HashMap<String, Object> answerPaper = new HashMap<>();
//                HashMap<String, Object> answerPaper = new HashMap<>();
                answerPaper.put("name", object);
                answerPaper.put("ConformanceScore", conformance);
                answerPaper.put("ImportanceScore", importance);
                taskAnswers.add(answerPaper);

                double conformanceStandardDeviation = Math.sqrt(conformanceStandardDeviationSum / len);
                double importanceStandardDeviation = Math.sqrt(importanceStandardDeviationSum / len);
                answerPaper.put("comformanceStandardDeviation", conformanceStandardDeviation);
                answerPaper.put("importanceStandardDeviation", importanceStandardDeviation);
//                answerPaper.put("planId",paper.getPlanId());
//                answerPaper.put("taskId",paper.getTaskId());
//                answerPaper.put("expertId",paper.getExpertId());
                totalConformance += conformance;
                totalImportance += importance;
                totalConformanceDeviation += conformanceStandardDeviation;
                totalImportanceDeviation += importanceStandardDeviation;
            }
            allAnswers.add(task);
            task.put("answers",taskAnswers);
            task.put("planId", paper.getPlanId());
            task.put("taskId", paper.getTaskId());
            task.put("expertId", paper.getExpertId());
        }
        totalConformance = totalConformance/Object.length;
        totalImportance = totalImportance/Object.length;
        totalConformanceDeviation = totalConformanceDeviation / Object.length;
        totalImportanceDeviation = totalImportanceDeviation / Object.length;

        String conclution1 = " ";
        String conclusion2 = " ";
        if (totalConformance >= 1 && totalConformance < 2.5){
            conclution1 ="总体符合程度为"+ totalConformance +"说明软件界面中违反设计规则的情况较多。会影响用户的的使用体验。建议参照设计规则进行修改";
        }
        else if(totalConformance >=2.5 && totalConformance < 3.5){
            conclution1 = "总体符合程度为"+ totalConformance + "，分值中等。说明软件界面中对设计规则的应用还有待提升。在时间和资源允许的情况下。建议酌情修改";
        }
        else if( totalConformance >= 3.5 && totalConformance < 5){
            conclution1 = "总体符合程度为"+ totalConformance+ "，分值偏高，说明软件界面较好地符合了设计规范。建议对某些符合度低重要度高的问题进行修改。";
        }
        if (totalImportance >= 1 && totalImportance < 2.5){
            conclusion2 = "不重要";
        }
        else if (totalImportance >= 2.5 && totalImportance < 3.5){
            conclusion2 = "一般，可改可不改";
        }
        else if(totalImportance >= 3.5 && totalImportance < 5){
            conclusion2 = "很重要";
        }
        res.put("conculsion",conclution1 + conclusion2);
        res.put("comformance",totalConformance);
        res.put("conformanceStandardDeviation", totalConformanceDeviation);
        res.put("importance", totalImportance);
        res.put("importanceStandardDeviation", totalImportanceDeviation);
        res.put("allAnswers", allAnswers);
        return ServerResponse.createBySuccess("获取成功",res);
    }
}
