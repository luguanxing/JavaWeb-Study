package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import entity.User;
import utils.hibernateUtils;

public class hibernateCRUD {

	@Test
	public void testAdd() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		//添加操作
		User user = new User();
		user.setUsername("testName");
		user.setPassword("666");
		user.setAddress("earth");
		session.save(user);
		ts.commit();
		session.close();
	}
	
	@Test
	public void testGet() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		//查询操作
		User user = session.get(User.class, 1);
		System.out.println(user);
		ts.commit();
		session.close();
	}
	
	@Test
	public void testUpdate() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		//修改操作:注意要先查再改，否则可能会有漏掉的属性被设置为NULL
		User user = session.get(User.class,2);
		user.setAddress("USA");
		user.setPassword("USA");
		System.out.println(user);
		session.update(user);
		ts.commit();
		session.close();
	}
	
	@Test
	public void testDelete() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		//删除操作:注意要先查再删
		User user = session.get(User.class,5);
		session.delete(user);
		/*
		 * 	方法二:
		 * 	User user = new User();
		 * 	user.setUid(5);
		 *
		 */
		ts.commit();
		session.close();
	}
	
	@Test
	public void testSaveOrUpdate() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		//SaveOrUpdate操作：添加
		User adduser = new User();
		adduser.setUsername("new Name");
		adduser.setPassword("998");
		adduser.setAddress("越南");
		session.saveOrUpdate(adduser);
		//SaveOrUpdate操作：修改
		User updateuser = session.get(User.class, 3);
		updateuser.setAddress("korea");
		session.saveOrUpdate(adduser);
		ts.commit();
		session.close();
	}
	
}
