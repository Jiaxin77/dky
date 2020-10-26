package hci.artedu.dao;

import hci.artedu.pojo.SusScaleAnswerPaper;
import hci.artedu.pojo.SusScaleAnswerPaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SusScaleAnswerPaperMapper {
    long countByExample(SusScaleAnswerPaperExample example);

    int deleteByExample(SusScaleAnswerPaperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SusScaleAnswerPaper record);

    int insertSelective(SusScaleAnswerPaper record);

    List<SusScaleAnswerPaper> selectByExample(SusScaleAnswerPaperExample example);

    SusScaleAnswerPaper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SusScaleAnswerPaper record, @Param("example") SusScaleAnswerPaperExample example);

    int updateByExample(@Param("record") SusScaleAnswerPaper record, @Param("example") SusScaleAnswerPaperExample example);

    int updateByPrimaryKeySelective(SusScaleAnswerPaper record);

    int updateByPrimaryKey(SusScaleAnswerPaper record);
}