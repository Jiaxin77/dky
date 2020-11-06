package hci.dky.dao;

import hci.dky.pojo.ChoiceQuestionLibrary;
import hci.dky.pojo.ChoiceQuestionLibraryExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface ChoiceQuestionLibraryMapper {
    int countByExample(ChoiceQuestionLibraryExample example);

    int deleteByExample(ChoiceQuestionLibraryExample example);

    int deleteByPrimaryKey(Long id);

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(ChoiceQuestionLibrary record);

    int insertSelective(ChoiceQuestionLibrary record);

    List<ChoiceQuestionLibrary> selectByExample(ChoiceQuestionLibraryExample example);

    ChoiceQuestionLibrary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChoiceQuestionLibrary record, @Param("example") ChoiceQuestionLibraryExample example);

    int updateByExample(@Param("record") ChoiceQuestionLibrary record, @Param("example") ChoiceQuestionLibraryExample example);

    int updateByPrimaryKeySelective(ChoiceQuestionLibrary record);

    int updateByPrimaryKey(ChoiceQuestionLibrary record);
}