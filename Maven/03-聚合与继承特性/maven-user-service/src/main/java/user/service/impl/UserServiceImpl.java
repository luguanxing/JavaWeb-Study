package user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dao.UserDao;
import user.entity.User;
import user.service.UserService;

/**
 * 用户Service实现类
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User login(User user) {
		return userDao.login(user);
	}

}
