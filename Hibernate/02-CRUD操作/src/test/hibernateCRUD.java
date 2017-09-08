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
		//��Ӳ���
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
		//��ѯ����
		User user = session.get(User.class, 1);
		System.out.println(user);
		ts.commit();
		session.close();
	}
	
	@Test
	public void testUpdate() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		//�޸Ĳ���:ע��Ҫ�Ȳ��ٸģ�������ܻ���©�������Ա�����ΪNULL
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
		//ɾ������:ע��Ҫ�Ȳ���ɾ
		User user = session.get(User.class,5);
		session.delete(user);
		/*
		 * 	������:
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
		//SaveOrUpdate���������
		User adduser = new User();
		adduser.setUsername("new Name");
		adduser.setPassword("998");
		adduser.setAddress("Խ��");
		session.saveOrUpdate(adduser);
		//SaveOrUpdate�������޸�
		User updateuser = session.get(User.class, 3);
		updateuser.setAddress("korea");
		session.saveOrUpdate(adduser);
		ts.commit();
		session.close();
	}
	
}
