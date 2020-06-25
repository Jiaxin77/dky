package hci.dky.dao;

import hci.dky.pojo.PaperList;
import hci.dky.pojo.PaperListExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface PaperListMapper {
    int countByExample(PaperListExample example);

    int deleteByExample(PaperListExample example);

    int deleteByPrimaryKey(Long id);

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(PaperList record);

    int insertSelective(PaperList record);

    List<PaperList> selectByExample(PaperListExample example);

    PaperList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaperList record, @Param("example") PaperListExample example);

    int updateByExample(@Param("record") PaperList record, @Param("example") PaperListExample example);

    int updateByPrimaryKeySelective(PaperList record);

    int updateByPrimaryKey(PaperList record);
}