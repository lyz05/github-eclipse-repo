package cc.home999.book.bean;

public class Reader {
    private String readerno;

    private String readername;

    private String sex;

    private String identitycard;

    private String workunit;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard == null ? null : identitycard.trim();
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit == null ? null : workunit.trim();
    }
}