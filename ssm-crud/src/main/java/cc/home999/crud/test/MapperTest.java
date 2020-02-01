package cc.home999.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cc.home999.crud.bean.Employee;
import cc.home999.crud.dao.DepartmentMapper;
import cc.home999.crud.dao.EmployeeMapper;

/**
 * 测试dao层的功能
 * @author congcong
 * 推荐spring的项目就可以使用spring的单元测试，可以自动注入我们需要的组件
 * 导入SpringTest模块
 * 指定Spring配置文件的配置
 * 直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD() {
		/*
		 * //创建springIOC容器 ClassPathXmlApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //从容器中获取mapper
		 * DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		 */
		System.out.println(departmentMapper);
		//插入几个部门
		//departmentMapper.insertSelective(new Department(null,"开发部"));
		//departmentMapper.insertSelective(new Department(null,"测试部"));
		//测试员工表插入
		//employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@atguigu.com",1));
		//批量插入多个员工；批量，使用可以执行批量操作的sqlSession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		/*
		 * for () { employeeMapper.insertSelective(record) }
		 */
		for (int i=0;i<1000;i ++) {
			String uuid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@atguigu.com",1));
		}
		System.out.println("批量生成完成");
	}
}
