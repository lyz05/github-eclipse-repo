package Book.borrowing.management.system.model;

import java.util.Vector;

import Book.borrowing.management.system.BookDBCon;

public class ReaderModel {
	public String readerno,readername,sex,idnum,workunit,totalborrownum,notreturnnum;
	private String language;
	public ReaderModel(String language,String readerno) {
		this.language = language;
		this.readerno=readerno;
		String sql = "select * from View_Reader where 读者编号='"+readerno+"'";
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
	
	public ReaderModel(String language,String readerno,String readername,String sex,String idnum,String workunit) {
		this.language=language;
		this.readerno=readerno;
		this.readername=readername;
		this.sex=sex;
		this.idnum=idnum;
		this.workunit=workunit;
	}
	public ReaderModel(String readerno,String readername,String sex,String idnum,String workunit,String totalborrownum,String notreturnnum)
	{
		this.readerno=readerno;
		this.readername=readername;
		this.sex=sex;
		this.idnum=idnum;
		this.workunit=workunit;
		this.totalborrownum=totalborrownum;
		this.notreturnnum=notreturnnum;
	}
	public String getSqlQueryString() {
		String sql=" where 读者编号 like '%"+readerno+"%' and 姓名 like '%"+readername+"%' and 性别 like '%"+sex+"%' and 身份证号 like '%"+idnum+"%' and 工作单位 like '%"+workunit+"%'";
		return sql;
	}
	public Msg addReader() {
		if (textFiledIsNull()) 
			return new Msg("403","addreaderallinfo",language);
		if (!checkIDNum()) 
			return new Msg("403","idnumerror",language);
		if (!checksex())
			return new Msg("403","sexerror",language);
		String sql= "INSERT INTO Reader VALUES(?,?,?,?,?,'')";
		if (BookDBCon.preparedupdateData(sql,readerno,readername,sex,idnum,workunit)) {
			return new Msg("200","addreaderok",language);
		} else {
			return new Msg("403","addreaderfail",language);
		}
	}
	public Msg delReader() {
		String sql = "select * from View_reader where 读者编号=?";
		if (BookDBCon.preparedqueryResult(sql, readerno) == null) {
			return new Msg("403", "readernotfound",language);
		}
		sql = "select * from View_reader where 读者编号=? and 未归还数量=0";
		if (BookDBCon.preparedqueryResult(sql, readerno) == null) {
			return new Msg("403", "somebody1",language);
		}
		sql = "delete from Borrow where readerNO=? and returnDate is not null";
		BookDBCon.preparedupdateData(sql, readerno);
		sql = "delete from reader where readerNO=?";
		if (BookDBCon.preparedupdateData(sql, readerno)) {
        	return new Msg("200","deletereaderok",language);
		} else {
			return new Msg("403","deletereaderfail",language);
		}
	}
	public Msg editReader() {
		if (textFiledIsNull()) 
			return new Msg("403","editbookallinfo",language);
		if (!checkIDNum()) 
			return new Msg("403","idnumerror",language);
		if (!checksex())
			return new Msg("403","sexerror",language);
		if (BookDBCon.preparedupdateData("update Reader set readerName=?,sex=?,identitycard=?,workUnit=? where readerNO=?",readername,sex,idnum,workunit,readerno)) {
			return new Msg("200","editreaderok",language);
        } else {
        	return new Msg("403","editreaderfail",language);
        }
	}
	public boolean textFiledIsNull() {
		return ("").equals(readerno) || ("").equals(readername) || ("").equals(sex) || ("").equals(idnum) || ("").equals(workunit);
	}
	public boolean checkIDNum() {
		return idnum.length()==18;
	}
	public boolean checksex() {
		return sex.equals("男") || sex.equals("女");
	}
}
