package Book.borrowing.management.system.model;
import java.util.*;

import Book.borrowing.management.system.BookDBCon;

public class TableModel {
	public int rows,cols;
	public Vector<Vector<String>> data = new Vector<Vector<String>>();
	public Vector<String> name = new Vector<String>();
	public String username = new String();
	public String readername = new String();
	
	public TableModel(String sql,String username,String readername) {
        //data�Ǳ���е����ݣ�name�Ǳ�ͷ�ֶ���Ϣ
        BookDBCon.queryVector2(sql, data, name);
        rows = data.size();
        cols = name.size();
        this.username = username;
        this.readername = readername;
    }
}
