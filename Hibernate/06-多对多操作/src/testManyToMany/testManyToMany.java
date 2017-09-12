package testManyToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Role;
import entity.User;
import utils.hibernateUtils;

public class testManyToMany {

	@Test
	public void testAdd() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//构造实体
			User user1 = new User();
			user1.setUser_name("lucy");
			user1.setUser_password("123");
			User user2 = new User();
			user2.setUser_name("mary");
			user2.setUser_password("456");
			Role r1 = new Role();
			r1.setRole_name("总经理");
			r1.setRole_memo("总经理");
			Role r2 = new Role();
			r2.setRole_name("秘书");
			r2.setRole_memo("秘书");
			Role r3 = new Role();
			r3.setRole_name("保安");
			r3.setRole_memo("保安");
			
			//建立关系
			// user1 -- r1/r2
			user1.getAsRole().add(r1);
			user1.getAsRole().add(r2);
			// user2 -- r2/r3
			user2.getAsRole().add(r2);
			user2.getAsRole().add(r3);
			
			//保存用户
			session.save(user1);
			session.save(user2);
			
			ts.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	@Test
	public void testDelete() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//先查再删，一般不用，因为也会删掉其它表相关内容
			User user = session.get(User.class, 1);
			session.delete(user);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	@Test
	public void testTableAdd() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			
			//让某个用户有某个角色
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);		
			lucy.getAsRole().add(role);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	@Test
	public void testTableRemove() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			
			//让某个用户去掉某个角色
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);		
			lucy.getAsRole().remove(role);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
