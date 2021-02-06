package hci.dky.dao;

import hci.dky.pojo.ExpertIndex;
import hci.dky.pojo.ExpertIndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertIndexMapper {
    long countByExample(ExpertIndexExample example);

    int deleteByExample(ExpertIndexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExpertIndex record);

    int insertSelective(ExpertIndex record);

    List<ExpertIndex> selectByExample(ExpertIndexExample example);

    ExpertIndex selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpertIndex record, @Param("example") ExpertIndexExample example);

    int updateByExample(@Param("record") ExpertIndex record, @Param("example") ExpertIndexExample example);

    int updateByPrimaryKeySelective(ExpertIndex record);

    int updateByPrimaryKey(ExpertIndex record);
}