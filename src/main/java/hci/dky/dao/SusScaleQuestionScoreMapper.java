package hci.dky.dao;

import hci.dky.pojo.SusScaleQuestionScore;
import hci.dky.pojo.SusScaleQuestionScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SusScaleQuestionScoreMapper {
    int countByExample(SusScaleQuestionScoreExample example);

    int deleteByExample(SusScaleQuestionScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SusScaleQuestionScore record);

    int insertSelective(SusScaleQuestionScore record);

    List<SusScaleQuestionScore> selectByExample(SusScaleQuestionScoreExample example);

    SusScaleQuestionScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SusScaleQuestionScore record, @Param("example") SusScaleQuestionScoreExample example);

    int updateByExample(@Param("record") SusScaleQuestionScore record, @Param("example") SusScaleQuestionScoreExample example);

    int updateByPrimaryKeySelective(SusScaleQuestionScore record);

    int updateByPrimaryKey(SusScaleQuestionScore record);
}