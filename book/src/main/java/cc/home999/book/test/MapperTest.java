package cc.home999.book.test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cc.home999.book.bean.Book;
import cc.home999.book.bean.ReaderExample;
import cc.home999.book.bean.ReaderExample.Criteria;
import cc.home999.book.dao.BookMapper;
import cc.home999.book.dao.ReaderMapper;

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
	BookMapper bookmapper;
	
	@Autowired
	ReaderMapper readerMapper;
	
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
		//book集合查询
		List<Book> books = bookmapper.selectByExample(null);
		for (Book book : books) {
			System.out.println(book);
		}
		//book插入
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date date = cal.getTime();
		Book book1 = new Book("456","789","123","100",new BigDecimal(21.23),date,12);
		System.out.println("将要插入：\n"+book1);
		//bookmapper.insertSelective(book1);
		//book根据主键查询
		book1 = bookmapper.selectByPrimaryKey("B200301008");
		//查询用户名密码是否存在
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReadernoEqualTo("R2006002");
		criteria.andPasswordEqualTo("");
		long count = readerMapper.countByExample(example);
		System.out.println(count!=0);
		//模糊查询
	}
}
