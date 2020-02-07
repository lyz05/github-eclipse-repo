package cc.home999.book.bean;

import java.util.Date;

public class BorrowReader {
    private String readerno;

    private String readername;

    private String bookno;

    private String bookname;

    private String author;

    private String press;

    private Date borrowdate;

    private Date shoulddate;

    private Date returndate;

    public String getReaderno() {
        return readerno;
    }

    public void setReaderno(String readerno) {
        this.readerno = readerno == null ? null : readerno.trim();
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername == null ? null : readername.trim();
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

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public Date getShoulddate() {
        return shoulddate;
    }

    public void setShoulddate(Date shoulddate) {
        this.shoulddate = shoulddate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }
}