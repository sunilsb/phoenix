package edu.hibernate.criteria.restrictions.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import edu.hibernate.criteria.restrictions.Member;

public class TestCriteriaRestrictions {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		/*
		 * Populate data in the database
		 * 
		for(int i=1; i<=20;i++) {
			Member member = new Member();
			member.setMemberName("member"+i);
			session.save(member);
		}
		*/
		Criteria ctr = session.createCriteria(Member.class);
//		ctr.add(Restrictions.or(Restrictions.eq("memberName", "member20"), Restrictions.between("memberId", 5, 10)));
		ctr.addOrder(Order.asc("memberId"));
		
		List<Member> members = (List<Member>)ctr.list();
		session.getTransaction().commit();
		session.close();
		for(Member member: members) {
			System.out.println(member.getMemberId()+"::"+member.getMemberName());
		}
		
	}

}
