package hci.dky.dao;

import hci.dky.pojo.IndexAndMethod;
import hci.dky.pojo.IndexAndMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexAndMethodMapper {
    int countByExample(IndexAndMethodExample example);

    int deleteByExample(IndexAndMethodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IndexAndMethod record);

    int insertSelective(IndexAndMethod record);

    List<IndexAndMethod> selectByExample(IndexAndMethodExample example);

    IndexAndMethod selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IndexAndMethod record, @Param("example") IndexAndMethodExample example);

    int updateByExample(@Param("record") IndexAndMethod record, @Param("example") IndexAndMethodExample example);

    int updateByPrimaryKeySelective(IndexAndMethod record);

    int updateByPrimaryKey(IndexAndMethod record);
}