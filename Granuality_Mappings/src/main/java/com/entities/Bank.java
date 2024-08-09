package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankId;
	private String bankName;
	
	@Embedded
	@ElementCollection
	@JoinTable(name = "branches", joinColumns = @JoinColumn(name = "branch"))
	private List<Branch> branches = new ArrayList<>();
}
