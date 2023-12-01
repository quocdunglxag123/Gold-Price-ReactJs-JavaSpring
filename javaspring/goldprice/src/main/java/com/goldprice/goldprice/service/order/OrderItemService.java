package com.goldprice.goldprice.service.order;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.order.OrderItemDto;

@Service
public interface OrderItemService {
	/**
	 * Get OrderItem
	 * 
	 * @param orderItemDto OrderItemDto contains information about an orderItem to get
	 * 
	 * @return orderItemDto Object contains information about an orderItem in database
	 */
	Object getOrderItem(OrderItemDto orderItemDto);

	/**
	 * Add OrderItem
	 * 
	 * @param orderItemDto OrderItemDto contains information about an orderItem to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addOrderItem(OrderItemDto orderItemDto);

	/**
	 * Delete OrderItem
	 * 
	 * @param orderItemDto OrderItemDto contains information about an orderItem to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteOrderItem(OrderItemDto orderItemDto);

	/**
	 * Update OrderItem
	 * 
	 * @param orderItemDto OrderItemDto contains information about an orderItem to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateOrderItem(OrderItemDto orderItemDto);
}
