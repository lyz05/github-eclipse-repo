package cc.home999.book.bean;

import java.util.Date;

public class Borrow {
    private String readerno;

    private String bookno;

    private Date borrowdate;

    private Date shoulddate;

    private Date returndate;

    public String getReaderno() {
        return readerno;
    }

    public void setReaderno(String readerno) {
        this.readerno = readerno == null ? null : readerno.trim();
    }

    public String getBookno() {
        return bookno;
    }

    public void setBookno(String bookno) {
        this.bookno = bookno == null ? null : bookno.trim();
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