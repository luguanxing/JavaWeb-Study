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

public class HQL多表查询 {

	@Test	//内连接,返回数组
	public void testInnerJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f INNER JOIN f.sons");
			List list = query.list();
			for (Object object : list) {
				//返回的是数组形式
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
	
	@Test	//迫切内连接,返左对象
	public void testFetchInnerJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f INNER JOIN FETCH f.sons");
			List list = query.list();
			for (Object object : list) {
				//返回的是对象形式(只有属主)
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
	
	@Test	//左外连接
	public void testLeftOuterJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f LEFT OUTER JOIN f.sons");
			List list = query.list();
			for (Object object : list) {
				//返回的是数组形式
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
	
	@Test	//迫切左外连接
	public void testFetchLeftOuterJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f LEFT OUTER JOIN FETCH f.sons");
			List list = query.list();
			for (Object object : list) {
				//返回的是对象形式(只有属主)
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
	
	@Test	//右外连接
	public void testRightOuterJoin() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("FROM Father f RIGHT OUTER JOIN f.sons");
			List list = query.list();
			for (Object object : list) {
				//返回的是数组形式
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
