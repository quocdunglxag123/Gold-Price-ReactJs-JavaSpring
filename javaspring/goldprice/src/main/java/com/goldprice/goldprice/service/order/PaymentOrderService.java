package com.goldprice.goldprice.service.order;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.order.PaymentOrderDto;

@Service
public interface PaymentOrderService {
	/**
	 * Get PaymentOrder
	 * 
	 * @param paymentOrderDto PaymentOrderDto contains information about an paymentOrder to get
	 * 
	 * @return paymentOrderDto Object contains information about an paymentOrder in database
	 */
	Object getPaymentOrder(PaymentOrderDto paymentOrderDto);

	/**
	 * Get All PaymentOrder
	 * 
	 * @return paymentOrderDto Object contains all information about paymentOrder in database
	 */
	Object getAllPaymentOrder();

	/**
	 * Add PaymentOrder
	 * 
	 * @param paymentOrderDto PaymentOrderDto contains information about an paymentOrder to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addPaymentOrder(PaymentOrderDto paymentOrderDto);

	/**
	 * Delete PaymentOrder
	 * 
	 * @param paymentOrderDto PaymentOrderDto contains information about an paymentOrder to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deletePaymentOrder(PaymentOrderDto paymentOrderDto);

	/**
	 * Update PaymentOrder
	 * 
	 * @param paymentOrderDto PaymentOrderDto contains information about an paymentOrder to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updatePaymentOrder(PaymentOrderDto paymentOrderDto);
}
