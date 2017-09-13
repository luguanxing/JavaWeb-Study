package testRetrieval;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Father;
import entity.Son;
import utils.hibernateUtils;

public class 对象导航查询 {

	@Test
	public void testSelect() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			//直接根据id查询对象
			Father father = session.get(Father.class, 1);
			System.out.println(father.getFid() + "->" + father.getFatherName());
			
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
