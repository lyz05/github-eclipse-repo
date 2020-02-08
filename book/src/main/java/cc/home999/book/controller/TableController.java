package cc.home999.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.home999.book.bean.Book;
import cc.home999.book.bean.BookAdmin;
import cc.home999.book.model.TableModel;
import cc.home999.book.service.BookAdminService;

@Controller
@RequestMapping("Table")
public class TableController {
	
	@Autowired
	BookAdminService bookAdminService;
	
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
}
