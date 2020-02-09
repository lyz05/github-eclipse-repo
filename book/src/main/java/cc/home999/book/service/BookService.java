package cc.home999.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.bean.Book;
import cc.home999.book.dao.BookMapper;

@Service
public class BookService {
	
	@Autowired
	BookMapper bookMapper;
	public boolean updatebook(Book book) {
		int count = bookMapper.updateByPrimaryKey(book);
		return count==1 || count==0;
	}
	
	public Book getbook(String bookno){
		return bookMapper.selectByPrimaryKey(bookno);
	}
	
	public boolean addbook(Book book) {
		int count = bookMapper.insert(book);
		return count==1;
	}

	public boolean delbook(String bookno) {
		// TODO 自动生成的方法存根
		int count = bookMapper.deleteByPrimaryKey(bookno);
		return count==1;
	}
}
