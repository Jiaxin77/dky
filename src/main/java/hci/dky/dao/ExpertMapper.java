package hci.dky.dao;

import hci.dky.pojo.Expert;
import hci.dky.pojo.ExpertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertMapper {
    int countByExample(ExpertExample example);

    int deleteByExample(ExpertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Expert record);

    int insertSelective(Expert record);

    List<Expert> selectByExample(ExpertExample example);

    Expert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Expert record, @Param("example") ExpertExample example);

    int updateByExample(@Param("record") Expert record, @Param("example") ExpertExample example);

    int updateByPrimaryKeySelective(Expert record);

    int updateByPrimaryKey(Expert record);
}