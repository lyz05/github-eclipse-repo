package cc.home999.book.controller;

import cc.home999.book.bean.Book;
import cc.home999.book.bean.BookAdmin;
import cc.home999.book.model.Msg;
import cc.home999.book.model.TableModel;
import cc.home999.book.service.BookAdminService;
import cc.home999.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Books")
public class BooksController {

	@Autowired
	BookAdminService bookAdminService;
	@Autowired
	BookService bookService;

	/** 获取所有图书
	 *
	 * @param book
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public TableModel getbooks(Book book) {
		List<BookAdmin> books = bookAdminService.getbooks(book);
		int total = books.size();
		return new TableModel(total,books);
	}

	/** 获取图书
	 * 
	 * @param bookno
	 * @return
	 */
	@RequestMapping(value="{bookno}",method = RequestMethod.GET)
	public Object getbook(@PathVariable("bookno") String bookno){
		Book book = bookService.getbook(bookno);
		if (book==null) return Msg.fail("未找到这本书");
		else return book;
	}
	
	/** 图书添加
	 * 支持JSR303校验
	 * @param book
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Msg addbook(@Valid Book book,BindingResult result) {
		//传入字段检查
		if (result.hasErrors()) {
			FieldError fieldError = result.getFieldError();
			System.out.println(fieldError);
			System.out.println(fieldError.getField());
			System.out.println(fieldError.getRejectedValue());
			System.out.println(fieldError.isBindingFailure());
			if (fieldError.getField().equals("publishdate") && fieldError.isBindingFailure()){
				return Msg.fail("日期格式错误！请输入正确的日期格式，形如：2000-01-01");
			}
			if (fieldError.getField().equals("shopnum") && fieldError.isBindingFailure()){
				return Msg.fail("入库数量格式错误！请输入数字");
			}
			if (fieldError.getField().equals("price") && fieldError.isBindingFailure()) {
				return Msg.fail("价格格式错误，请输入数字");
			}
			return Msg.fail(fieldError.getDefaultMessage());
		}			
		BookAdmin oldbook = bookAdminService.getbook(book.getBookno());
		if (oldbook != null) {
			return Msg.fail("已经有过一本编号相同的书");
		}
		if (bookService.addbook(book)) {
			return Msg.success("添加书本成功");
		} else {
			return Msg.fail("添加书本失败");
		}
	}
	
	/**
	 * 图书编辑
	 * @param book
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Msg editbook(@Valid Book book,BindingResult result) {
		//传入字段检查
		if (result.hasErrors()) {
			FieldError fieldError = result.getFieldError();
			return Msg.fail(fieldError.getDefaultMessage());
		}
		BookAdmin oldbook = bookAdminService.getbook(book.getBookno());
		if (oldbook == null) { 
			return Msg.fail("该图书编号的书不存在"); 
		}
		if(book.getShopnum()<(oldbook.getShopnum()-oldbook.getCurnum())) { 
			return Msg.fail("在库数量不能小于零");
		}

		if (bookService.updatebook(book)) {
			return Msg.success("修改图书成功");
		} else {
			return Msg.fail("修改图书失败");
		}
	}
	
	/**
	 * 图书删除
	 * @param bookno
	 * @return
	 */
	@RequestMapping(value = "{bookno}",method = RequestMethod.DELETE)
	public Msg delbook(@PathVariable("bookno") String bookno) {
		//级联删除
		if (bookService.delbook(bookno)) {
			return Msg.success("删除书本成功");
		} else return Msg.fail("删除书本失败");
	}
}
