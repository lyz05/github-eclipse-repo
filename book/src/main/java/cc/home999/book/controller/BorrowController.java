package cc.home999.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.home999.book.bean.BookAdmin;
import cc.home999.book.bean.User;
import cc.home999.book.model.Msg;
import cc.home999.book.service.BookAdminService;
import cc.home999.book.service.BorrowService;

@Controller
@RequestMapping("Borrow")
public class BorrowController {
	
	@Autowired
	BorrowService borrowService;
	@Autowired
	BookAdminService bookAdminService;
	
	@RequestMapping(value = "{bookno}",method = RequestMethod.POST)
	@ResponseBody
	public Msg addborrow(@PathVariable String bookno,HttpSession session) {
		User user = (User) session.getAttribute("user");	
		String readerno = user.getUsername();
		BookAdmin book = bookAdminService.getbook(bookno);
		if (book.getCurnum()<=0) {
			return Msg.fail("这本书已经被借光了");
		}
		if (borrowService.haveBorrow(bookno, readerno)) {
			return Msg.fail("这本书你已经借过了");
		}
		if (borrowService.addBorrow(bookno,readerno)) {
			return Msg.success("借书成功");
		} else {
			return Msg.fail("借书失败");
		}
	}
	
	@RequestMapping(value = "{bookno}",method = RequestMethod.DELETE)
	@ResponseBody
	public Msg retborrow(@PathVariable String bookno,HttpSession session) {
		User user = (User) session.getAttribute("user");
		String readerno = user.getUsername();
		if (borrowService.retBorrow(bookno,readerno)) {
			return Msg.success("还书成功");
		} else {
			return Msg.fail("还书失败");
		}
	}
	
	@RequestMapping(value = "{bookno}",method = RequestMethod.PUT)
	@ResponseBody
	public Msg renewborrow(@PathVariable String bookno,HttpSession session) {
		User user = (User) session.getAttribute("user");
		String readerno = user.getUsername();
		if (borrowService.renewBorrow(bookno,readerno)) {
			return Msg.success("续借成功");
		} else {
			return Msg.fail("续借失败");
		}
	}
}