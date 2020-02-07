package cc.home999.book.bean;

import java.math.BigDecimal;
import java.util.Date;

public class BookAdmin {
    private String bookno;

    private String bookname;

    private String author;

    private String press;

    private BigDecimal price;

    private Date publishingdate;

    private Integer shopnum;

    private Long curnum;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
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

    public Long getCurnum() {
        return curnum;
    }

    public void setCurnum(Long curnum) {
        this.curnum = curnum;
    }
}