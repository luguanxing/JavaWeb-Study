package dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import entity.User;

@Component(value="userDao")
public class UserDaoImpl implements UserDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void add(User user) {
		System.out.println("Dao->add");
		hibernateTemplate.save(user);
	}

	@Override
	public User get(int i) {
		System.out.println("Dao->get");
		return hibernateTemplate.get(User.class, i);
	}

	@Override
	public void find() {
		System.out.println("Dao->find");
		//查询所有
		List<User> list = (List<User>) hibernateTemplate.find("FROM User");
		for (User user : list) {
			System.out.println(user);
		}
		
		System.out.println("============");
		//条件查询
		List<User> list2 = (List<User>) hibernateTemplate.find("FROM User WHERE username = ?", "ssh_test");
		for (User user : list2) {
			System.out.println(user);
		}
	}

}
