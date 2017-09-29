package anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {

	//�Զ�ע��,����Ҫset����
	@Autowired
	private UserDao dao1;
	
	//�ֶ�ע��,��Ҫָ����ע�����,����Ҫset����
	@Resource(name="userDao")
	private UserDao dao2;
	
	public void add() {
		System.out.println("UserService->add");
		dao1.add();
		dao2.add();
	}
	
}
