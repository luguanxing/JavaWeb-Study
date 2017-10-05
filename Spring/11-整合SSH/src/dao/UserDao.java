package dao;

import entity.User;

public interface UserDao {

	void add(User user);

	User get(int i);

	void find();

}
