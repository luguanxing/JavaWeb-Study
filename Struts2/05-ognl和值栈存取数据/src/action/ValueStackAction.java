package action;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import entity.User;

public class ValueStackAction extends ActionSupport {

	private User user = new User();
	private List<User> list = new LinkedList<User>();
	
	public User getUser() {
		return user;
	}

	public List<User> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		
		//方法1：使用set存放到root(会分配新空间)
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		vs.set("param_set", "param_set_value");
		
		//方法2：使用push存放到context(会分配新空间)
		vs.push("param_push_value");
		
		//★方法3：对象变量方法(会不分配新空间)
		user.setUsername("肥猪");
		user.setPassword("肥肥");
		
		User user1 = new User();
		User user2 = new User();
		user1.setUsername("肥1");
		user1.setPassword("猪1");
		user2.setUsername("肥2");
		user2.setPassword("猪2");
		list.add(user1);
		list.add(user2);
		
		return "success";
	}
	
}
