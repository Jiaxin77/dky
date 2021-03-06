package hci.dky.dao;

import hci.dky.pojo.AssessAndPlan;
import hci.dky.pojo.AssessAndPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssessAndPlanMapper {
    long countByExample(AssessAndPlanExample example);

    int deleteByExample(AssessAndPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AssessAndPlan record);

    int insertSelective(AssessAndPlan record);

    List<AssessAndPlan> selectByExample(AssessAndPlanExample example);

    AssessAndPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AssessAndPlan record, @Param("example") AssessAndPlanExample example);

    int updateByExample(@Param("record") AssessAndPlan record, @Param("example") AssessAndPlanExample example);

    int updateByPrimaryKeySelective(AssessAndPlan record);

    int updateByPrimaryKey(AssessAndPlan record);
}