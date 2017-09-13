package testRetrieval;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Father;
import entity.Son;
import utils.hibernateUtils;

public class HQL查询 {

	@Test	//查询所有
	public void testSelectAll() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Query query = session.createQuery("from Son");
			List<Son> list = query.list();
			for (Son son : list) {
				System.out.println(son.getSon_id() + "->" + son.getSon_name());
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
	
	@Test	//条件查询
	public void testSelectByCondition() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("from Son son where son.son_name like ?");
			query.setParameter(0, "%小%");	//注意从0开始
			List<Son> list = query.list();
			for (Son son : list) {
				System.out.println(son.getSon_id() + "->" + son.getSon_name());
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
	
	@Test	//排序查询
	public void testSelectByOrder() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("from Son order by son_id desc");
			List<Son> list = query.list();
			for (Son son : list) {
				System.out.println(son.getSon_id() + "->" + son.getSon_name());
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
	
	@Test	//分页查询
	public void testSelectByPage() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("from Son");
			query.setFirstResult(0);	//开始页数
			query.setMaxResults(2);		//每页项数
			List<Son> list = query.list();
			for (Son son : list) {
				System.out.println(son.getSon_id() + "->" + son.getSon_name());
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
	
	@Test	//投影查询
	public void testSelectByPart() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("select son_id, son_name, son_gender from Son");
			List list = query.list();
			for (Object object : list) {
				System.out.println(Arrays.toString((Object[]) object));
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
	
	@Test	//聚集函数
	public void testSelectCount() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("select count(*) from Son");
			Object object = query.uniqueResult();
			int count = ((Long)object).intValue();
			System.out.println("count = " + count);
			
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
