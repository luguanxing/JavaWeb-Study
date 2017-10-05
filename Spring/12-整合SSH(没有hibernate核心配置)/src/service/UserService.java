package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.User;

@Component(value="userService")
@Transactional
public class UserService {

	@Resource(name="userDao")
	UserDao dao;
	
	public void add(User user) {
		System.out.println("Service->add");
		dao.add(user);
	}

	public User get(int i) {
		System.out.println("Service->get");
		return dao.get(i);
	}

	public void find() {
		dao.find();
	}
	
}
