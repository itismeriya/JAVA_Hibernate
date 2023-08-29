package com.hibernate;

import com.hibernate.entity.Bike;
import com.hibernate.entity.Company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppRide {
	public static void main(String[] args) {


		SessionFactory factory1 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory1.openSession();

		Company company=session.get(Company.class, 201);
		System.out.println("Company Name:"+company.getCompanyName());
		
		for (Bike e :company.getBike())
		{
			System.out.println("Bike name:" +e.getBikeName());
		}
		
		
		session.close();
		factory1.close();
	}
}