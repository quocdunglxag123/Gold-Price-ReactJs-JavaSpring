package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.OrderDto;
import com.goldprice.goldprice.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public DataResponse accountLogin(@RequestBody OrderDto orderDto) {
		if (orderDto.getServiceCall().equals("add")) {
			//Case: Add Order By orderDto property 
			return new DataResponse(orderService.addOrder(orderDto));
		} else if (orderDto.getServiceCall().equals("get")) {
			//Case: Get One  Order By orderDto property 
			return new DataResponse(orderService.getOrder(orderDto));
		} else if (orderDto.getServiceCall().equals("update")) {
			//Case: Update  Order By orderDto property 
			return new DataResponse(orderService.updateOrder(orderDto));
		} else if (orderDto.getServiceCall().equals("delete")) {
			//Case: Delete  Order By orderDto property 
			return new DataResponse(orderService.deleteOrder(orderDto));
		}
		return new DataResponse("500", "Method Not Found");

	}

}
