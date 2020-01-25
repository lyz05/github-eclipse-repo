package Book.borrowing.management.system.model;

import java.util.Vector;

import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.BookDBCon;

public class BookModel {
	public String bookno,bookname,author,press,price,publishdate,shopnum;
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
		String sql= " where ͼ���� like '%"+bookno+"%' and ͼ������ like '%"+bookname+"%' and ���� like '%"+author +"%' and ������ like '%"+press+"%'";
		return sql;
	}
	
	public MessageJSONModel addBook() {
		if (textFiledIsNull()) {
			return new MessageJSONModel("403","����д�����ͼ���������Ϣ");
		}
		if (!checkShopNum()) {
			return new MessageJSONModel("403","�������������ڵ���0");
		}
		String sql= "INSERT INTO Book VALUES(?,?,?,?,?,?,?)";
		if (BookDBCon.preparedupdateData(sql,bookno,bookname,author,press,price,publishdate,shopnum)) {
			return new MessageJSONModel("200","�����Ϣ�ɹ�");
		} else {
			return new MessageJSONModel("403","�����Ϣʧ��");
		}
	}
	public MessageJSONModel delBook() {
		String sql = "select * from View_Book where ͼ����=?";
		if (BookDBCon.preparedqueryResult(sql,bookno) == null) {
			return new MessageJSONModel("403","�ñ�ͼ�鲻����");
		}
		sql = "select * from View_Book where ͼ����=? and �ڿ�����=�������";
		if (BookDBCon.preparedqueryResult(sql,bookno) == null)
		{
			return new MessageJSONModel("403","���ж���δ�黹�˱�ͼ�飬����޷�ɾ������");
		}
		sql = "delete from Borrow where bookno=? and returnDate is not null";
        BookDBCon.preparedupdateData(sql,bookno);
        sql = "delete from Book where bookNO=?";
        if (BookDBCon.preparedupdateData(sql,bookno)) {
        	return new MessageJSONModel("200","ɾ��ͼ����Ϣ�ɹ�");
		} else {
			return new MessageJSONModel("403","ɾ��ͼ����Ϣʧ��");
		}
	}
	public MessageJSONModel editBook() {
		if (textFiledIsNull()) {
			return new MessageJSONModel("403","����д���޸�ͼ���������Ϣ");
		}
		if (!checkShopNum()) {
			return new MessageJSONModel("403","�ڿ�����������ڵ���0");
		}
		if (BookDBCon.preparedupdateData("update Book set bookName=?,authorName=?,publishingName=?,price=?,publishingDate=?,shopNum=? where bookNO=?",bookname,author,press,price,publishdate,shopnum,bookno)) {
			return new MessageJSONModel("200","�޸�ͼ����Ϣ�ɹ�");
        } else {
        	return new MessageJSONModel("403","�޸�ͼ����Ϣʧ��");
        }
	}
	public boolean textFiledIsNull() {
		return ("").equals(bookno) || ("").equals(bookname) || ("").equals(author) || ("").equals(press) || ("").equals(price) || ("").equals(publishdate) || ("").equals(shopnum);
	}
	public boolean checkShopNum() {
		String sql;
		String subshopnum;
		sql = "select �������-�ڿ����� from view_book where ͼ����=?";
		if((subshopnum = BookDBCon.preparedqueryResult(sql, bookno)) != null) {
			return Integer.parseInt(shopnum)>=Integer.parseInt(subshopnum);
		} else return Integer.parseInt(shopnum)>=0;
	}
}
