package com.hql.queries;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.manyToManyMap.Cart;
import com.manyToManyMap.Item;

public class HqlQuery{
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session ses=factory.openSession();
		Transaction tx=ses.beginTransaction();
		
		System.out.println("----------------- Get Single Record using getSingleResult -----------------");
		
		String query="from Cart where id=:n";
		
		Query q1=ses.createQuery(query);
		q1.setParameter("n", 1);
		
		Cart c1=(Cart) q1.getSingleResult();
		
		System.out.println(c1.getCart_id());
		System.out.println(c1.getCart_total());
		
		System.out.println("----------------- Get Multiple Record using getResultList -----------------");
		
			String query2="from Item ";
			Query q2=ses.createQuery(query2);
			
			List<Item> list1=q2.getResultList();
			for(Item i1: list1) {
				System.out.println("Item id: "+i1.getItem_id());
				System.out.println("Item Name: " + i1.getItem_desc());
				System.out.println("Item Price: "+ i1.getItem_price());
				
				System.out.println("--------------------------- Cart Details: ---------------------------");
				List<Cart> c2=i1.getCart();
				
				for(Cart cart:c2) {
					System.out.println(cart.getCart_id());
					System.out.println(cart.getCart_total());
				}
			}
					
		tx.commit();
		ses.close();
		factory.close();
		
	}
}