package cc.home999.book.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import cc.home999.book.bean.Reader;
import cc.home999.book.bean.User;
import cc.home999.book.model.Msg;
import cc.home999.book.service.ReaderAdminService;
import cc.home999.book.service.ReaderService;
import cc.home999.book.service.UserService;

@RestController
@RequestMapping("Reader")
public class ReaderController {

	@Autowired
	ReaderAdminService readerAdminService;
	@Autowired
	ReaderService readerService;
	@Autowired
	UserService userService;
	
	/** 获取读者
	 * 
	 * @param readerno
	 * @return
	 */
	@RequestMapping(value="{readerno}",method = RequestMethod.GET)
	public Object getreader(@PathVariable("readerno") String readerno){
		Reader reader = readerService.getreader(readerno);
		if (reader==null) return Msg.fail("未找到这位读者");
		else return reader;
	}
	
	/** 读者添加
	 * 支持JSR303校验
	 * @param reader
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Msg addreader(@Valid Reader reader,BindingResult result) {
		//传入字段检查
		if (result.hasErrors()) {
			FieldError fieldError = result.getFieldError();
			return Msg.fail(fieldError.getDefaultMessage());
		}
		if (!(reader.getSex().equals("男") || reader.getSex().equals("女"))) {
			return Msg.fail("性别字段非法");
		}
		User user = new User(reader.getReaderno(),"","reader");
		if (userService.addUser(user) && readerService.addreader(reader)) {
			return Msg.success("添加读者成功");
		} else {
			return Msg.fail("添加读者失败");
		}
	}
	
	/**
	 * 读者编辑
	 * @param reader
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Msg editreader(@Valid Reader reader,BindingResult result) {
		//传入字段检查
		if (result.hasErrors()) {
			FieldError fieldError = result.getFieldError();
			return Msg.fail(fieldError.getDefaultMessage());
		}
		if (!(reader.getSex().equals("男") || reader.getSex().equals("女"))) {
			return Msg.fail("性别字段非法");
		}
		if (readerService.updatereader(reader)) {
			return Msg.success("修改读者成功");
		} else {
			return Msg.fail("修改读者失败");
		}
	}
	
	/**
	 * 读者删除
	 * @param readerno
	 * @return
	 */
	@RequestMapping(value = "{readerno}",method = RequestMethod.DELETE)
	public Msg delreader(@PathVariable("readerno") String readerno) {
		//级联删除
		if (userService.deluser(readerno)) {
			return Msg.success("删除读者成功");
		} else return Msg.fail("删除读者失败");
	}
}
