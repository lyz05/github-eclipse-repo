package cc.home999.book.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private String bookno;

    private String bookname;

    private String authorname;

    private String publishingname;

    private BigDecimal price;

    private Date publishingdate;

    private Integer shopnum;

    public String getBookno() {
        return bookno;
    }

    public void setBookno(String bookno) {
        this.bookno = bookno == null ? null : bookno.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname == null ? null : authorname.trim();
    }

    public String getPublishingname() {
        return publishingname;
    }

    public void setPublishingname(String publishingname) {
        this.publishingname = publishingname == null ? null : publishingname.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublishingdate() {
        return publishingdate;
    }

    public void setPublishingdate(Date publishingdate) {
        this.publishingdate = publishingdate;
    }

    public Integer getShopnum() {
        return shopnum;
    }

    public void setShopnum(Integer shopnum) {
        this.shopnum = shopnum;
    }

	@Override
	public String toString() {
		return "Book [bookno=" + bookno + ", bookname=" + bookname + ", authorname=" + authorname + ", publishingname="
				+ publishingname + ", price=" + price + ", publishingdate=" + publishingdate + ", shopnum=" + shopnum
				+ "]";
	}

	public Book(String bookno, String bookname, String authorname, String publishingname, BigDecimal price,
			Date publishingdate, Integer shopnum) {
		super();
		this.bookno = bookno;
		this.bookname = bookname;
		this.authorname = authorname;
		this.publishingname = publishingname;
		this.price = price;
		this.publishingdate = publishingdate;
		this.shopnum = shopnum;
	}

	public Book() {
		super();
	}
	
}