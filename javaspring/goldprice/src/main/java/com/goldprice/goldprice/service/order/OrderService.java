package com.goldprice.goldprice.service.order;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.order.OrderDto;

@Service
public interface OrderService {
	/**
	 * Get Order
	 * 
	 * @param orderDto OrderDto contains information about an order to get
	 * 
	 * @return orderDto Object contains information about an order in database
	 */
	Object getOrder(OrderDto orderDto);

	/**
	 * Add Order
	 * 
	 * @param orderDto OrderDto contains information about an order to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addOrder(OrderDto orderDto);

	/**
	 * Delete Order
	 * 
	 * @param orderDto OrderDto contains information about an order to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteOrder(OrderDto orderDto);

	/**
	 * Update Order
	 * 
	 * @param orderDto OrderDto contains information about an order to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateOrder(OrderDto orderDto);
}
