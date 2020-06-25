package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.*;
import hci.dky.pojo.*;
import hci.dky.service.QuestionNaireService;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName QuestionNaireServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/4/15 9:43 上午
 * @Version 1.0
 **/


@Service
public class QuestionNaireServiceImpl implements QuestionNaireService {
    @Autowired
    private AnswerLibraryMapper answerLibraryMapper;
    @Autowired
    private AssessLibraryMapper assessLibraryMapper;
    @Autowired
    private AssessAndPlanMapper assessAndPlanMapper;
    @Autowired
    private ChoiceQuestionLibraryMapper choiceQuestionLibraryMapper;
    @Autowired
    private FibModelMapper fibModelMapper;
    @Autowired
    private PaperListMapper paperListMapper;
    @Autowired
    private QuestionLibraryMapper questionLibraryMapper;
    @Autowired
    private SurveyLibraryMapper surveyLibraryMapper;



    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> getFibModel()
    {
        /**
         * @Author jiaxin
         * @Description 获取填空模板题 //TODO
         * @Date 9:59 上午 2020/4/15
         * @Param []
         * @return hci.dky.common.ServerResponse<java.util.ArrayList>
         **/

        FibModelExample fibModelExample = new FibModelExample();
        fibModelExample.setDistinct(false);
        List<FibModel> fibModelList = fibModelMapper.selectByExample(fibModelExample);
        ArrayList<Object> modelList = new ArrayList<Object>();
        if (!fibModelList.isEmpty())
        {
            for(FibModel fb: fibModelList)
            {
                HashMap<String, Object> data = new HashMap<String, Object>();
                data.put("id",fb.getId());
                data.put("title",fb.getFibTitle());
                modelList.add(data);

                //可以直接用对象返回 不用一个一个put了 （已经给前端文档了，先不改了）

            }
            return ServerResponse.createBySuccess("获取成功",modelList);
        }
        else
        {
            return ServerResponse.createByErrorMessage("获取失败，填空题模板列表为空！");
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<Long> createQuestionNaire(int assessId ,int planId, String title, String des, List<Integer> modelid, List<Object> questionList)
    {
        /**
         * @Author jiaxin
         * @Description 新建问卷//TODO
         * @Date 7:07 下午 2020/6/11
         * @Param [assessId, title, des, modelid, questionList]
         * @return hci.dky.common.ServerResponse<java.lang.Long>
         **/

        SurveyLibrary surveyLibrary = new SurveyLibrary();
        surveyLibrary.setSurveyTitle(title);
        surveyLibrary.setSurveyDes(des);
        surveyLibrary.setNowPeopleNum((long) 0);
        surveyLibrary.setIsModel(false);
        surveyLibraryMapper.insert(surveyLibrary);
      //  System.out.println(surveyLibrary.getId());
        if(planId != -1) // 是基于评估基于方案的
        {
            //AssessLibrary thisAssess = assessLibraryMapper.selectByPrimaryKey((long) assessId);
            //surveyLibrary.setAssessId(thisAssess.getAssessId());
            AssessAndPlan thisPlan = assessAndPlanMapper.selectByPrimaryKey((long)planId);
            surveyLibrary.setPlanId(thisPlan.getId()); //绑定方案
            surveyLibrary.setAssessId(thisPlan.getAssessId()); //绑定评估
            surveyLibraryMapper.updateByPrimaryKey(surveyLibrary);


            //将此assess的planid加到问卷的外键关联
        }
        else // planId为-1 —— 不属于任何方案，只属于评估 / 不属于评估
        {
            if(assessId != -1) //属于评估
            {
                AssessLibrary thisAssess = assessLibraryMapper.selectByPrimaryKey((long) assessId);
                surveyLibrary.setAssessId(thisAssess.getAssessId()); //绑定评估

                //新增一个单独的方案
                AssessAndPlan assessAndPlan = new AssessAndPlan();
                assessAndPlan.setAssessObject("整体");
                assessAndPlan.setPlanType("自定义问卷");
                assessAndPlan.setIndexList(thisAssess.getIndexList());
                assessAndPlan.setAssessId(thisAssess.getAssessId());
                assessAndPlanMapper.insert(assessAndPlan);

                surveyLibrary.setPlanId(assessAndPlan.getId()); //绑定方案
                surveyLibraryMapper.updateByPrimaryKey(surveyLibrary);

            }
            //若不属于，则啥都不绑了

        }

        //遍历选择的基本信息模板题
        for (int id : modelid)
        {
           FibModel thisModelQuestion = fibModelMapper.selectByPrimaryKey((long) id);
           QuestionLibrary modelQuestion = new QuestionLibrary();
           modelQuestion.setIsMust(true);
           modelQuestion.setQuestionTitle(thisModelQuestion.getFibTitle());
           modelQuestion.setQuestionType("FIB");
           modelQuestion.setSurveyId(surveyLibrary.getId());
           questionLibraryMapper.insert(modelQuestion);
        }

        //遍历提交的问题
        for(Object question:questionList) {
            Map entry = (Map) question;
            String questionTitle = (String) entry.get("questionTitle");
            int isMust = (int) entry.get("isMust");
            String questionType = (String) entry.get("questionType");

            QuestionLibrary thisQuestion = new QuestionLibrary();
            thisQuestion.setQuestionType(questionType);


            if(isMust == 0) {
                thisQuestion.setIsMust(false);
            }
            else if (isMust == 1)
            {
                thisQuestion.setIsMust(true);
            }
            thisQuestion.setQuestionTitle(questionTitle);
            thisQuestion.setSurveyId(surveyLibrary.getId());

            questionLibraryMapper.insert(thisQuestion);

            //System.out.println(thisQuestion.getId());

            if (questionType.equals("SCP") || questionType.equals("MCP")) //为选择题 存储选项
            {
                List<Object> choices = (List<Object>) entry.get("choices");
                //System.out.println(entry.get("choices"));
              //  Object choices = entry.get("choices");
                ArrayList<Object> choiceList = (ArrayList<Object>) choices;
                for (Object choice : choices) {
                    Map choiceEntry = (Map) choice;
                    String choiceTitle = (String) choiceEntry.get("choiceTitle");
                    String choiceId = (String) choiceEntry.get("choiceId");

                    ChoiceQuestionLibrary choiceQuestion = new ChoiceQuestionLibrary();
                    choiceQuestion.setChoiceId(choiceId);
                    choiceQuestion.setChoiceTitle(choiceTitle);
                    choiceQuestion.setQuestionId(thisQuestion.getId());
                    choiceQuestionLibraryMapper.insert(choiceQuestion);
                }

            }
        }



        return ServerResponse.createBySuccess("添加问卷成功",surveyLibrary.getId());





    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public HashMap<String, Object> getQuestionNaire(Long id)
    {
        /**
         * @Author jiaxin
         * @Description 获取问卷内容//TODO
         * @Date 11:33 上午 2020/4/16
         * @Param [id]
         * @return hci.dky.common.ServerResponse<java.util.HashMap<java.lang.String,java.lang.Object>>
         **/

        HashMap<String,Object> resultMap = new HashMap<>();
        SurveyLibrary thisSurvey = surveyLibraryMapper.selectByPrimaryKey(id);
        resultMap.put("id",thisSurvey.getId());
        resultMap.put("title",thisSurvey.getSurveyTitle());
        resultMap.put("des",thisSurvey.getSurveyDes());
        resultMap.put("nowPeopleNum",thisSurvey.getNowPeopleNum());


        QuestionLibraryExample questionLibraryExample = new QuestionLibraryExample();
        QuestionLibraryExample.Criteria criteria = questionLibraryExample.createCriteria();
        criteria.andSurveyIdEqualTo(Long.valueOf(String.valueOf(id)));
        List<QuestionLibrary>  qList=questionLibraryMapper.selectByExample(questionLibraryExample);

        ArrayList<Object> questionList = new ArrayList<Object>();
        for(QuestionLibrary question : qList)
        {
            HashMap<String,Object> questionMap = new HashMap<>();
            questionMap.put("questionId",question.getId());
            questionMap.put("questionTitle",question.getQuestionTitle());
            questionMap.put("isMust",question.getIsMust());
            questionMap.put("type",question.getQuestionType());
            if(question.getQuestionType().equals("SCP") || question.getQuestionType().equals("MCP")) //为选择题
            {
                ArrayList<Object> choiceList = new ArrayList<Object>();

                ChoiceQuestionLibraryExample choiceQuestionLibraryExample = new ChoiceQuestionLibraryExample();
                ChoiceQuestionLibraryExample.Criteria choiceCriteria = choiceQuestionLibraryExample.createCriteria();
                choiceCriteria.andQuestionIdEqualTo(question.getId());
                List<ChoiceQuestionLibrary>  cList=choiceQuestionLibraryMapper.selectByExample(choiceQuestionLibraryExample);

                for(ChoiceQuestionLibrary choice : cList)
                {
                    HashMap<String,Object> choiceMap = new HashMap<>();
                    choiceMap.put("choiceId",choice.getChoiceId());
                    choiceMap.put("choiceTitle",choice.getChoiceTitle());
                    choiceList.add(choiceMap);
                }
                questionMap.put("choices",choiceList);

            }
            questionList.add(questionMap);
        }

        resultMap.put("questionList",questionList);

        return resultMap;



    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)//增加事务回滚
    public ServerResponse<Boolean> postSurveyPaper(int id,List<Object> questionList)
    {
        /**
         * @Author jiaxin
         * @Description 提交单份答卷//TODO
         * @Date 11:35 上午 2020/4/16
         * @Param [id, questionList]
         * @return hci.dky.common.ServerResponse<java.lang.Boolean>
         **/

        SurveyLibrary thisSurvey = surveyLibraryMapper.selectByPrimaryKey((long)id); //问卷id
        PaperList thisPaper = new PaperList();
        thisPaper.setSurveyId(thisSurvey.getId());

        PaperListExample paperListExample = new PaperListExample();
        PaperListExample.Criteria criteria = paperListExample.createCriteria();
        criteria.andSurveyIdEqualTo(thisSurvey.getId());
        List<PaperList>  pList=paperListMapper.selectByExample(paperListExample);

        int num = pList.size()+1;
        thisPaper.setUser("被试"+ Integer.toString(num));
        paperListMapper.insert(thisPaper);

        for(Object question:questionList)
        {
            AnswerLibrary answerLibrary = new AnswerLibrary();
            Map entry = (Map) question;

            Integer questionId = (Integer) entry.get("questionId");
            QuestionLibrary thisQuestion = questionLibraryMapper.selectByPrimaryKey((long)questionId);
            String answer = (String) entry.get("answer");
            answerLibrary.setQuestionId(thisQuestion.getId());
            answerLibrary.setAnswer(answer);
            answerLibrary.setPaperId(thisPaper.getId());
            answerLibraryMapper.insert(answerLibrary);
        }

        //System.out.println(thisSurvey.getNowPeopleNum()+1);

        thisSurvey.setNowPeopleNum(thisSurvey.getNowPeopleNum()+1);
       // System.out.println(thisSurvey.getNowPeopleNum()+1);
        surveyLibraryMapper.updateByPrimaryKey(thisSurvey); //更新数据

        return ServerResponse.createBySuccess("提交成功",true);



    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<HashMap<String, Object>> getSurveyResult(int id) {
        /**
         * @Author jiaxin
         * @Description 获取答卷//TODO
         * @Date 5:44 下午 2020/4/16
         * @Param [id]
         * @return hci.dky.common.ServerResponse<java.util.HashMap < java.lang.String, java.lang.Object>>
         **/

        //获取的内容
        //答卷总数量
        //每份答卷 【题目id、题目标题、选项+答案】
        //每道题题目标题+每道题的统计值（选择题：选择每个选项的人数；填空题【非模板题？】：每个结果列表&&词云分词结果）
        HashMap<String, Object> resultMap = new HashMap<>();

        SurveyLibrary thisSurvey = surveyLibraryMapper.selectByPrimaryKey((long) id);

        resultMap.put("surveyId", thisSurvey.getId());
        resultMap.put("surveyTitle", thisSurvey.getSurveyTitle());
        resultMap.put("surveyDes", thisSurvey.getSurveyDes());
        resultMap.put("userNum", thisSurvey.getNowPeopleNum());


        PaperListExample paperListExample = new PaperListExample();
        PaperListExample.Criteria criteria = paperListExample.createCriteria();
        criteria.andSurveyIdEqualTo(thisSurvey.getId());
        List<PaperList> pList = paperListMapper.selectByExample(paperListExample);

        ArrayList<Object> paperList = new ArrayList<Object>();


        for (PaperList paper : pList) {
            HashMap<String, Object> paperMap = new HashMap<>();
            paperMap.put("id", paper.getId());
            paperMap.put("userName", paper.getUser());

            ArrayList<Object> answerList = new ArrayList<Object>();


            AnswerLibraryExample answerLibraryExample = new AnswerLibraryExample();
            AnswerLibraryExample.Criteria answerCriteria = answerLibraryExample.createCriteria();
            answerCriteria.andPaperIdEqualTo(paper.getId());
            List<AnswerLibrary> aList = answerLibraryMapper.selectByExample(answerLibraryExample);

            for (AnswerLibrary answer : aList) {
                HashMap<String, Object> answerMap = new HashMap<>();
                QuestionLibrary thisQuestion = questionLibraryMapper.selectByPrimaryKey(answer.getQuestionId());
                answerMap.put("questionTitle", thisQuestion.getQuestionTitle());
                answerMap.put("questionType", thisQuestion.getQuestionType());
                answerMap.put("userAnswer", answer.getAnswer());
                if (thisQuestion.getQuestionType().equals("SCP"))//单选题
                {
                    String userAnswer = answer.getAnswer();

                    ChoiceQuestionLibraryExample choiceLibraryExample = new ChoiceQuestionLibraryExample();
                    ChoiceQuestionLibraryExample.Criteria choiceCriteria = choiceLibraryExample.createCriteria();
                    choiceCriteria.andQuestionIdEqualTo(thisQuestion.getId());
                    choiceCriteria.andChoiceIdEqualTo(userAnswer);
                    List<ChoiceQuestionLibrary> cList = choiceQuestionLibraryMapper.selectByExample(choiceLibraryExample);

                    ChoiceQuestionLibrary thisChoice = cList.get(0);
                    answerMap.put("answerContent", thisChoice.getChoiceTitle());

                }
                if (thisQuestion.getQuestionType().equals("MCP"))//多选题
                {
                    String[] userAnswers = answer.getAnswer().split(";");
                    ArrayList<Object> userAnswerList = new ArrayList<Object>();

                    for (String userAnswer : userAnswers) {
                        ChoiceQuestionLibraryExample choiceLibraryExample = new ChoiceQuestionLibraryExample();
                        ChoiceQuestionLibraryExample.Criteria choiceCriteria = choiceLibraryExample.createCriteria();
                        choiceCriteria.andQuestionIdEqualTo(thisQuestion.getId());
                        choiceCriteria.andChoiceIdEqualTo(userAnswer);
                        List<ChoiceQuestionLibrary> cList = choiceQuestionLibraryMapper.selectByExample(choiceLibraryExample);

                        ChoiceQuestionLibrary thisChoice = cList.get(0);
                        userAnswerList.add(thisChoice.getChoiceTitle());

                    }
                    answerMap.put("answerContent", userAnswerList);

                }
                answerList.add(answerMap);

            }
            paperMap.put("answerList", answerList);
            paperList.add(paperMap);

        }

        resultMap.put("allPaperList", paperList);

        //各题统计结果

        ArrayList<Object> questionResultList = new ArrayList<Object>();

        QuestionLibraryExample questionLibraryExample = new QuestionLibraryExample();
        QuestionLibraryExample.Criteria questionCriteria = questionLibraryExample.createCriteria();
        questionCriteria.andSurveyIdEqualTo(thisSurvey.getId());
        List<QuestionLibrary> qList = questionLibraryMapper.selectByExample(questionLibraryExample);

        for (QuestionLibrary question : qList) {
            HashMap<String, Object> questionMap = new HashMap<>();
            questionMap.put("questionId", question.getId());
            questionMap.put("questionTitle", question.getQuestionTitle());
            questionMap.put("questionType", question.getQuestionType());
            questionMap.put("isMust", question.getIsMust());

            AnswerLibraryExample answerLibraryExample0 = new AnswerLibraryExample();
            AnswerLibraryExample.Criteria answerCriteria0 = answerLibraryExample0.createCriteria();
            answerCriteria0.andQuestionIdEqualTo(question.getId());
            List<AnswerLibrary> aList0 = answerLibraryMapper.selectByExample(answerLibraryExample0);
            Integer peopleCount = aList0.size();
            questionMap.put("peopleCount",peopleCount);//填此题的人数



            if (question.getQuestionType().equals("FIB")) {
                //若不为模板题
                //词云分析、词频统计
                FibModelExample fibModelExample = new FibModelExample();
                FibModelExample.Criteria fibCriteria = fibModelExample.createCriteria();
                fibCriteria.andFibTitleEqualTo(question.getQuestionTitle());
                List<FibModel> fibModelList = fibModelMapper.selectByExample(fibModelExample);
                List<String> fibAnswerList = new ArrayList<>();


                if(fibModelList.size() == 0) //不为模板题
                {
                    AnswerLibraryExample answerLibraryExample = new AnswerLibraryExample();
                    AnswerLibraryExample.Criteria answerCriteria = answerLibraryExample.createCriteria();
                    answerCriteria.andQuestionIdEqualTo(question.getId());
                    List<AnswerLibrary> aList = answerLibraryMapper.selectByExample(answerLibraryExample);


                    for(AnswerLibrary answer:aList)
                    {
                        fibAnswerList.add(answer.getAnswer());
                    }
                    List<Object> resultList = countFrequency(fibAnswerList);
                    questionMap.put("answerList",fibAnswerList);
                    questionMap.put("frequency",resultList);


                }


            }
            if (question.getQuestionType().equals("SCP")) {
                List<Object> choiceList = new ArrayList<>();



                ChoiceQuestionLibraryExample choiceLibraryExample = new ChoiceQuestionLibraryExample();
                ChoiceQuestionLibraryExample.Criteria choiceCriteria = choiceLibraryExample.createCriteria();
                choiceCriteria.andQuestionIdEqualTo(question.getId());
                List<ChoiceQuestionLibrary> cList = choiceQuestionLibraryMapper.selectByExample(choiceLibraryExample);
                for (ChoiceQuestionLibrary choice:cList)
                {
                    HashMap<String, Object> choiceMap = new HashMap<>();
                    choiceMap.put("choiceTitle",choice.getChoiceTitle());
                    choiceMap.put("choiceId",choice.getChoiceId());

                    //答案计数
                    AnswerLibraryExample answerLibraryExample = new AnswerLibraryExample();
                    AnswerLibraryExample.Criteria answerCriteria = answerLibraryExample.createCriteria();
                    answerCriteria.andQuestionIdEqualTo(question.getId());
                    answerCriteria.andAnswerEqualTo(choice.getChoiceId());
                    List<AnswerLibrary> aList = answerLibraryMapper.selectByExample(answerLibraryExample);
                    choiceMap.put("count",aList.size());
                    choiceList.add(choiceMap);

                }



                //获取所有的choice
                questionMap.put("choiceCount",choiceList);


                //统计各选项选择的总数，组成队列
            }
            if (question.getQuestionType().equals("MCP")) {
                List<Object> choiceList = new ArrayList<>();

                ChoiceQuestionLibraryExample choiceLibraryExample = new ChoiceQuestionLibraryExample();
                ChoiceQuestionLibraryExample.Criteria choiceCriteria = choiceLibraryExample.createCriteria();
                choiceCriteria.andQuestionIdEqualTo(question.getId());
                List<ChoiceQuestionLibrary> cList = choiceQuestionLibraryMapper.selectByExample(choiceLibraryExample);
                for (ChoiceQuestionLibrary choice:cList)
                {
                    HashMap<String, Object> choiceMap = new HashMap<>();
                    choiceMap.put("choiceTitle",choice.getChoiceTitle());
                    choiceMap.put("choiceId",choice.getChoiceId());

                    //答案计数
                    AnswerLibraryExample answerLibraryExample = new AnswerLibraryExample();
                    AnswerLibraryExample.Criteria answerCriteria = answerLibraryExample.createCriteria();
                    answerCriteria.andQuestionIdEqualTo(question.getId());
                 //   answerCriteria.andAnswer
                    answerCriteria.andAnswerLike("%"+choice.getChoiceId()+"%");
                    List<AnswerLibrary> aList = answerLibraryMapper.selectByExample(answerLibraryExample);
                    choiceMap.put("count",aList.size());
                    choiceList.add(choiceMap);

                }


                //获取所有的choice
                questionMap.put("choiceCount",choiceList);


                //用xx在字符串中是否存在统计

                //统计各选项选择的总数，组成队列
            }
            questionResultList.add(questionMap);


        }
        resultMap.put("allQuestionCount",questionResultList);
        return ServerResponse.createBySuccess("获取成功",resultMap);
    }

    public List<Object> countFrequency(List<String> wordList)
    {
        String wordString = listToString(wordList);
        ArrayList<String> spliceResult = spliceString(wordString);
        Map<String,Integer> countResult = countWords(spliceResult);
        List<Object> resultList = createWordCloudData(countResult);

        return resultList;
    }

    private String listToString(List<String> wordlist)
    {
        return String.join(",",wordlist);

    }

    private ArrayList<String> spliceString(String str)
    {
        List<org.apdplat.word.segmentation.Word> list = WordSegmenter.seg(str);
       // System.out.println(list);
        return wordToList(list);
    }

    private ArrayList<String> wordToList(List<Word> words)
    {
        ArrayList<String> wordList = new ArrayList<String>();
        for(Word word:words)
        {
            wordList.add(word.getText());
        }
    //    System.out.println(wordList);
        return wordList;
    }

    private Map<String,Integer> countWords(ArrayList<String> words)
    {
        Map<String,Integer> countMap = new HashMap<>();
        for (String word:words)
        {
            Integer count = countMap.get(word);
            if(count==null)
            {
                count = 1;
                countMap.put(word,count);
            }
            else
            {
                count = count+1;
                countMap.put(word,count);
            }


        }
    //    System.out.println(countMap);
        return countMap;
    }

    private List<Object> createWordCloudData(Map<String,Integer> map)
    {
        List<Object> resultList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("name",entry.getKey());
            resultMap.put("value",(int)entry.getValue());
            resultList.add(resultMap);

        }
        return resultList;

    }







}











