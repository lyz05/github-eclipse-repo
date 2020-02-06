package cc.home999.book.bean;

import java.util.Date;

public class View_Book {
    private String 图书编号;

    private String 图书名称;

    private String 作者;

    private String 出版社;

    private Date 出版日期;

    private Integer 入库数量;

    private Long 在库数量;

    public String get图书编号() {
        return 图书编号;
    }

    public void set图书编号(String 图书编号) {
        this.图书编号 = 图书编号 == null ? null : 图书编号.trim();
    }

    public String get图书名称() {
        return 图书名称;
    }

    public void set图书名称(String 图书名称) {
        this.图书名称 = 图书名称 == null ? null : 图书名称.trim();
    }

    public String get作者() {
        return 作者;
    }

    public void set作者(String 作者) {
        this.作者 = 作者 == null ? null : 作者.trim();
    }

    public String get出版社() {
        return 出版社;
    }

    public void set出版社(String 出版社) {
        this.出版社 = 出版社 == null ? null : 出版社.trim();
    }

    public Date get出版日期() {
        return 出版日期;
    }

    public void set出版日期(Date 出版日期) {
        this.出版日期 = 出版日期;
    }

    public Integer get入库数量() {
        return 入库数量;
    }

    public void set入库数量(Integer 入库数量) {
        this.入库数量 = 入库数量;
    }

    public Long get在库数量() {
        return 在库数量;
    }

    public void set在库数量(Long 在库数量) {
        this.在库数量 = 在库数量;
    }
}