package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.order.OrderDto;
import com.goldprice.goldprice.dto.order.OrderItemDto;
import com.goldprice.goldprice.dto.order.PaymentOrderDto;
import com.goldprice.goldprice.dto.order.StatusOrderDto;
import com.goldprice.goldprice.service.order.OrderItemService;
import com.goldprice.goldprice.service.order.OrderService;
import com.goldprice.goldprice.service.order.PaymentOrderService;
import com.goldprice.goldprice.service.order.StatusOrderService;

@RestController
@CrossOrigin
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private PaymentOrderService paymentOrderService;
	@Autowired
	private StatusOrderService statusOrderService;
	
	@PostMapping("/order")
	public DataResponse order(@RequestBody OrderDto orderDto) {
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

	@PostMapping("/orderItem")
	public DataResponse orderItem(@RequestBody OrderItemDto orderItemDto) {
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
	
	@PostMapping("/paymentOrder")
	public DataResponse paymentOrder(@RequestBody PaymentOrderDto paymentOrderDto) {
		if (paymentOrderDto.getServiceCall().equals("add")) {
			//Case: Add Payment Order By paymentOrderDto property 
			return new DataResponse(paymentOrderService.addPaymentOrder(paymentOrderDto));
		} else if (paymentOrderDto.getServiceCall().equals("get")) {
			//Case: Get One  Payment Order By paymentOrderDto property 
			return new DataResponse(paymentOrderService.getPaymentOrder(paymentOrderDto));
		}else if (paymentOrderDto.getServiceCall().equals("getAll")) {
			//Case: Get All  Payment Order 
			return new DataResponse(paymentOrderService.getAllPaymentOrder());
		}  else if (paymentOrderDto.getServiceCall().equals("update")) {
			//Case: Update  Payment Order By paymentOrderDto property 
			return new DataResponse(paymentOrderService.updatePaymentOrder(paymentOrderDto));
		} else if (paymentOrderDto.getServiceCall().equals("delete")) {
			//Case: Delete  Payment Order By paymentOrderDto property 
			return new DataResponse(paymentOrderService.deletePaymentOrder(paymentOrderDto));
		}
		return new DataResponse("500", "Method Not Found");

	}
	
	@PostMapping("/statusOrder")
	public DataResponse statusOrder(@RequestBody StatusOrderDto statusOrderDto) {
		if (statusOrderDto.getServiceCall().equals("add")) {
			//Case: Add Payment Order By statusOrderDto property 
			return new DataResponse(statusOrderService.addStatusOrder(statusOrderDto));
		} else if (statusOrderDto.getServiceCall().equals("get")) {
			//Case: Get One  Payment Order By statusOrderDto property 
			return new DataResponse(statusOrderService.getStatusOrder(statusOrderDto));
		}else if (statusOrderDto.getServiceCall().equals("getAll")) {
			//Case: Get All  Payment Order 
			return new DataResponse(statusOrderService.getAllStatusOrder());
		}  else if (statusOrderDto.getServiceCall().equals("update")) {
			//Case: Update  Payment Order By statusOrderDto property 
			return new DataResponse(statusOrderService.updateStatusOrder(statusOrderDto));
		} else if (statusOrderDto.getServiceCall().equals("delete")) {
			//Case: Delete  Payment Order By statusOrderDto property 
			return new DataResponse(statusOrderService.deleteStatusOrder(statusOrderDto));
		}
		return new DataResponse("500", "Method Not Found");

	}

}
