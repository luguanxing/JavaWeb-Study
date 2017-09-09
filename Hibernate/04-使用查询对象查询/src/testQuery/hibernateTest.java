package testQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import entity.User;
import utils.hibernateUtils;

public class hibernateTest {
	
	@Test
	public void testQuery() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//ʹ��Query�����ѯ����ѯ�����HQL��䣬����List
			Query query = session.createQuery("from User");
			List list = query.list();
			for (Object object : list) {
				System.out.println(object);
			}
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
	public void testCriteria() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//ʹ��Criteria�����ѯ������д��ѯ��䣬����List
			Criteria criteria = session.createCriteria(User.class);
			List list = criteria.list();
			for (Object object : list) {
				System.out.println(object);
			}
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
	public void testSQLQuery() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//ʹ��SQLQuery�����ѯ��д��ͨ�Ĳ�ѯ���
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			List<Object[]> list = sqlQuery.list();	//ֱ����list()���ص�ÿ������������
			for (Object[] object : list) {
				System.out.println(Arrays.toString(object));
			}
			sqlQuery.addEntity(User.class);			//addEntity��������ΪUser�󷵻�User��
			 list = sqlQuery.list();
			for (Object object : list) {
				System.out.println(object);
			}
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
