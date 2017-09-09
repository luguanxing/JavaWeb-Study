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
			//使用Query对象查询，查询语句是HQL语句，返回List
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
			//使用Criteria对象查询，不用写查询语句，返回List
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
			//使用SQLQuery对象查询，写普通的查询语句
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			List<Object[]> list = sqlQuery.list();	//直接用list()返回的每个对象是数组
			for (Object[] object : list) {
				System.out.println(Arrays.toString(object));
			}
			sqlQuery.addEntity(User.class);			//addEntity设置类型为User后返回User类
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
