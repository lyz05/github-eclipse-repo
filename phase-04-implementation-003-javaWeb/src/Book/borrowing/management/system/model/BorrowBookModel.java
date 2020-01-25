package Book.borrowing.management.system.model;


import Book.borrowing.management.system.BookDBCon;

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
		String sql = " where 图书编号 like '%"+ bookno + "%' and 图书名称 like '%" + bookname + "%' and 作者 like '%" + author + "%' and 出版社 like '%" + press + "%'";
        if (!publishdate_1.equals("")) 
            sql += " and 出版日期>='" + publishdate_1+"'";
        if (!publishdate_2.equals("")) 
            sql += " and 出版日期<='" + publishdate_2+"'";
        if (check)
            sql += " and 在库数量>0 and 图书编号 not in (select 图书编号 from View_Borrow where 读者编号='"+readerno+"' and 归还日期 is null)";
        return sql;
	}
}