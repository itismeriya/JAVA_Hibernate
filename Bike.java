package com.hibernate.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bike_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bike {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increase
	private int BikeId;

	@Column(length = 30, nullable = false, unique = true)
	private String BikeName;

	@Column(nullable = false, name="price")
	private double Price;
	
	@Column
	private String Colour;
	
	@ManyToOne //one company has many bikes
	private Company company;

	

}