package hci.dky.dao;

import hci.dky.pojo.ExpertTask;
import hci.dky.pojo.ExpertTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertTaskMapper {
    long countByExample(ExpertTaskExample example);

    int deleteByExample(ExpertTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpertTask record);

    int insertSelective(ExpertTask record);

    List<ExpertTask> selectByExample(ExpertTaskExample example);

    ExpertTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpertTask record, @Param("example") ExpertTaskExample example);

    int updateByExample(@Param("record") ExpertTask record, @Param("example") ExpertTaskExample example);

    int updateByPrimaryKeySelective(ExpertTask record);

    int updateByPrimaryKey(ExpertTask record);
}