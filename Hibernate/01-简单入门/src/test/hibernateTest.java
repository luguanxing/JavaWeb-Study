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
	public void testAdd() {
//		第一步 加载hibernate核心配置文件
		//Configuration cfg = new Configuration().configure();
		
//		第二步 创建SessionFactory对象，加载映射
		//SessionFactory factory = cfg.buildSessionFactory();
		
//		第三步 使用SessionFactory创建session对象(也可使用工具类)
		//Session session = factory.openSession();
		Session session = hibernateUtils.getSession();
		
//		第四步 开启事务
		Transaction ts = session.beginTransaction();

//		第五步 写具体逻辑 crud操作
		User user = new User();
		user.setUsername("lalala");
		user.setPassword("hahaha");
		user.setAddress("China");
		session.save(user);
		
//		第六步 提交事务
		ts.commit();

//		第七步 关闭资源
		session.close();
		//factory.close();

	}
	
}
