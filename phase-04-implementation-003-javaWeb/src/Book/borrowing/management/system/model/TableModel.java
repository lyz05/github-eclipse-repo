package Book.borrowing.management.system.model;
import java.util.*;

import Book.borrowing.management.system.BookDBCon;

public class TableModel {
	public Vector<Vector<String>> data = new Vector<Vector<String>>();
	public Vector<String> name = new Vector<String>();
	
	public TableModel(String sql) {
        //data是表格中的数据，name是表头字段信息
        BookDBCon.queryVector2(sql, data, name);
    }
}
