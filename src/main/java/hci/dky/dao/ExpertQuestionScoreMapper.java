package hci.dky.dao;

import hci.dky.pojo.ExpertQuestionScore;
import hci.dky.pojo.ExpertQuestionScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertQuestionScoreMapper {
    long countByExample(ExpertQuestionScoreExample example);

    int deleteByExample(ExpertQuestionScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpertQuestionScore record);

    int insertSelective(ExpertQuestionScore record);

    List<ExpertQuestionScore> selectByExample(ExpertQuestionScoreExample example);

    ExpertQuestionScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpertQuestionScore record, @Param("example") ExpertQuestionScoreExample example);

    int updateByExample(@Param("record") ExpertQuestionScore record, @Param("example") ExpertQuestionScoreExample example);

    int updateByPrimaryKeySelective(ExpertQuestionScore record);

    int updateByPrimaryKey(ExpertQuestionScore record);
}