package cc.home999.crud.test;

import org.junit.jupiter.api.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.home999.crud.bean.Person;

class IOCTest {
	
	private ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
	/**
	 * 从容器中拿到这个组件
	 * 存在几个问题
	 * 1).src，源码包开始的路径，称为类路径的开始；
	 * 2).Spring容器接管了标志了s的类
	 */
	@Test
	void test() {
		//ApplicationContext;代表ioc容器
		//使用spring的配置文件得到ioc容器的对象
		
		Person bean = ioc.getBean("person03",Person.class);
		System.out.println(bean);
	}

}
 