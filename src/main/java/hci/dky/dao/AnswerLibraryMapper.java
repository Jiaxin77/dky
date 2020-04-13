package hci.dky.dao;

import hci.dky.pojo.AnswerLibrary;
import hci.dky.pojo.AnswerLibraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswerLibraryMapper {
    int countByExample(AnswerLibraryExample example);

    int deleteByExample(AnswerLibraryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AnswerLibrary record);

    int insertSelective(AnswerLibrary record);

    List<AnswerLibrary> selectByExample(AnswerLibraryExample example);

    AnswerLibrary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnswerLibrary record, @Param("example") AnswerLibraryExample example);

    int updateByExample(@Param("record") AnswerLibrary record, @Param("example") AnswerLibraryExample example);

    int updateByPrimaryKeySelective(AnswerLibrary record);

    int updateByPrimaryKey(AnswerLibrary record);
}