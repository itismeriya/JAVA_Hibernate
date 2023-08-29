package com.hibernate.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {
	
	@Id
	private int companyId;
	
	@Column(length=50,nullable=false)
	private String companyName;
	
	@Column(length=10,nullable=false)
	private String branch;
	
	@OneToMany
	private List<Bike> bike;

}