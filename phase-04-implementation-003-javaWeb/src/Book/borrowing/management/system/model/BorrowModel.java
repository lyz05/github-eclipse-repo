package Book.borrowing.management.system.model;

public class BorrowModel {
	public String bookno,bookname,author,press,borrowdate,shoulddate,returndate;
	public BorrowModel(String bookno,String bookname,String author,String press,String borrowdate,String shoulddate,String returndate) {
		this.bookno=bookno;
		this.bookname=bookname;
		this.author=author;
		this.press=press;
		this.borrowdate=borrowdate;
		this.shoulddate=shoulddate;
		this.returndate=returndate;
	}
}
