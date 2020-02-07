package cc.home999.book.dao;

import cc.home999.book.bean.BookAdmin;
import cc.home999.book.bean.BookAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookAdminMapper {
    long countByExample(BookAdminExample example);

    int deleteByExample(BookAdminExample example);

    int insert(BookAdmin record);

    int insertSelective(BookAdmin record);

    List<BookAdmin> selectByExample(BookAdminExample example);

    int updateByExampleSelective(@Param("record") BookAdmin record, @Param("example") BookAdminExample example);

    int updateByExample(@Param("record") BookAdmin record, @Param("example") BookAdminExample example);
}