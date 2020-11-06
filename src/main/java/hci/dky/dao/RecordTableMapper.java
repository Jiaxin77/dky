package hci.dky.dao;

import hci.dky.pojo.RecordTable;
import hci.dky.pojo.RecordTableExample;
import hci.dky.pojo.RecordTableWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordTableMapper {
    int countByExample(RecordTableExample example);

    int deleteByExample(RecordTableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RecordTableWithBLOBs record);

    int insertSelective(RecordTableWithBLOBs record);

    List<RecordTableWithBLOBs> selectByExampleWithBLOBs(RecordTableExample example);

    List<RecordTable> selectByExample(RecordTableExample example);

    RecordTableWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RecordTableWithBLOBs record, @Param("example") RecordTableExample example);

    int updateByExampleWithBLOBs(@Param("record") RecordTableWithBLOBs record, @Param("example") RecordTableExample example);

    int updateByExample(@Param("record") RecordTable record, @Param("example") RecordTableExample example);

    int updateByPrimaryKeySelective(RecordTableWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordTableWithBLOBs record);

    int updateByPrimaryKey(RecordTable record);
}