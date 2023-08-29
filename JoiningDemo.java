package com.hibernate;




import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Author;
import com.hibernate.entity.Book;

public class JoiningDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Author author = new Author();
		author.setAuthId(111);
		author.setAuthName("J.K.Rowling");
		
		
		Book book1 = new Book();
		book1.setBookName("the Sorcerer's Stone");
		book1.setBookPages(500);
		book1.setBookPrice(1000);
		book1.setAuthor(author);
		
		Book book2 = new Book();
		book2.setBookName("the Chamber of Secrets");
		book2.setBookPages(700);
		book2.setBookPrice(1200);
		book2.setAuthor(author);
//		
//		//array list to store many books
		ArrayList<Book> list = new ArrayList<>();
		list.add(book1);
		list.add(book2);
//		
//		//adding all books in list in author class
		author.setBook(list);
//		
//		//adding the details in database
		session.save(author);
		session.save(book1);
		session.save(book2);
//		
		tx.commit();
		//fetch the book details using author id
		Author author1 = session.get(Author.class, 111);
		System.out.println("Author name:" +author1.getAuthName());
		
		for (Book e :author1.getBook())
		{
			System.out.println("Book name:" +e.getBookName());
		}
		session.close();
		factory.close();
	}

}