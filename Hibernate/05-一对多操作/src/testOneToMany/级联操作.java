package testOneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Father;
import entity.Son;
import utils.hibernateUtils;

public class 级联操作 {
	@Test
	public void testAdd() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//建立实体
			Father father = new Father();
			father.setFatherName("李大龙");
			father.setFatherLevel("普通客户");
			father.setFatherSource("网络");
			father.setFatherPhone("110");
			father.setFatherMobile("999");
			Son son = new Son();
			son.setSon_name("李小龙");
			son.setSon_gender("男");
			son.setSon_phone("911");
			
			//建立关系
			father.getSons().add(son);
			son.setFather(father);
			
			//保存数据
			session.save(father);
			session.save(son);
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
	public void testAdd2() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//建立实体
			Father father = new Father();
			father.setFatherName("李大龙2");
			father.setFatherLevel("普通客户");
			father.setFatherSource("网络");
			father.setFatherPhone("110");
			father.setFatherMobile("999");
			Son son = new Son();
			son.setSon_name("李小龙2");
			son.setSon_gender("男");
			son.setSon_phone("911");
			
			//建立关系(使用cascade="save-update")
			father.getSons().add(son);
			
			//保存数据(使用cascade="save-update")
			session.save(father);
			
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
	public void testDelete() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//先查后删，能级联删除
			Father father = session.get(Father.class, 2);
			session.delete(father);
			
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
	public void testModify() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//先查后改
			Father father = session.get(Father.class, 1);
			Son son2 = session.get(Son.class, 2);
			
			//hibernate双向维护外键，修改属主和从属对象时会update两次，影响了性能
			//添加inverse="true"放弃属主维护可优化，思想是如同人民认识主席，主席不一定认识所有人民
			father.getSons().add(son2);
			son2.setFather(father);

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
