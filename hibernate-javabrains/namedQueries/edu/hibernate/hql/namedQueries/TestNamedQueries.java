package edu.hibernate.hql.namedQueries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestNamedQueries {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		/*
		 * Store some data in the db
		 */
//		for(int i=0;i<10;i++){
//			UserDetail user = new UserDetail();
//			user.setUserName("user"+i);
//			session.save(user);
//		}

		//For Named queries
//		Query query = session.getNamedQuery("UserDetail.byId");
//		query.setInteger(0, 5);
		//For Named native queries
		Query query = session.getNamedQuery("userdetail.byName");
		query.setString(0, "user4");
		List<UserDetail> users = (List<UserDetail>) query.list();
		for(UserDetail user: users){
			System.out.println(user.getUserId()+":::"+user.getUserName());
		}
		session.getTransaction().commit();
		session.close();
	}

}
