package cc.home999.book.dao;

import cc.home999.book.bean.BookReader;
import cc.home999.book.bean.BookReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookReaderMapper {
    long countByExample(BookReaderExample example);

    int deleteByExample(BookReaderExample example);

    int insert(BookReader record);

    int insertSelective(BookReader record);

    List<BookReader> selectByExample(BookReaderExample example);

    int updateByExampleSelective(@Param("record") BookReader record, @Param("example") BookReaderExample example);

    int updateByExample(@Param("record") BookReader record, @Param("example") BookReaderExample example);
}