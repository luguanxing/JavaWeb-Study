package c3p0;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void add() {
		System.out.println("Service->add");
		userDao.add();
	}

}
