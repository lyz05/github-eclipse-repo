package Book.borrowing.management.system.model;

public class ReaderModel {
	public String readerno,readername,sex,idnum,workunit;
	
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
}
