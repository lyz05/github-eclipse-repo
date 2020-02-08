package cc.home999.book.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {
	
	@NotBlank(message = "图书编号不能为空")
    private String bookno;

	@NotBlank(message = "图书名称不能为空")
    private String bookname;

	@NotBlank(message = "作者不能为空")
    private String author;

	@NotBlank(message = "出版社不能为空")
    private String press;
	
	@NotNull(message = "价格不能为空")
	@DecimalMin(value = "0",message = "价格必须大于等于0")
    private BigDecimal price;

	@NotNull(message = "出版日期不能为空")
	@Past(message = "出版日期不能在今日以后")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date publishdate;

	@NotNull(message = "入库数量不能为空")
	@DecimalMin(value = "0",message = "入库数量必须大于等于0")
    private Integer shopnum;

    @Override
	public String toString() {
		return "Book [bookno=" + bookno + ", bookname=" + bookname + ", author=" + author + ", press=" + press
				+ ", price=" + price + ", publishdate=" + publishdate + ", shopnum=" + shopnum + "]";
	}

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

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getShopnum() {
        return shopnum;
    }

    public void setShopnum(Integer shopnum) {
        this.shopnum = shopnum;
    }
}