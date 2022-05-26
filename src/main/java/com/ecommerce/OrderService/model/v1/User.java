package com.ecommerce.OrderService.model.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int id;
	private String name;
	private String[] address;
	private String[] address1;
	private String Test;

	public User(int id, String name, String[] address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
}
