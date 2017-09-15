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

public class ������ʽ {
	
	@Test	//������ѯ
	public void testGet() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			//����get������������ѯ���ݿ�
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
	
	@Test	//�ӳٲ�ѯ
	public void testLoad() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			//����load�󲻻���������sql��䣬���صĶ���ֻ��idֵ��ֻ�е�ʹ�÷�idֵ�ŷ�����ѯ���ݿ�
			Father father = session.load(Father.class, 2);
			System.out.println(father.getFid());			//ʹ��id��δ�����ݿ�
			System.out.println(father.getFatherName());		//ʹ�÷�id�Ų����ݿ�
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	@Test	//��ͨץȡ
	public void testBatch() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();

			Criteria criteria = session.createCriteria(Father.class);
			List<Father> list = criteria.list();
			
			//�����˶���SQL���,ʹ��batch-size�����Ż�,ֵԽ��Խ��
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
