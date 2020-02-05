package cc.home999.crud.bean;

public class Person {
	String name;
	String sex;
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + "]";
	}
	
}
