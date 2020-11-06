package hci.dky.dao;

import hci.dky.pojo.IndexLibrary;
import hci.dky.pojo.IndexLibraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexLibraryMapper {
    int countByExample(IndexLibraryExample example);

    int deleteByExample(IndexLibraryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IndexLibrary record);

    int insertSelective(IndexLibrary record);

    List<IndexLibrary> selectByExample(IndexLibraryExample example);

    IndexLibrary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IndexLibrary record, @Param("example") IndexLibraryExample example);

    int updateByExample(@Param("record") IndexLibrary record, @Param("example") IndexLibraryExample example);

    int updateByPrimaryKeySelective(IndexLibrary record);

    int updateByPrimaryKey(IndexLibrary record);
}