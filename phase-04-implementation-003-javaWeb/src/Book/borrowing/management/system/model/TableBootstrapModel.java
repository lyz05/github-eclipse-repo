package Book.borrowing.management.system.model;
import java.util.*;

import Book.borrowing.management.system.BookDBCon;

//bootstrap
public class TableBootstrapModel {
	public int total;
	public Vector<Object> rows;
	
	public TableBootstrapModel(String sql,String tableName) {
        //data是表格中的数据，name是表头字段信息
    	Vector<Vector<String>> data = new Vector<Vector<String>>();
    	Vector<String> name = new Vector<String>();
        rows = new Vector<Object>();
    	BookDBCon.queryVector2(sql, data, name);
        total = data.size();
        
        for (Vector<String> row : data) {
        	if (tableName.equals("View_Book_Admin")) {
        		rows.add(new BookModel(null,row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6),row.get(7)));
            } else if (tableName.equals("View_Reader")) {
            	rows.add(new ReaderModel(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6)));
            } else if (tableName.equals("View_Book")) {
            	rows.add(new BorrowBookModel(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6)));
            } else if (tableName.equals("Borrow") || tableName.equals("BorrowHistory")) {
            	rows.add(new BorrowModel(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6)));
            }
        }
    }
}
