package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import entity.User;
import utils.hibernateUtils;

public class hibernateTest {

	@Test
	public void testAdd() {
//		��һ�� ����hibernate���������ļ�
		//Configuration cfg = new Configuration().configure();
		
//		�ڶ��� ����SessionFactory���󣬼���ӳ��
		//SessionFactory factory = cfg.buildSessionFactory();
		
//		������ ʹ��SessionFactory����session����(Ҳ��ʹ�ù�����)
		//Session session = factory.openSession();
		Session session = hibernateUtils.getSession();
		
//		���Ĳ� ��������
		Transaction ts = session.beginTransaction();

//		���岽 д�����߼� crud����
		User user = new User();
		user.setUsername("lalala");
		user.setPassword("hahaha");
		user.setAddress("China");
		session.save(user);
		
//		������ �ύ����
		ts.commit();

//		���߲� �ر���Դ
		session.close();
		//factory.close();

	}
	
}
