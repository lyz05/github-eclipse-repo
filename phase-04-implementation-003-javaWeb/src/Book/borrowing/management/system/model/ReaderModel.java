package Book.borrowing.management.system.model;

import java.util.Vector;

import Book.borrowing.management.system.BookDBCon;

public class ReaderModel {
	public String readerno,readername,sex,idnum,workunit;
	public ReaderModel(String readerno) {
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
	
	public ReaderModel(String readerno,String readername,String sex,String idnum,String workunit) {
		this.readerno=readerno;
		this.readername=readername;
		this.sex=sex;
		this.idnum=idnum;
		this.workunit=workunit;
	}
	public String getSqlQueryString() {
		String sql=" where 读者编号 like '%"+readerno+"%' and 姓名 like '%"+readername+"%' and 性别 like '%"+sex+"%' and 身份证号 like '%"+idnum+"%' and 工作单位 like '%"+workunit+"%'";
		return sql;
	}
	public MessageJSONModel addReader() {
		if (textFiledIsNull()) 
			return new MessageJSONModel("403","请填写欲添加读者的所有信息");
		if (!checkIDNum()) 
			return new MessageJSONModel("403","身份证位数不正确");
		if (!checksex())
			return new MessageJSONModel("403","性别填写有误");
		String sql= "INSERT INTO Reader VALUES(?,?,?,?,?,'')";
		if (BookDBCon.preparedupdateData(sql,readerno,readername,sex,idnum,workunit)) {
			return new MessageJSONModel("200","添加信息成功");
		} else {
			return new MessageJSONModel("403","添加信息失败");
		}
	}
	public MessageJSONModel delReader() {
		String sql = "select * from View_reader where 读者编号=?";
		if (BookDBCon.preparedqueryResult(sql, readerno) == null) {
			return new MessageJSONModel("403", "此位读者不存在");
		}
		sql = "select * from View_reader where 读者编号=? and 未归还数量=0";
		if (BookDBCon.preparedqueryResult(sql, readerno) == null) {
			return new MessageJSONModel("403", "该读者还有未归还的图书，因此无法删除该读者");
		}
		sql = "delete from Borrow where readerNO=? and returnDate is not null";
		BookDBCon.preparedupdateData(sql, readerno);
		sql = "delete from reader where readerNO=?";
		if (BookDBCon.preparedupdateData(sql, readerno)) {
        	return new MessageJSONModel("200","删除读者信息成功");
		} else {
			return new MessageJSONModel("403","删除读者信息失败");
		}
	}
	public MessageJSONModel editReader() {
		if (textFiledIsNull()) 
			return new MessageJSONModel("403","请填写欲修改读者的所有信息");
		if (!checkIDNum()) 
			return new MessageJSONModel("403","身份证位数不正确");
		if (!checksex())
			return new MessageJSONModel("403","性别填写有误");
		if (BookDBCon.preparedupdateData("update Reader set readerName=?,sex=?,identitycard=?,workUnit=? where readerNO=?",readername,sex,idnum,workunit,readerno)) {
			return new MessageJSONModel("200","修改信息成功");
        } else {
        	return new MessageJSONModel("403","修改信息失败");
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
