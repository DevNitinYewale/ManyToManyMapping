package com.manyToManyMap;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        
        Session ses=factory.openSession();
        
        Item item1=new Item();
        item1.setItem_id(101);
        item1.setItem_desc("book");
        item1.setItem_price(25.50);
        
        Item item2=new Item();
        item2.setItem_id(102);
        item2.setItem_desc("book1");
        item2.setItem_price(25.50);
        
        List<Item> l1=new ArrayList<Item>();
        l1.add(item1);
        l1.add(item2);
        
        Cart cart1=new Cart();
        cart1.setCart_id(1);
        cart1.setCart_total(250);
        
        List<Cart> l2=new ArrayList<Cart>();
        l2.add(cart1);
        
        cart1.setItem(l1);
        
        item1.setCart(l2);
        
        Transaction tx=ses.beginTransaction();
        
        ses.save(cart1);
        ses.save(item2);
        ses.save(item1);
        
        tx.commit();
        ses.close();
        factory.close();
        
        
    }
}
