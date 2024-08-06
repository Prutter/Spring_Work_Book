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
@Data
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
	
	private Double balance = 0.0;

	@Override
	public String toString() {
		return "Your Account Details\n accountNumber = " + accountNumber + "\n accountHolderName = " + accountHolderName + "\n age=" + age
				+ "\n pancard = " + pancard + "\n aadharcard = " + aadharcard + "\n email = " + email + "\n balance = " + balance
				;
	}
	
	
}
