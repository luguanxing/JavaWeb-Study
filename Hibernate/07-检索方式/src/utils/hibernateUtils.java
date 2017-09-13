package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtils {
	
	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	
	static {
		//���غ����ļ���ӳ��
		cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
	
	public static void main(String[] args) {
		
	}

}
