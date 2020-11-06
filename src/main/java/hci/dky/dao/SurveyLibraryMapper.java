package hci.dky.dao;

import hci.dky.pojo.SurveyLibrary;
import hci.dky.pojo.SurveyLibraryExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface SurveyLibraryMapper {
    int countByExample(SurveyLibraryExample example);

    int deleteByExample(SurveyLibraryExample example);

    int deleteByPrimaryKey(Long id);

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(SurveyLibrary record);

    int insertSelective(SurveyLibrary record);

    List<SurveyLibrary> selectByExample(SurveyLibraryExample example);

    SurveyLibrary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SurveyLibrary record, @Param("example") SurveyLibraryExample example);

    int updateByExample(@Param("record") SurveyLibrary record, @Param("example") SurveyLibraryExample example);

    int updateByPrimaryKeySelective(SurveyLibrary record);

    int updateByPrimaryKey(SurveyLibrary record);
}