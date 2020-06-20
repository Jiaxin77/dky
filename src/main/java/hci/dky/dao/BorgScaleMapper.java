package hci.dky.dao;

import hci.dky.pojo.BorgScale;
import hci.dky.pojo.BorgScaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorgScaleMapper {
    long countByExample(BorgScaleExample example);

    int deleteByExample(BorgScaleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BorgScale record);

    int insertSelective(BorgScale record);

    List<BorgScale> selectByExample(BorgScaleExample example);

    BorgScale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BorgScale record, @Param("example") BorgScaleExample example);

    int updateByExample(@Param("record") BorgScale record, @Param("example") BorgScaleExample example);

    int updateByPrimaryKeySelective(BorgScale record);

    int updateByPrimaryKey(BorgScale record);
}