package hci.dky.dao;

import hci.dky.pojo.ExpertTaskContent;
import hci.dky.pojo.ExpertTaskContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertTaskContentMapper {
    int countByExample(ExpertTaskContentExample example);

    int deleteByExample(ExpertTaskContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpertTaskContent record);

    int insertSelective(ExpertTaskContent record);

    List<ExpertTaskContent> selectByExample(ExpertTaskContentExample example);

    ExpertTaskContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpertTaskContent record, @Param("example") ExpertTaskContentExample example);

    int updateByExample(@Param("record") ExpertTaskContent record, @Param("example") ExpertTaskContentExample example);

    int updateByPrimaryKeySelective(ExpertTaskContent record);

    int updateByPrimaryKey(ExpertTaskContent record);
}