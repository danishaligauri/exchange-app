package com.baton.exchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baton.exchange.model.ApiResponse;
import com.baton.exchange.model.OrderDTO;
import com.baton.exchange.services.ExchangeService;

@RestController
public class ExchangeController {
	
	@Autowired
	ExchangeService exchangeService;
	
	@PostMapping("/pushOrder")
	public ApiResponse pushOrder(@RequestBody List<OrderDTO> orderDTO) {
		return exchangeService.pushOrderDetail(orderDTO);
	}
	
	@PostMapping("/tradeDetails")
	public ApiResponse getTradeDetail() {
		return exchangeService.tradeOrderDetail();
	}
	
	
	@PostMapping("/unmatched")
	public ApiResponse getUnmatch() {
		return exchangeService.unMatchOrderDetail();
	}

}
