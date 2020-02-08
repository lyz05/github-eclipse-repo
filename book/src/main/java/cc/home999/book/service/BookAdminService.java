package cc.home999.book.service;
import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.bean.Book;
import cc.home999.book.bean.BookAdmin;
import cc.home999.book.bean.BookAdminExample;
import cc.home999.book.bean.BookAdminExample.Criteria;
import cc.home999.book.dao.BookAdminMapper;

@Service
public class BookAdminService {

	@Autowired
	BookAdminMapper bookAdminMapper;
	
	public List<BookAdmin> getbooks(Book book) {
		// TODO 自动生成的方法存根
		BookAdminExample example = new BookAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andBooknoLike("%"+book.getBookno()+"%");
		criteria.andBooknameLike("%"+book.getBookname()+"%");
		criteria.andAuthorLike("%"+book.getAuthor()+"%");
		criteria.andPressLike("%"+book.getPress()+"%");
		return bookAdminMapper.selectByExample(example);
	}
	public BookAdmin getbook(String bookno){
		BookAdminExample example = new BookAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andBooknoEqualTo(bookno);
		List<BookAdmin> bookAdmins = bookAdminMapper.selectByExample(example);
		if (bookAdmins.size()==1) return bookAdmins.get(0); else return null; 
	}
}
