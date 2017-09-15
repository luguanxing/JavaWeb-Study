package testRetrieval;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Father;
import entity.Son;
import utils.hibernateUtils;

public class 检索方式 {
	
	@Test	//立即查询
	public void testGet() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			//调用get后立即发语句查询数据库
			Father father = session.get(Father.class, 1);
			System.out.println(father.getFid() + " -> " + father.getFatherName());
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	@Test	//延迟查询
	public void testLoad() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			//调用load后不会立即发送sql语句，返回的对象只有id值，只有当使用非id值才发语句查询数据库
			Father father = session.load(Father.class, 2);
			System.out.println(father.getFid());			//使用id还未查数据库
			System.out.println(father.getFatherName());		//使用非id才查数据库
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	@Test	//普通抓取
	public void testBatch() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Criteria criteria = session.createCriteria(Father.class);
			List<Father> list = criteria.list();
			
			//发送了多条SQL语句,使用batch-size属性优化,值越大越好
			for (Father father : list) {
				System.out.println(father.getFatherName());
				Set<Son> sons = father.getSons();
				for (Son son : sons) {
					System.out.println(father.getFatherName() + " -> " + son.getSon_name());
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
