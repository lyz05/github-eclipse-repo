package cc.home999.book.dao;

import cc.home999.book.bean.View_Book;
import cc.home999.book.bean.View_BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface View_BookMapper {
    long countByExample(View_BookExample example);

    int deleteByExample(View_BookExample example);

    int insert(View_Book record);

    int insertSelective(View_Book record);

    List<View_Book> selectByExample(View_BookExample example);

    int updateByExampleSelective(@Param("record") View_Book record, @Param("example") View_BookExample example);

    int updateByExample(@Param("record") View_Book record, @Param("example") View_BookExample example);
}