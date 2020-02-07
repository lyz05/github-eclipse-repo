package cc.home999.book.dao;

import cc.home999.book.bean.BorrowReader;
import cc.home999.book.bean.BorrowReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowReaderMapper {
    long countByExample(BorrowReaderExample example);

    int deleteByExample(BorrowReaderExample example);

    int insert(BorrowReader record);

    int insertSelective(BorrowReader record);

    List<BorrowReader> selectByExample(BorrowReaderExample example);

    int updateByExampleSelective(@Param("record") BorrowReader record, @Param("example") BorrowReaderExample example);

    int updateByExample(@Param("record") BorrowReader record, @Param("example") BorrowReaderExample example);
}