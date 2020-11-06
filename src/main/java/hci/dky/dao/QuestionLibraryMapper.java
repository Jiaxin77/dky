package hci.dky.dao;

import hci.dky.pojo.QuestionLibrary;
import hci.dky.pojo.QuestionLibraryExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface QuestionLibraryMapper {
    int countByExample(QuestionLibraryExample example);

    int deleteByExample(QuestionLibraryExample example);

    int deleteByPrimaryKey(Long id);

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(QuestionLibrary record);

    int insertSelective(QuestionLibrary record);

    List<QuestionLibrary> selectByExample(QuestionLibraryExample example);

    QuestionLibrary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuestionLibrary record, @Param("example") QuestionLibraryExample example);

    int updateByExample(@Param("record") QuestionLibrary record, @Param("example") QuestionLibraryExample example);

    int updateByPrimaryKeySelective(QuestionLibrary record);

    int updateByPrimaryKey(QuestionLibrary record);
}