package com.baton.exchange.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class OrderDTO {
	
	private String partyName;
	private String orderType;
	private String stockName;
	private Double price;
	
}
