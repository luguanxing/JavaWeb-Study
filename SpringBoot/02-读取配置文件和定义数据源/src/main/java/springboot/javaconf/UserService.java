package springboot.javaconf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO; // 注入Spring容器中的bean对象(由SpringConfig里的Bean方法提供)

	public List<User> queryUserList() {
		// 调用userDAO中的方法进行查询
		return this.userDAO.queryUserList();
	}

}
