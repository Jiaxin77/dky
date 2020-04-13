package hci.dky.dao;

import hci.dky.pojo.FibModel;
import hci.dky.pojo.FibModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FibModelMapper {
    int countByExample(FibModelExample example);

    int deleteByExample(FibModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FibModel record);

    int insertSelective(FibModel record);

    List<FibModel> selectByExample(FibModelExample example);

    FibModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FibModel record, @Param("example") FibModelExample example);

    int updateByExample(@Param("record") FibModel record, @Param("example") FibModelExample example);

    int updateByPrimaryKeySelective(FibModel record);

    int updateByPrimaryKey(FibModel record);
}