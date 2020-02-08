package cc.home999.book.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Reader {
	
	@NotBlank(message = "读者号不能为空")
    private String readerno;

	@NotBlank(message = "姓名不能为空")
    private String readername;

	@NotBlank(message = "性别不能为空")
    private String sex;

	@NotBlank(message = "身份证号不能为空")
	@Size(min = 18,max = 18, message = "身份证号填写有误")
    private String identitycard;

	@NotBlank(message = "工作单位不能为空")
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

	@Override
	public String toString() {
		return "Reader [readerno=" + readerno + ", readername=" + readername + ", sex=" + sex + ", identitycard="
				+ identitycard + ", workunit=" + workunit + "]";
	}
    
}