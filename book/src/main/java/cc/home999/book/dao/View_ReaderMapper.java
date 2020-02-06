package cc.home999.book.dao;

import cc.home999.book.bean.View_Reader;
import cc.home999.book.bean.View_ReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface View_ReaderMapper {
    long countByExample(View_ReaderExample example);

    int deleteByExample(View_ReaderExample example);

    int insert(View_Reader record);

    int insertSelective(View_Reader record);

    List<View_Reader> selectByExample(View_ReaderExample example);

    int updateByExampleSelective(@Param("record") View_Reader record, @Param("example") View_ReaderExample example);

    int updateByExample(@Param("record") View_Reader record, @Param("example") View_ReaderExample example);
}