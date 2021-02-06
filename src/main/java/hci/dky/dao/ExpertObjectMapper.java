package hci.dky.dao;

import hci.dky.pojo.ExpertObject;
import hci.dky.pojo.ExpertObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertObjectMapper {
    long countByExample(ExpertObjectExample example);

    int deleteByExample(ExpertObjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExpertObject record);

    int insertSelective(ExpertObject record);

    List<ExpertObject> selectByExample(ExpertObjectExample example);

    ExpertObject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpertObject record, @Param("example") ExpertObjectExample example);

    int updateByExample(@Param("record") ExpertObject record, @Param("example") ExpertObjectExample example);

    int updateByPrimaryKeySelective(ExpertObject record);

    int updateByPrimaryKey(ExpertObject record);
}