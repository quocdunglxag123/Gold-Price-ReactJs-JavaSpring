package com.goldprice.goldprice.service;

import org.springframework.stereotype.Service;
import com.goldprice.goldprice.dto.StatusOrderDto;

@Service
public interface StatusOrderService {
	/**
	 * Get StatusOrder
	 * 
	 * @param statusOrderDto StatusOrderDto contains information about an statusOrder to get
	 * 
	 * @return statusOrderDto Object contains information about an statusOrder in database
	 */
	Object getStatusOrder(StatusOrderDto statusOrderDto);

	/**
	 * Get All StatusOrder
	 * 
	 * @return statusOrderDto Object contains all information about statusOrder in database
	 */
	Object getAllStatusOrder();

	/**
	 * Add StatusOrder
	 * 
	 * @param statusOrderDto StatusOrderDto contains information about an statusOrder to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addStatusOrder(StatusOrderDto statusOrderDto);

	/**
	 * Delete StatusOrder
	 * 
	 * @param statusOrderDto StatusOrderDto contains information about an statusOrder to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteStatusOrder(StatusOrderDto statusOrderDto);

	/**
	 * Update StatusOrder
	 * 
	 * @param statusOrderDto StatusOrderDto contains information about an statusOrder to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateStatusOrder(StatusOrderDto statusOrderDto);
}
