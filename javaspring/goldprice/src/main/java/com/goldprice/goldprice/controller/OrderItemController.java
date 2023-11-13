package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.OrderItemDto;
import com.goldprice.goldprice.service.OrderItemService;

@RestController
@CrossOrigin
public class OrderItemController {
	@Autowired
	private OrderItemService orderItemService;

	@PostMapping("/orderItem")
	public DataResponse accountLogin(@RequestBody OrderItemDto orderItemDto) {
		if (orderItemDto.getServiceCall().equals("add")) {
			//Case: Add Order Item By orderItemDto property 
			return new DataResponse(orderItemService.addOrderItem(orderItemDto));
		} else if (orderItemDto.getServiceCall().equals("get")) {
			//Case: Get One  Order Item By orderItemDto property 
			return new DataResponse(orderItemService.getOrderItem(orderItemDto));
		} else if (orderItemDto.getServiceCall().equals("update")) {
			//Case: Update  Order Item By orderItemDto property 
			return new DataResponse(orderItemService.updateOrderItem(orderItemDto));
		} else if (orderItemDto.getServiceCall().equals("delete")) {
			//Case: Delete  Order Item By orderItemDto property 
			return new DataResponse(orderItemService.deleteOrderItem(orderItemDto));
		}
		return new DataResponse("500", "Method Not Found");

	}

}
