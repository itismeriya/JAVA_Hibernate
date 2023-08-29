package com.hibernate;




import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Company;
import com.hibernate.entity.Bike;

public class JoiningRide {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Company company = new Company();
		company.setCompanyId(201);
		company.setCompanyName("Harley Davidson");
		company.setBranch("Kolkata");
		
		
		Bike bike1 = new Bike();
		bike1.setBikeName("Sportster");
		bike1.setPrice(2000000);
		bike1.setCompany(company);
//		bike1.setBikeId(100);
		bike1.setColour("Red");
		
		Bike bike2 = new Bike();
		bike2.setBikeName("America");
//		bike2.setBikeId(101);
		bike2.setPrice(1900000);
		bike2.setCompany(company);
		bike2.setColour("Black");
//		
//		//array list to store many books
		ArrayList<Bike> list = new ArrayList<>();
		list.add(bike1);
		list.add(bike2);
//		
//		//adding all books in list in author class
		company.setBike(list);
//		
//		//adding the details in database
		session.save(company);
		session.save(bike1);
		session.save(bike2);
//		
		tx.commit();

		session.close();
		factory.close();
	}

}