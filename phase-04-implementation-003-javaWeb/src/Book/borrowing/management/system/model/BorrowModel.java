package Book.borrowing.management.system.model;

import Book.borrowing.management.system.BookDBCon;

//借阅信息
public class BorrowModel {
	public String bookno,bookname,author,press,borrowdate,shoulddate,returndate;
	private String readerno,language;
	public BorrowModel(String bookno,String bookname,String author,String press,String borrowdate,String shoulddate,String returndate) {
		this.bookno=bookno;
		this.bookname=bookname;
		this.author=author;
		this.press=press;
		this.borrowdate=borrowdate;
		this.shoulddate=shoulddate;
		this.returndate=returndate;
	}
	//借阅操作构造函数
	public BorrowModel(String bookno,String readerno) {
		this.bookno=bookno;
		this.readerno=readerno;
	}
	public Msg add() {
		String sql = "insert Borrow values(?,?,now(),date_add(NOW(),interval 1 MONTH),null)";
		if (Integer.parseInt(BookDBCon.preparedqueryResult("select 在库数量 from View_Book where 图书编号=?",bookno)) <= 0) {
            return new Msg("403","booknull",language);
        }
        if (BookDBCon.preparedqueryResult("select readerNO from Borrow where readerNO=? and bookNO=? and returnDate is null",readerno,bookno) != null){
            return new Msg("403","youhaveborrow",language);
        }
		if(BookDBCon.preparedupdateData(sql,readerno,bookno)) {
			return new Msg("200","borrowbookok",language);
		} else {
			return new Msg("403","borrowbookfail",language);
		}
	}
	public Msg renew() {
		String sql = "update Borrow set shouldDate=date_add(NOW(), interval 1 MONTH) where readerNO=? and bookNO=? and returnDate is null";

		if(BookDBCon.preparedupdateData(sql,readerno,bookno)) {
			return new Msg("200","renewbookok",language);
		} else {
			return new Msg("403","renewbookok",language);
		}
	}
	public Msg ret() {

		String sql = "update Borrow set returnDate=now() where readerNO=? and bookNO=? and returnDate is null";
		
		if(BookDBCon.preparedupdateData(sql,readerno,bookno)) {
			return new Msg("200","returnbookok",language);
		} else {
			return new Msg("403","returnbookfail",language);
		}
	}
	public void setlanguage(String language) {
		this.language = language;
	}
}
