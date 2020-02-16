package hci.dky.dao;

import hci.dky.pojo.Hardware;
import hci.dky.pojo.HardwareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HardwareMapper {
    int countByExample(HardwareExample example);

    int deleteByExample(HardwareExample example);

    int deleteByPrimaryKey(Long hardwareId);

    int insert(Hardware record);

    int insertSelective(Hardware record);

    List<Hardware> selectByExample(HardwareExample example);

    Hardware selectByPrimaryKey(Long hardwareId);

    int updateByExampleSelective(@Param("record") Hardware record, @Param("example") HardwareExample example);

    int updateByExample(@Param("record") Hardware record, @Param("example") HardwareExample example);

    int updateByPrimaryKeySelective(Hardware record);

    int updateByPrimaryKey(Hardware record);
}