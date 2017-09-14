package testRetrieval;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import entity.Father;
import entity.Son;
import utils.hibernateUtils;

public class QBC��ѯ {

	@Test	//��ѯ����
	public void testSelectAll() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Son.class);
			List<Son> list = criteria.list();
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
	
	@Test	//������ѯ
	public void testSelectByCondition() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Son.class);
			//criteria.add(Restrictions.eq("son_id", 1));
			criteria.add(Restrictions.like("son_name", "%С%"));
			List<Son> list = criteria.list();
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
	
	@Test	//�����ѯ
	public void testSelectByOrder() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Son.class);
			criteria.addOrder(Order.desc("son_id"));
			List<Son> list = criteria.list();
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
	
	@Test	//��ҳ��ѯ
	public void testSelectByPage() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Son.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(2);
			List<Son> list = criteria.list();
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
	
	@Test	//ͳ�Ʋ�ѯ
	public void testSelectCount() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Son.class);
			criteria.setProjection(Projections.rowCount());
			Object object = criteria.uniqueResult();
			int rowCount = ((Long)object).intValue();
			System.out.println("rowCount = " + rowCount);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
	@Test	//���߲�ѯ
	public void testSelectOffline() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Son.class);
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			List<Son> list = criteria.list();
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
}
