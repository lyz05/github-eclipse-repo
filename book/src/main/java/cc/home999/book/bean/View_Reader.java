package cc.home999.book.bean;

public class View_Reader {
    private String 读者编号;

    private String 姓名;

    private String 性别;

    private String 身份证号;

    private String 工作单位;

    private Long 总借书数量;

    private Long 未归还数量;

    public String get读者编号() {
        return 读者编号;
    }

    public void set读者编号(String 读者编号) {
        this.读者编号 = 读者编号 == null ? null : 读者编号.trim();
    }

    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名 == null ? null : 姓名.trim();
    }

    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别 == null ? null : 性别.trim();
    }

    public String get身份证号() {
        return 身份证号;
    }

    public void set身份证号(String 身份证号) {
        this.身份证号 = 身份证号 == null ? null : 身份证号.trim();
    }

    public String get工作单位() {
        return 工作单位;
    }

    public void set工作单位(String 工作单位) {
        this.工作单位 = 工作单位 == null ? null : 工作单位.trim();
    }

    public Long get总借书数量() {
        return 总借书数量;
    }

    public void set总借书数量(Long 总借书数量) {
        this.总借书数量 = 总借书数量;
    }

    public Long get未归还数量() {
        return 未归还数量;
    }

    public void set未归还数量(Long 未归还数量) {
        this.未归还数量 = 未归还数量;
    }
}