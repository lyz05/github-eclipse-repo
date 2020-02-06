package cc.home999.book.dao;

import cc.home999.book.bean.Reader;
import cc.home999.book.bean.ReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReaderMapper {
    long countByExample(ReaderExample example);

    int deleteByExample(ReaderExample example);

    int deleteByPrimaryKey(String readerno);

    int insert(Reader record);

    int insertSelective(Reader record);

    List<Reader> selectByExample(ReaderExample example);

    Reader selectByPrimaryKey(String readerno);

    int updateByExampleSelective(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByExample(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}