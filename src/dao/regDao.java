package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import vo.regVo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class regDao {

	public void insert(regVo v1) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(v1);
			transaction.commit();

			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<regVo> showdata() {
		List<regVo> ls = new ArrayList<regVo>();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("From regVo r");

			ls = q.list();
			// Iterator it = ls.iterator();
			// while(it.hasNext()){
			// regVo v1 =(regVo)it.next();
			// v1.getId();
			// v1.getFirstname();
			// v1.getLastname();
			// ls.add(v1);
			// }

			transaction.commit();

			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return ls;
	}

	public List<regVo> search(String s1) {
		List<regVo> ls = new ArrayList<regVo>();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery(
					"from regVo as r where r.firstname like :n or r.lastname like :n");
			q.setParameter("n","%"+s1+"%");
//			q.setString("p","%"+s1+"%");

			ls = q.list();
//			for(regVo r:ls){
//				System.out.println(r.getFirstname());
//			}
			transaction.commit();

			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return ls;
	}

	public void delete(regVo v1) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("delete from regVo r where r.id='" + v1.getId() + "'");
			q.executeUpdate();
			transaction.commit();

			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(regVo v1) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("update regVo r set r.firstname='"+v1.getFirstname()+"', r.lastname='"+v1.getLastname()+"' where r.id='" + v1.getId() + "'");
			q.executeUpdate();
			transaction.commit();

			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
