package com.hibernate;

import com.hibernate.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Book b1=new Book();
		b1.setBookName("The krishna key");
		b1.setBookPages(450);
		b1.setBookPrice(399.9);
		
		Book b2=new Book();
		b2.setBookName("Epic Shit");
		b2.setBookPages(300);
		b2.setBookPrice(250);
//		
//		//to save object in your database
		session.save(b1);
		session.save(b2);

		
		
		//retrieve the data from the database
		Book book1=session.get(Book.class,1);
		System.out.println(book1);

		Book book2=session.load(Book.class, 2);
		System.out.println(book2);
		
		Book book3=session.get(Book.class,3);
		System.out.println(book3);

		Book book4=session.load(Book.class, 4);
		System.out.println(book4);
		
		
		session.close();
		factory.close();
	}
}