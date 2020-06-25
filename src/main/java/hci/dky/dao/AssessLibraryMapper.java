package hci.dky.dao;

import hci.dky.pojo.AssessLibrary;
import hci.dky.pojo.AssessLibraryExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface AssessLibraryMapper {
    long countByExample(AssessLibraryExample example);

    int deleteByExample(AssessLibraryExample example);

    int deleteByPrimaryKey(Long assessId);

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(AssessLibrary record);

    int insertSelective(AssessLibrary record);

    List<AssessLibrary> selectByExample(AssessLibraryExample example);

    AssessLibrary selectByPrimaryKey(Long assessId);

    int updateByExampleSelective(@Param("record") AssessLibrary record, @Param("example") AssessLibraryExample example);

    int updateByExample(@Param("record") AssessLibrary record, @Param("example") AssessLibraryExample example);

    int updateByPrimaryKeySelective(AssessLibrary record);

    int updateByPrimaryKey(AssessLibrary record);
}