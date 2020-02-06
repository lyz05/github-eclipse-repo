package cc.home999.book.dao;

import cc.home999.book.bean.Borrow;
import cc.home999.book.bean.BorrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowMapper {
    long countByExample(BorrowExample example);

    int deleteByExample(BorrowExample example);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    List<Borrow> selectByExample(BorrowExample example);

    int updateByExampleSelective(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByExample(@Param("record") Borrow record, @Param("example") BorrowExample example);
}