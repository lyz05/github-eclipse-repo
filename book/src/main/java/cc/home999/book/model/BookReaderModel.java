package cc.home999.book.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cc.home999.book.bean.Book;

public class BookReaderModel extends Book{
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishdate_1;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishdate_2;
	private boolean check;
	
	
	@Override
	public String toString() {
		return "BookReaderModel [publishdate_1=" + publishdate_1 + ", publishdate_2=" + publishdate_2 + ", check="
				+ check + ", toString()=" + super.toString() + "]";
	}
	public Date getPublishdate_1() {
		return publishdate_1;
	}
	public void setPublishdate_1(Date publishdate_1) {
		this.publishdate_1 = publishdate_1;
	}
	public Date getPublishdate_2() {
		return publishdate_2;
	}
	public void setPublishdate_2(Date publishdate_2) {
		this.publishdate_2 = publishdate_2;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
}
