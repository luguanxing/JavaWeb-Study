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
	public void testTx() {
		//����淶
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//��������
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
	public void testCache() {
		//��֤һ������Ĵ���
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			User user1 = session.get(User.class, 1);
			System.out.println(user1);
			User user2 = session.get(User.class, 1);	//�������β�ѯ��ͬuser����ֻ��ѯ��һ�����ݿ�
			System.out.println(user2);
			user1.setPassword("666");	//�־�̬����(�޸ĺ�)�ύ���Զ�����
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
