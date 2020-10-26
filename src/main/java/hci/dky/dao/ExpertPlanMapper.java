package hci.dky.dao;

import hci.dky.pojo.ExpertPlan;
import hci.dky.pojo.ExpertPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertPlanMapper {
    int countByExample(ExpertPlanExample example);

    int deleteByExample(ExpertPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpertPlan record);

    int insertSelective(ExpertPlan record);

    List<ExpertPlan> selectByExample(ExpertPlanExample example);

    ExpertPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpertPlan record, @Param("example") ExpertPlanExample example);

    int updateByExample(@Param("record") ExpertPlan record, @Param("example") ExpertPlanExample example);

    int updateByPrimaryKeySelective(ExpertPlan record);

    int updateByPrimaryKey(ExpertPlan record);
}