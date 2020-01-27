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
		String sql=" where ���߱�� like '%"+readerno+"%' and ���� like '%"+readername+"%' and �Ա� like '%"+sex+"%' and ���֤�� like '%"+idnum+"%' and ������λ like '%"+workunit+"%'";
		return sql;
	}
	public MessageJSONModel addReader() {
		if (textFiledIsNull()) 
			return new MessageJSONModel("403","����д����Ӷ��ߵ�������Ϣ");
		if (!checkIDNum()) 
			return new MessageJSONModel("403","���֤λ������ȷ");
		if (!checksex())
			return new MessageJSONModel("403","�Ա���д����");
		String sql= "INSERT INTO Reader VALUES(?,?,?,?,?,'')";
		if (BookDBCon.preparedupdateData(sql,readerno,readername,sex,idnum,workunit)) {
			return new MessageJSONModel("200","�����Ϣ�ɹ�");
		} else {
			return new MessageJSONModel("403","�����Ϣʧ��");
		}
	}
	public MessageJSONModel delReader() {
		String sql = "select * from View_reader where ���߱��=?";
		if (BookDBCon.preparedqueryResult(sql, readerno) == null) {
			return new MessageJSONModel("403", "��λ���߲�����");
		}
		sql = "select * from View_reader where ���߱��=? and δ�黹����=0";
		if (BookDBCon.preparedqueryResult(sql, readerno) == null) {
			return new MessageJSONModel("403", "�ö��߻���δ�黹��ͼ�飬����޷�ɾ���ö���");
		}
		sql = "delete from Borrow where readerNO=? and returnDate is not null";
		BookDBCon.preparedupdateData(sql, readerno);
		sql = "delete from reader where readerNO=?";
		if (BookDBCon.preparedupdateData(sql, readerno)) {
        	return new MessageJSONModel("200","ɾ��������Ϣ�ɹ�");
		} else {
			return new MessageJSONModel("403","ɾ��������Ϣʧ��");
		}
	}
	public MessageJSONModel editReader() {
		if (textFiledIsNull()) 
			return new MessageJSONModel("403","����д���޸Ķ��ߵ�������Ϣ");
		if (!checkIDNum()) 
			return new MessageJSONModel("403","���֤λ������ȷ");
		if (!checksex())
			return new MessageJSONModel("403","�Ա���д����");
		if (BookDBCon.preparedupdateData("update Reader set readerName=?,sex=?,identitycard=?,workUnit=? where readerNO=?",readername,sex,idnum,workunit,readerno)) {
			return new MessageJSONModel("200","�޸���Ϣ�ɹ�");
        } else {
        	return new MessageJSONModel("403","�޸���Ϣʧ��");
        }
	}
	public boolean textFiledIsNull() {
		return ("").equals(readerno) || ("").equals(readername) || ("").equals(sex) || ("").equals(idnum) || ("").equals(workunit);
	}
	public boolean checkIDNum() {
		return idnum.length()==18;
	}
	public boolean checksex() {
		return sex.equals("��") || sex.equals("Ů");
	}
}
