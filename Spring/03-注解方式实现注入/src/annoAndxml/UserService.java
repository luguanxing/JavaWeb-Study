package annoAndxml;

import javax.annotation.Resource;

public class UserService {

	@Resource(name="userDao")
	private UserDao dao;
	
	public void add() {
		System.out.println("UserService->add");
		dao.add();
	}
	
}
