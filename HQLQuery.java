package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

import com.hibernate.entity.Book;

public class HQLQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory factory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
				Session session = factory.openSession();) {

		Transaction tx=session.beginTransaction();
			// using hql
			String hql = "from Book";
			Query query = session.createQuery(hql);
			
			List<Book> list= query.getResultList();
			
			
			for (Book b : list) {
				System.out.println("Book Name: "+b.getBookName());
				System.out.println("Book price: "+b.getBookPrice());
				System.out.println("Book pages: "+b.getBookPages());
			}

			String hql1="from Book where bookPrice=:price or bookPages=:page";
			
			Query q1=session.createQuery(hql1);
			
			q1.setParameter("price", 399.9);
			q1.setParameter("page", 1000);
			
			List<Book> list1=q1.getResultList();
			
			for (Book b : list1) {
				System.out.println("Book Name: "+b.getBookName());
				System.out.println("Book price: "+b.getBookPrice());
			}
			
			//update
		   Query q2= session.createQuery("update Book set bookName=:n where bookId=:i");
			
		   q2.setParameter("n", "the Goblet of Fire");
		   q2.setParameter("i",1 );
		   
		   int r=q2.executeUpdate();
		   System.out.println(r+" record updated");
		   tx.commit();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}