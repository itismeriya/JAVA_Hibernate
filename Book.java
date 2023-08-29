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
@Table(name = "book_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increase
	private int bookId;	

	@Column(length = 30, nullable = false, unique = true)
	private String bookName;

	@Column(nullable = false, name="price")
	private double bookPrice;
	
	@Column
	private int bookPages;
	
	@ManyToOne   //many books can be written by one author
	private Author author;

}