package cc.home999.book.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.bean.BookReader;
import cc.home999.book.bean.BookReaderExample;
import cc.home999.book.bean.BookReaderExample.Criteria;
import cc.home999.book.dao.BookReaderMapper;
import cc.home999.book.model.BookReaderModel;

@Service
public class BookReaderService {

	@Autowired
	BookReaderMapper bookReaderMapper;
	
	public List<BookReader> getbookreaders(BookReaderModel book, List<String> booknos) {
		BookReaderExample example = new BookReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andBooknoLike("%"+book.getBookno()+"%");
		criteria.andBooknameLike("%"+book.getBookname()+"%");
		criteria.andAuthorLike("%"+book.getAuthor()+"%");
		criteria.andPressLike("%"+book.getPress()+"%");
		Date date_1=book.getPublishdate_1(),date_2=book.getPublishdate_2();
		if (date_1!=null) criteria.andPublishdateGreaterThanOrEqualTo(date_1);
		if (date_2!=null) criteria.andPublishdateLessThanOrEqualTo(date_2);
		if (book.isCheck()) {
			criteria.andCurnumGreaterThan(0L);
			if (booknos.size()!=0) criteria.andBooknoNotIn(booknos);
		}
		return bookReaderMapper.selectByExample(example);
	}
}
