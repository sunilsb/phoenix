package edu.hibernate.hql_parameter_substitution;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.generalHQL.Player;

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
		/*
		 * positional parameter substitution
		 */
		int id = 8;
		String name = "player9";
//		Query query = session.createQuery("from Player where playerId > ? and playername = ?");
//		query.setInteger(0, id);
//		query.setString(1, name);
		
		/*
		 * Name place holder
		 */
		Query query = session.createQuery("from Player where playerid > :playerId and playerName = :playerName");
		query.setInteger("playerId", id);
		query.setString("playerName", name);
		List<Player> players = (List<Player>) query.list();
		for(Player player: players){
			System.out.println(player.getPlayerId()+":::"+player.getPlayerName());
		}
		session.getTransaction().commit();
		session.close();
	}

}
