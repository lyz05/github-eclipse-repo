package Book.borrowing.management.system.model;

import java.util.Vector;

import Book.borrowing.management.system.BookDBCon;

public class BookModel{
	public String bookno,bookname,author,press,price,publishdate,shopnum,curnum;
	private String language;
	public BookModel(String language,String bookno) {
		this.language = language;
		this.bookno=bookno;
		String sql = "select * from View_Book_Admin where 图书编号='"+bookno+"'";
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
	
	public BookModel(String language,String bookno,String bookname,String author,String press,String price,String publishdate,String shopnum)
	{
		this.language = language;
		this.bookno=bookno;
		this.bookname=bookname;
		this.author=author;
		this.press=press;
		this.price=price;
		this.publishdate=publishdate;
		this.shopnum=shopnum;
	}
	
	public BookModel(String language,String bookno,String bookname,String author,String press,String price,String publishdate,String shopnum,String curnum)
	{
		this.language = language;
		this.bookno=bookno;
		this.bookname=bookname;
		this.author=author;
		this.press=press;
		this.price=price;
		this.publishdate=publishdate;
		this.shopnum=shopnum;
		this.curnum=curnum;
	}
	public String getSqlQueryString1() {
		String sql= " where 图书编号 like '%"+bookno+"%' and 图书名称 like '%"+bookname+"%' and 作者 like '%"+author +"%' and 出版社 like '%"+press+"%'";
		return sql;
	}
	
	public MessageJSONModel addBook() {
		if (textFiledIsNull()) {
			return new MessageJSONModel("403","addbookallinfo",language);
		}
		if (!checkShopNum()) {
			return new MessageJSONModel("403","checkshopnum",language);
		}
		String sql= "INSERT INTO Book VALUES(?,?,?,?,?,?,?)";
		if (BookDBCon.preparedupdateData(sql,bookno,bookname,author,press,price,publishdate,shopnum)) {
			return new MessageJSONModel("200","addbookok",language);
		} else {
			return new MessageJSONModel("403","addbookfail",language);
		}
	}
	public MessageJSONModel delBook() {
		String sql = "select * from View_Book where 图书编号=?";
		if (BookDBCon.preparedqueryResult(sql,bookno) == null) {
			return new MessageJSONModel("403","booknotfound",language);
		}
		sql = "select * from View_Book where 图书编号=? and 在库数量=入库数量";
		if (BookDBCon.preparedqueryResult(sql,bookno) == null)
		{
			return new MessageJSONModel("403","somebody",language);
		}
		sql = "delete from Borrow where bookno=? and returnDate is not null";
        BookDBCon.preparedupdateData(sql,bookno);
        sql = "delete from Book where bookNO=?";
        if (BookDBCon.preparedupdateData(sql,bookno)) {
        	return new MessageJSONModel("200","deletebookok",language);
		} else {
			return new MessageJSONModel("403","deletebookfail",language);
		}
	}
	public MessageJSONModel editBook() {
		if (textFiledIsNull()) {
			return new MessageJSONModel("403","editbookallinfo",language);
		}
		if (!checkShopNum()) {
			return new MessageJSONModel("403","checkshopnum",language);
		}
		if (BookDBCon.preparedupdateData("update Book set bookName=?,authorName=?,publishingName=?,price=?,publishingDate=?,shopNum=? where bookNO=?",bookname,author,press,price,publishdate,shopnum,bookno)) {
			return new MessageJSONModel("200","editbookok",language);
        } else {
        	return new MessageJSONModel("403","editbookfail",language);
        }
	}
	public boolean textFiledIsNull() {
		return ("").equals(bookno) || ("").equals(bookname) || ("").equals(author) || ("").equals(press) || ("").equals(price) || ("").equals(publishdate) || ("").equals(shopnum);
	}
	public boolean checkShopNum() {
		String sql;
		String subshopnum;
		sql = "select 入库数量-在库数量 from View_Book where 图书编号=?";
		if((subshopnum = BookDBCon.preparedqueryResult(sql, bookno)) != null) {
			return Integer.parseInt(shopnum)>=Integer.parseInt(subshopnum);
		} else return Integer.parseInt(shopnum)>=0;
	}
}
