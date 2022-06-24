package Book.borrowing.management.system.model;

//借阅图书过滤器及借阅图书
public class BorrowBookModel {
	public String bookno,bookname,author,press,publishdate_1,publishdate_2,price,publishdate,shopnum,curnum;
	public boolean check;
	public String readerno;
	//过滤器构造函数
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
	//借阅图书构造函数
	public BorrowBookModel(String bookno,String bookname,String author,String press,String publishdate,String shopnum,String curnum)
	{
		this.bookno=bookno;
		this.bookname=bookname;
		this.author=author;
		this.press=press;
		this.publishdate=publishdate;
		this.shopnum=shopnum;
		this.curnum=curnum;
	}
	public String sqlQueryString() {
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