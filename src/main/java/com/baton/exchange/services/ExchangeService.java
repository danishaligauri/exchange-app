package com.baton.exchange.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baton.exchange.constants.Constants;
import com.baton.exchange.model.ApiResponse;
import com.baton.exchange.model.OrderDTO;
import com.baton.exchange.model.TradeDTO;

@Service
public class ExchangeService {

	private List<OrderDTO> orderList;
	private List<OrderDTO> notMatchedOrder;

	public ApiResponse pushOrderDetail(List<OrderDTO> orderDTO) {
		// TODO Auto-generated method stub
		this.orderList = orderDTO;
		return new ApiResponse("Success", "Data Uploaded", null);
	}

	public ApiResponse tradeOrderDetail() {
		// TODO Auto-generated method stub
		List<TradeDTO> tradeList = new ArrayList<>();
		notMatchedOrder = new ArrayList<>();
		boolean flag = true;
		if (orderList == null || orderList.isEmpty()) {
			return new ApiResponse("Success", "Please push the order using /pushOrder API", null);
		}
		List<OrderDTO> orderCopy = new ArrayList<>();
		orderCopy.addAll(orderList);
		for (int i = 0; i < orderList.size(); i++) {
			for (int j = 0; j < orderCopy.size(); j++) {
					if ( ! orderList.get(i).getOrderType().equalsIgnoreCase(orderCopy.get(j).getOrderType())
							&& orderList.get(i).getStockName().equalsIgnoreCase(orderCopy.get(j).getStockName())
							&& orderList.get(i).getPrice().equals(orderCopy.get(j).getPrice())) {
						
						if(! orderList.get(i).getPartyName().equalsIgnoreCase(orderCopy.get(j).getPartyName())) {
							TradeDTO obj = new TradeDTO();
							if(orderList.get(i).getPartyName().equalsIgnoreCase(Constants.BUYER)) {
								obj.setBuyer(orderList.get(i).getPartyName());
								obj.setSeller(orderList.get(j).getPartyName());
							} else {
								obj.setBuyer(orderList.get(j).getPartyName());
								obj.setSeller(orderList.get(i).getPartyName());
							}
							obj.setStock(orderList.get(i).getStockName());
							obj.setPrice(orderList.get(i).getPrice());
							obj.setTradeDate(new Date());
							tradeList.add(obj);
							flag = false;
							orderCopy.remove(orderList.get(i));
							break;
						}
						
					}
			}
			if (flag) {
			//	notMatchedOrder.add(orderList.get(i));
			}

		}
		return new ApiResponse("Success", "Success", tradeList);
	}

	public ApiResponse unMatchOrderDetail() {
		if(notMatchedOrder == null) {
			return new ApiResponse("Success", "Please push the order using '/pushOrder' API and call '/tradeDetails' ", null);
		}
		return new ApiResponse("Success", "Success", (notMatchedOrder.isEmpty()  ? "No record Found" :  notMatchedOrder));
	}
}
