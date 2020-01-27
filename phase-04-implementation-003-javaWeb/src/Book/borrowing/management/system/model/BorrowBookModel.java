package Book.borrowing.management.system.model;

public class BorrowBookModel {
	public String bookno,bookname,author,press,publishdate_1,publishdate_2,price,publishdate,shopnum;
	public boolean check;
	public String readerno;
	public BorrowBookModel(String bookno,String bookname,String author,String press,String publishdate_1,String publishdate_2,boolean check,String readerno)
	{
		this.bookno=bookno;
		this.bookname=bookname;
		this.author=author;
		this.press=press;
		this.publishdate_1=publishdate_1;
		this.publishdate_2=publishdate_2;
		this.check=check;
		this.readerno=readerno;
	}
	public String getSqlQueryString() {
		String sql = " where ͼ���� like '%"+ bookno + "%' and ͼ������ like '%" + bookname + "%' and ���� like '%" + author + "%' and ������ like '%" + press + "%'";
        if (!publishdate_1.equals("")) 
            sql += " and ��������>='" + publishdate_1+"'";
        if (!publishdate_2.equals("")) 
            sql += " and ��������<='" + publishdate_2+"'";
        if (check)
            sql += " and �ڿ�����>0 and ͼ���� not in (select ͼ���� from View_Borrow where ���߱��='"+readerno+"' and �黹���� is null)";
        return sql;
	}
}