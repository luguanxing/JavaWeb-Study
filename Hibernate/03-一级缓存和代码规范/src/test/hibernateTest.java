package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import entity.User;
import utils.hibernateUtils;

public class hibernateTest {
	
	@Test
	public void testTx() {
		//代码规范
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//操作方法
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
	public void testCache() {
		//验证一级缓存的存在
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			User user1 = session.get(User.class, 1);
			System.out.println(user1);
			User user2 = session.get(User.class, 1);	//连续两次查询相同user，但只查询了一次数据库
			System.out.println(user2);
			user1.setPassword("666");	//持久态变脏(修改后)提交会自动更新
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
