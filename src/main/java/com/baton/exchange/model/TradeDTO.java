package com.baton.exchange.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeDTO {
	
	private String seller;
	private String buyer;
	private String stock;
	private Double price;
	private Date tradeDate;

	
}
