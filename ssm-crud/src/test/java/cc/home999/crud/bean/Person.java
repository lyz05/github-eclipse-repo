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

	public Person(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
		System.out.println("有参构造器被调用");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + "]";
	}

	public Person() {
		super();
		System.out.println("person创建");
	}
	
}
