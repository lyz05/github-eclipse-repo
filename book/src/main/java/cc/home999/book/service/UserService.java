package cc.home999.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.bean.User;
import cc.home999.book.dao.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	/**
	 * 判断用户名密码是否正确
	 * @return 正确返回完整用户信息，错误返回null
	 */
	public User judgeUser(User user) {
		User retUser = userMapper.selectByPrimaryKey(user.getUsername());
		retUser.setLocale(user.getLocale());
		if (retUser.getPassword().equals(user.getPassword()))
			return retUser;
		else return null;
	}
	
	/**
	 * 更新用户数据
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user) {
		// TODO 自动生成的方法存根
		int count = userMapper.updateByPrimaryKey(user);
		return count==1;
	}
	
	/** 添加用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
		int count = userMapper.insert(user);
		return count==1;
	}

	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	public boolean deluser(String username) {
		// TODO 自动生成的方法存根
		int count = userMapper.deleteByPrimaryKey(username);
		return count==1;
	}
}
