package hci.dky.dao;

import hci.dky.pojo.ExpertAnswerPaper;
import hci.dky.pojo.ExpertAnswerPaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertAnswerPaperMapper {
    long countByExample(ExpertAnswerPaperExample example);

    int deleteByExample(ExpertAnswerPaperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpertAnswerPaper record);

    int insertSelective(ExpertAnswerPaper record);

    List<ExpertAnswerPaper> selectByExample(ExpertAnswerPaperExample example);

    ExpertAnswerPaper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpertAnswerPaper record, @Param("example") ExpertAnswerPaperExample example);

    int updateByExample(@Param("record") ExpertAnswerPaper record, @Param("example") ExpertAnswerPaperExample example);

    int updateByPrimaryKeySelective(ExpertAnswerPaper record);

    int updateByPrimaryKey(ExpertAnswerPaper record);
}