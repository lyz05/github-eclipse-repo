package Book.borrowing.management.system.model;

import java.util.Vector;

import Book.borrowing.management.system.BookDBCon;

public class BookModel {
	public String bookno,bookname,author,press,publishdate_1,publishdate_2,price,publishdate,shopnum;
	public boolean check;
	public String readerno;
	public BookModel(String bookno) {
		this.bookno=bookno;
		String sql = "select * from View_Book_Admin where ͼ����='"+bookno+"'";
		Vector<String> name = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		BookDBCon.queryVector2(sql, data, name);
		this.bookname=data.get(0).get(1);
		this.author=data.get(0).get(2);
		this.press=data.get(0).get(3);
		this.price=data.get(0).get(4);
		this.publishdate=data.get(0).get(5);
		this.shopnum=data.get(0).get(6);
	}
	public BookModel() {
		this.bookno=new String();
		this.bookname=new String();
		this.author=new String();
		this.press=new String();
		this.publishdate_1=new String();
		this.publishdate_2=new String();
		this.price=new String();
		this.publishdate=new String();
		this.shopnum=new String();
		this.check=false;
		this.readerno=new String();
	}
	public BookModel(String bookno,String bookname,String author,String press,String publishdate_1,String publishdate_2,boolean check,String readerno)
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
	public BookModel(String bookno,String bookname,String author,String press,String price,String publishdate,String shopnum)
	{
		this.bookno=bookno;
		this.bookname=bookname;
		this.author=author;
		this.press=press;
		this.price=price;
		this.publishdate=publishdate;
		this.shopnum=shopnum;
	}
	public String getSqlQueryString() {
		String sql = "where ͼ���� like '%"+ bookno + "%' and ͼ������ like '%" + bookname + "%' and ���� like '%" + author + "%' and ������ like '%" + press + "%'";
        if (!publishdate_1.equals("")) 
            sql += " and ��������>='" + publishdate_1+"'";
        if (!publishdate_2.equals("")) 
            sql += " and ��������<='" + publishdate_2+"'";
        if (check)
            sql += " and �ڿ�����>0 and ͼ���� not in (select ͼ���� from View_Borrow where ���߱��='"+readerno+"' and �黹���� is null)";
        return sql;
	}
	public String getSqlQueryString1() {
		String sql= "where ͼ���� like '%"+bookno+"%' and ͼ������ like '%"+bookname+"%' and ���� like '%"+author +"%' and ������ like '%"+press+"%'";
		return sql;
	}
	public boolean getSqlAndResult() {
		String sql= "INSERT INTO Book VALUES(?,?,?,?,?,?,?)";
		return BookDBCon.preparedupdateData(sql,bookno,bookname,author,press,price,publishdate,shopnum);
	}
}