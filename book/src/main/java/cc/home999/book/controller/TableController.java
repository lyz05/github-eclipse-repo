package cc.home999.book.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.home999.book.bean.Book;
import cc.home999.book.bean.BookAdmin;
import cc.home999.book.bean.BookReader;
import cc.home999.book.bean.BorrowReader;
import cc.home999.book.bean.Reader;
import cc.home999.book.bean.ReaderAdmin;
import cc.home999.book.bean.User;
import cc.home999.book.model.BookReaderModel;
import cc.home999.book.model.TableModel;
import cc.home999.book.service.BookAdminService;
import cc.home999.book.service.BookReaderService;
import cc.home999.book.service.BorrowReaderService;
import cc.home999.book.service.ReaderAdminService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Table")
public class TableController {
	
	@Autowired
	BookAdminService bookAdminService;
	@Autowired
	ReaderAdminService readerAdminService;
	@Autowired
	BorrowReaderService borrowReaderService;
	@Autowired
	BookReaderService bookReaderService;
	
	/** 获取图书Table
	 * 
	 * @param book
	 * @return
	 */
	@RequestMapping("bookadmins")
	public TableModel bookadmins(Book book) {
		List<BookAdmin> books = bookAdminService.getbooks(book);
		int total = books.size();
		return new TableModel(total,books);
	}
	
	/** 获取读者Table
	 * 
	 * @param reader
	 * @return
	 */
	@RequestMapping("readeradmins")
	public TableModel Readeradmins(Reader reader) {
		List<ReaderAdmin> readers = readerAdminService.getreaders(reader);
		int total = readers.size();
		return new TableModel(total,readers);
	}
	
	/** 获取读者借阅信息Table
	 * 
	 * @param table
	 * @return
	 */
	@RequestMapping("borrowreaders")
	public TableModel borrowreaders(String table,HttpSession session) {
		User user = (User)session.getAttribute("user");
		boolean isnull = table.equals("Borrow");
		List<BorrowReader> borrowReaders = borrowReaderService.getborrowReaders(user.getUsername(),isnull);
		int total = borrowReaders.size();
		return new TableModel(total,borrowReaders);
	}
	
	/** 获取读者看到的图书Table
	 * 
	 * @param book
	 * @return
	 */
	@RequestMapping("bookreaders")
	public TableModel bookreaders(BookReaderModel book,HttpSession session) {
		//System.out.println(book);
		User user = (User) session.getAttribute("user");
		List<String> booknos = borrowReaderService.getbooknosnotreturn(user.getUsername());
		List<BookReader> rows = bookReaderService.getbookreaders(book,booknos);
		int total = rows.size();
		return new TableModel(total, rows);
	}
}
