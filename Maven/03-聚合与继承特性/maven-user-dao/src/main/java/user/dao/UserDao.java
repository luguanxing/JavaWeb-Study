package user.dao;

import user.entity.User;

/**
 * 用户DAO接口
 * @author Administrator
 *
 */
public interface UserDao {

	public User login(User user);
	
}
