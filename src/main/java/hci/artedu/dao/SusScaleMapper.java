package hci.artedu.dao;

import hci.artedu.pojo.SusScale;
import hci.artedu.pojo.SusScaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SusScaleMapper {
    int countByExample(SusScaleExample example);

    int deleteByExample(SusScaleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SusScale record);

    int insertSelective(SusScale record);

    List<SusScale> selectByExample(SusScaleExample example);

    SusScale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SusScale record, @Param("example") SusScaleExample example);

    int updateByExample(@Param("record") SusScale record, @Param("example") SusScaleExample example);

    int updateByPrimaryKeySelective(SusScale record);

    int updateByPrimaryKey(SusScale record);
}