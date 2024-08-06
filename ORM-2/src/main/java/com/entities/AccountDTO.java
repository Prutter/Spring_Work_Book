package com.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountDTO {
	private String accountHolderName;
	
	private Integer age; 
	
	private String email;
}
