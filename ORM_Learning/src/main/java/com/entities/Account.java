package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNumber;
	
	@Column(name = "name")
	private String accountHolderName;
	
	private Integer age; 
	
	@Column(unique = true)
	private String pancard;
	
	@Column(unique = true)
	private Long aadharcard;
	
	@Column(unique = true)
	private String email;
	
	private Double balance;
}
