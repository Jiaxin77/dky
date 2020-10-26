package hci.artedu.dao;

import hci.artedu.pojo.ExpertScore;
import hci.artedu.pojo.ExpertScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertScoreMapper {
    long countByExample(ExpertScoreExample example);

    int deleteByExample(ExpertScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpertScore record);

    int insertSelective(ExpertScore record);

    List<ExpertScore> selectByExample(ExpertScoreExample example);

    ExpertScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpertScore record, @Param("example") ExpertScoreExample example);

    int updateByExample(@Param("record") ExpertScore record, @Param("example") ExpertScoreExample example);

    int updateByPrimaryKeySelective(ExpertScore record);

    int updateByPrimaryKey(ExpertScore record);
}