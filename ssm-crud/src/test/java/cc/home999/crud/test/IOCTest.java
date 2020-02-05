package cc.home999.crud.test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.catalina.core.ApplicationContext;
import org.aspectj.weaver.tools.cache.CachedClassEntry;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.home999.crud.bean.Person;

class IOCTest {

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
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
		Person bean = (Person)ioc.getBean("person");
		System.out.println(bean);
	}

}
 