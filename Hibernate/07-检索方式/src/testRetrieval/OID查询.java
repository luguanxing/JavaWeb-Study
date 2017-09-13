package testRetrieval;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Father;
import entity.Son;
import utils.hibernateUtils;

public class OID查询 {

	@Test
	public void testSelect() {
		Session session = null;
		Transaction ts = null;
		try {
			session = hibernateUtils.getSession();
			ts = session.beginTransaction();
			
			//先查属主，再查从属
			Father father = session.get(Father.class, 1);
			Set<Son> sons = father.getSons();
			for (Son son : sons) {
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
