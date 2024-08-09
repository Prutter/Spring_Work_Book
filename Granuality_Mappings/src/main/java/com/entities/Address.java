package com.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Address {
	private Integer officeNumber;
	private String buildingName;
	private String region;
	private Integer pinCode;
}
