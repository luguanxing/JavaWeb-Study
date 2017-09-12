package testOneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Father;
import entity.Son;
import utils.hibernateUtils;

public class �������� {
	@Test
	public void testAdd() {
		Session session = hibernateUtils.getSession();
		Transaction ts = session.beginTransaction();
		try {
			//����ʵ��
			Father father = new Father();
			father.setFatherName("�����");
			father.setFatherLevel("��ͨ�ͻ�");
			father.setFatherSource("����");
			father.setFatherPhone("110");
			father.setFatherMobile("999");
			Son son = new Son();
			son.setSon_name("��С��");
			son.setSon_gender("��");
			son.setSon_phone("911");
			
			//������ϵ
			father.getSons().add(son);
			son.setFather(father);
			
			//��������
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
			//����ʵ��
			Father father = new Father();
			father.setFatherName("�����2");
			father.setFatherLevel("��ͨ�ͻ�");
			father.setFatherSource("����");
			father.setFatherPhone("110");
			father.setFatherMobile("999");
			Son son = new Son();
			son.setSon_name("��С��2");
			son.setSon_gender("��");
			son.setSon_phone("911");
			
			//������ϵ(ʹ��cascade="save-update")
			father.getSons().add(son);
			
			//��������(ʹ��cascade="save-update")
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
			//�Ȳ��ɾ���ܼ���ɾ��
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
			//�Ȳ���
			Father father = session.get(Father.class, 1);
			Son son2 = session.get(Son.class, 2);
			
			//hibernate˫��ά��������޸������ʹ�������ʱ��update���Σ�Ӱ��������
			//���inverse="true"��������ά�����Ż���˼������ͬ������ʶ��ϯ����ϯ��һ����ʶ��������
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
