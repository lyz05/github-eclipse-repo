package Book.borrowing.management.system.model;

import java.util.Vector;

import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.BookDBCon;

public class BookModel {
	public String bookno,bookname,author,press,price,publishdate,shopnum;
	public BookModel(String bookno) {
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
	
	public String getSqlQueryString1() {
		String sql= " where 图书编号 like '%"+bookno+"%' and 图书名称 like '%"+bookname+"%' and 作者 like '%"+author +"%' and 出版社 like '%"+press+"%'";
		return sql;
	}
	
	public MessageJSONModel addBook() {
		if (textFiledIsNull()) {
			return new MessageJSONModel("403","请填写欲添加图书的所有信息");
		}
		if (!checkShopNum()) {
			return new MessageJSONModel("403","入库数量必须大于等于0");
		}
		String sql= "INSERT INTO Book VALUES(?,?,?,?,?,?,?)";
		if (BookDBCon.preparedupdateData(sql,bookno,bookname,author,press,price,publishdate,shopnum)) {
			return new MessageJSONModel("200","添加信息成功");
		} else {
			return new MessageJSONModel("403","添加信息失败");
		}
	}
	public MessageJSONModel delBook() {
		String sql = "select * from View_Book where 图书编号=?";
		if (BookDBCon.preparedqueryResult(sql,bookno) == null) {
			return new MessageJSONModel("403","该本图书不存在");
		}
		sql = "select * from View_Book where 图书编号=? and 在库数量=入库数量";
		if (BookDBCon.preparedqueryResult(sql,bookno) == null)
		{
			return new MessageJSONModel("403","还有读者未归还此本图书，因此无法删除此书");
		}
		sql = "delete from Borrow where bookno=? and returnDate is not null";
        BookDBCon.preparedupdateData(sql,bookno);
        sql = "delete from Book where bookNO=?";
        if (BookDBCon.preparedupdateData(sql,bookno)) {
        	return new MessageJSONModel("200","删除图书信息成功");
		} else {
			return new MessageJSONModel("403","删除图书信息失败");
		}
	}
	public MessageJSONModel editBook() {
		if (textFiledIsNull()) {
			return new MessageJSONModel("403","请填写欲修改图书的所有信息");
		}
		if (!checkShopNum()) {
			return new MessageJSONModel("403","在库数量必须大于等于0");
		}
		if (BookDBCon.preparedupdateData("update Book set bookName=?,authorName=?,publishingName=?,price=?,publishingDate=?,shopNum=? where bookNO=?",bookname,author,press,price,publishdate,shopnum,bookno)) {
			return new MessageJSONModel("200","修改图书信息成功");
        } else {
        	return new MessageJSONModel("403","修改图书信息失败");
        }
	}
	public boolean textFiledIsNull() {
		return ("").equals(bookno) || ("").equals(bookname) || ("").equals(author) || ("").equals(press) || ("").equals(price) || ("").equals(publishdate) || ("").equals(shopnum);
	}
	public boolean checkShopNum() {
		String sql;
		String subshopnum;
		sql = "select 入库数量-在库数量 from view_book where 图书编号=?";
		if((subshopnum = BookDBCon.preparedqueryResult(sql, bookno)) != null) {
			return Integer.parseInt(shopnum)>=Integer.parseInt(subshopnum);
		} else return Integer.parseInt(shopnum)>=0;
	}
}
