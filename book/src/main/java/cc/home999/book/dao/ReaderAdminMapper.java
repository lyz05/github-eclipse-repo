package cc.home999.book.dao;

import cc.home999.book.bean.ReaderAdmin;
import cc.home999.book.bean.ReaderAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReaderAdminMapper {
    long countByExample(ReaderAdminExample example);

    int deleteByExample(ReaderAdminExample example);

    int insert(ReaderAdmin record);

    int insertSelective(ReaderAdmin record);

    List<ReaderAdmin> selectByExample(ReaderAdminExample example);

    int updateByExampleSelective(@Param("record") ReaderAdmin record, @Param("example") ReaderAdminExample example);

    int updateByExample(@Param("record") ReaderAdmin record, @Param("example") ReaderAdminExample example);
}