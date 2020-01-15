package Book.borrowing.management.system.model;

import java.util.Vector;

import Book.borrowing.management.system.BookDBCon;

public class ReaderModel {
	public String readerno,readername,sex,idnum,workunit;
	public ReaderModel(String readerno) {
		this.readerno=readerno;
		String sql = "select * from View_Reader where ���߱��='"+readerno+"'";
		Vector<String> name = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		BookDBCon.queryVector2(sql, data, name);
		this.readername=data.get(0).get(1);
		this.sex=data.get(0).get(2);
		this.idnum=data.get(0).get(3);
		this.workunit=data.get(0).get(4);
	}
	
	public ReaderModel()
	{
		this.readerno=new String();
		this.readername=new String();
		this.sex=new String();
		this.idnum=new String();
		this.workunit=new String();
	}
	
	public ReaderModel(String readerno,String readername,String sex,String idnum,String workunit) {
		this.readerno=readerno;
		this.readername=readername;
		this.sex=sex;
		this.idnum=idnum;
		this.workunit=workunit;
	}
	public String getSqlQueryString() {
		String sql="where ���߱�� like '%"+readerno+"%' and ���� like '%"+readername+"%' and �Ա� like '%"+sex+"%' and ���֤�� like '%"+idnum+"%' and ������λ like '%"+workunit+"%'";
		return sql;
	}
	public boolean getSqlAddResult() {
		String sql= "INSERT INTO Reader VALUES(?,?,?,?,?,'')";
		return BookDBCon.preparedupdateData(sql,readerno,readername,sex,idnum,workunit);
	}
}
