package hci.artedu.dao;

import hci.artedu.pojo.MethodLibrary;
import hci.artedu.pojo.MethodLibraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MethodLibraryMapper {
    int countByExample(MethodLibraryExample example);

    int deleteByExample(MethodLibraryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MethodLibrary record);

    int insertSelective(MethodLibrary record);

    List<MethodLibrary> selectByExample(MethodLibraryExample example);

    MethodLibrary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MethodLibrary record, @Param("example") MethodLibraryExample example);

    int updateByExample(@Param("record") MethodLibrary record, @Param("example") MethodLibraryExample example);

    int updateByPrimaryKeySelective(MethodLibrary record);

    int updateByPrimaryKey(MethodLibrary record);
}