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
		
		//����1��ʹ��set��ŵ�root(������¿ռ�)
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		vs.set("param_set", "param_set_value");
		
		//����2��ʹ��push��ŵ�context(������¿ռ�)
		vs.push("param_push_value");
		
		//�﷽��3�������������(�᲻�����¿ռ�)
		user.setUsername("����");
		user.setPassword("�ʷ�");
		
		User user1 = new User();
		User user2 = new User();
		user1.setUsername("��1");
		user1.setPassword("��1");
		user2.setUsername("��2");
		user2.setPassword("��2");
		list.add(user1);
		list.add(user2);
		
		return "success";
	}
	
}
