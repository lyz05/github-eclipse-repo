package cc.home999.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.home999.book.bean.Book;
import cc.home999.book.bean.BookAdmin;
import cc.home999.book.bean.Reader;
import cc.home999.book.bean.ReaderAdmin;
import cc.home999.book.model.TableModel;
import cc.home999.book.service.BookAdminService;
import cc.home999.book.service.ReaderAdminService;

@Controller
@RequestMapping("Table")
public class TableController {
	
	@Autowired
	BookAdminService bookAdminService;
	@Autowired
	ReaderAdminService readerAdminService;
	
	/** 获取图书Table
	 * 
	 * @param book
	 * @return
	 */
	@RequestMapping("bookadmins")
	@ResponseBody
	public TableModel bookadmins(Book book) {
		List<BookAdmin> books = bookAdminService.getbooks(book);
		int total = books.size();
		return new TableModel(total,books);
	}
	
	/** 获取读者Table
	 * 
	 * @param Reader
	 * @return
	 */
	@RequestMapping("readeradmins")
	@ResponseBody
	public TableModel Readeradmins(Reader reader) {
		List<ReaderAdmin> readers = readerAdminService.getreaders(reader);
		int total = readers.size();
		return new TableModel(total,readers);
	}
}
