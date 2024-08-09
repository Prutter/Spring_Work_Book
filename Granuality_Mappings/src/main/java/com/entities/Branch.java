package com.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer branchCode;
	private String branchName;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "officeNumber", column = @Column(name = "main_bank_num")),
		@AttributeOverride(name = "buildingName", column = @Column(name = "main_bank_bud")),
		@AttributeOverride(name = "region", column = @Column(name = "main_bank_reg")),
		@AttributeOverride(name = "pinCode", column = @Column(name = "main_bank_pin")),
	})
	private Address main;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "officeNumber", column = @Column(name = "loan_bank_num")),
		@AttributeOverride(name = "buildingName", column = @Column(name = "loan_bank_bud")),
		@AttributeOverride(name = "region", column = @Column(name = "loan_bank_reg")),
		@AttributeOverride(name = "pinCode", column = @Column(name = "loan_bank_pin")),
	})
	private Address loan;	
}
