package Book.borrowing.management.system.model;
import java.util.*;

import Book.borrowing.management.system.BookDBCon;

public class TableBootstrapModel {
	public int total;
	public Vector<BookModel> array;
	private String language;
	
	public TableBootstrapModel(String sql,String language) {
		this.language=language;
        //data是表格中的数据，name是表头字段信息
    	Vector<Vector<String>> data = new Vector<Vector<String>>();
    	Vector<String> name = new Vector<String>();
        array = new Vector<BookModel>();
    	BookDBCon.queryVector2(sql, data, name);
        total = data.size();
        for (Vector<String> row : data) {
			array.add(new BookModel(language,row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6),row.get(7)));
		}
    }
}
