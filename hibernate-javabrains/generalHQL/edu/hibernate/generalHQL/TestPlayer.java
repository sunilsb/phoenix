package edu.hibernate.generalHQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestPlayer {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		/*
		 * Store some data in the db
		 */
//		for(int i=0;i<10;i++){
//			Player player = new Player();
//			player.setPlayerName("player"+i);
//			session.save(player);
//		}
		
		Query query = session.createQuery("from Player where playerId > 5");
		List<Player> players = (List<Player>) query.list();
		for(Player player: players){
			System.out.println(player.getPlayerId()+":::"+player.getPlayerName());
		}
		session.getTransaction().commit();
		session.close();
	}

}
