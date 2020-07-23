package hci.dky.dao;

import hci.dky.pojo.BorgScaleAnswerPaper;
import hci.dky.pojo.BorgScaleAnswerPaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorgScaleAnswerPaperMapper {
    long countByExample(BorgScaleAnswerPaperExample example);

    int deleteByExample(BorgScaleAnswerPaperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BorgScaleAnswerPaper record);

    int insertSelective(BorgScaleAnswerPaper record);

    List<BorgScaleAnswerPaper> selectByExample(BorgScaleAnswerPaperExample example);

    BorgScaleAnswerPaper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BorgScaleAnswerPaper record, @Param("example") BorgScaleAnswerPaperExample example);

    int updateByExample(@Param("record") BorgScaleAnswerPaper record, @Param("example") BorgScaleAnswerPaperExample example);

    int updateByPrimaryKeySelective(BorgScaleAnswerPaper record);

    int updateByPrimaryKey(BorgScaleAnswerPaper record);
}