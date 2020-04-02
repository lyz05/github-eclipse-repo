package cc.home999.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;

import cc.home999.book.bean.User;
import cc.home999.book.model.AlterPasswordModel;
import cc.home999.book.model.Msg;
import cc.home999.book.model.UserInfoModel;
import cc.home999.book.service.ReaderService;
import cc.home999.book.service.UserService;

@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ReaderService readerService;
	
	@RequestMapping("login")
	@ResponseBody
	public Msg login(User user,HttpSession session) {
		User retUser = userService.judgeUser(user);
		session.setAttribute("user", retUser);
		if (retUser!=null) {
			if (retUser.getRole().equals("reader")) 
				return new Msg(603,"读者登录成功");
			else
				return new Msg(604,"管理员登录成功");
		} else {
			return Msg.fail("用户名或密码错误");
		}
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public Msg logout(HttpSession session) {
		session.setAttribute("user", null);
		return new Msg(605,"注销操作完成");
	}
	
	@RequestMapping("psdalter")
	@ResponseBody
	public Msg psdalter(AlterPasswordModel info) {
		if (!info.confirmnewpwd()) {
			return Msg.fail("两次输入的新密码不一致");
		}
		if (!info.confirmoldandnewpwd()) {
			return Msg.fail("旧密码与新密码相同");
		}
		User user = new User(info.getUsername(), info.getPwd());
		user =  userService.judgeUser(user);
		if (user!=null) {
			user.setPassword(info.getNewpwd());
			if (userService.updateUser(user)) {
				return Msg.success("更新密码成功");
			} else {
				return Msg.fail("更新密码失败");
			}
		} else return Msg.fail("用户名或密码错误");
	}
	
	@RequestMapping("userinfo")
	@ResponseBody
	public UserInfoModel userinfo(HttpSession session) {
		User user = (User)session.getAttribute("user");
		String username = user.getUsername();
		String readername = null;
		if (user.getRole().equals("reader")) {
			readername = readerService.getReadername(user.getUsername());
		}
		return new UserInfoModel(username, readername);
	}
	
	@RequestMapping("resetpwd")
	@ResponseBody
	public Msg resetpwd(HttpSession session,String readerno) {
		User user = (User)session.getAttribute("user");
		if (user.getRole().equals("admin")) {
			User reader = userService.getUser(readerno);
			if (reader!=null && reader.getRole().equals("reader")) {
				reader.setPassword("");
				if (userService.updateUser(reader)) 
					return Msg.success("重置读者密码成功");
				else 
					return Msg.fail("重置读者密码失败");
			} else return Msg.fail("该用户不存在");
		} else return Msg.fail("当前用户无法执行此操作");
	}
}
