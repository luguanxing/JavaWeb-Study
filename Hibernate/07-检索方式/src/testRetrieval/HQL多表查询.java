package testRetrieval;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Father;
import entity.Son;
import utils.hibernateUtils;

public class HQL����ѯ {

	@Test	//������,��������
	public void testInnerJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f INNER JOIN f.sons");
			List list = query.list();
			for (Object object : list) {
				//���ص���������ʽ
				Father father = (Father) ((Object[]) object)[0];
				Son son = (Son) ((Object[]) object)[1];
				System.out.println(father.getFatherName() + " -> " + son.getSon_name());
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
	
	@Test	//����������,�������
	public void testFetchInnerJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f INNER JOIN FETCH f.sons");
			List list = query.list();
			for (Object object : list) {
				//���ص��Ƕ�����ʽ(ֻ������)
				Father father = (Father) object;
				System.out.println(father.getFid() + " -> " + father.getFatherName());
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
	
	@Test	//��������
	public void testLeftOuterJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f LEFT OUTER JOIN f.sons");
			List list = query.list();
			for (Object object : list) {
				//���ص���������ʽ
				Father father = (Father) ((Object[]) object)[0];
				Son son = (Son) ((Object[]) object)[1];
				if (son != null) {
					System.out.println(father.getFatherName() + " -> " + son.getSon_name());
				} else {
					System.out.println(father.getFatherName() + " ->  null");
				}
				
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
	
	@Test	//������������
	public void testFetchLeftOuterJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f LEFT OUTER JOIN FETCH f.sons");
			List list = query.list();
			for (Object object : list) {
				//���ص��Ƕ�����ʽ(ֻ������)
				Father father = (Father) object;
				System.out.println(father.getFid() + " -> " + father.getFatherName());
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
	
	@Test	//��������
	public void testRightOuterJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f RIGHT OUTER JOIN f.sons");
			List list = query.list();
			for (Object object : list) {
				//���ص���������ʽ
				Father father = (Father) ((Object[]) object)[0];
				Son son = (Son) ((Object[]) object)[1];
				if (father != null) {
					System.out.println(father.getFatherName() + " -> " + son.getSon_name());
				} else {
					System.out.println("null -> " + son.getSon_name());
				}
				
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
