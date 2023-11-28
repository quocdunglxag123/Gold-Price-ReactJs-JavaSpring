package com.goldprice.goldprice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.StatusOrderDto;
import com.goldprice.goldprice.entity.StatusOrderEntity;
import com.goldprice.goldprice.exception.StatusOrderException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.StatusOrderRepository;
import com.goldprice.goldprice.service.StatusOrderService;

@Service
public class StatusOrderServiceImpl implements StatusOrderService {

	@Autowired
	private StatusOrderRepository statusOrderRepository;
	@Autowired
	private GenerateMapper statusOrderMapper;

	/**
	 * Get StatusOrder
	 * 
	 * @param statusOrderDto StatusOrderDto contains information about an statusOrder to get
	 * 
	 * @return statusOrderDto Object contains information about an statusOrder in database
	 */
	@Override
	public Object getStatusOrder(StatusOrderDto statusOrderDto) {
		return statusOrderMapper.statusOrderEntityToStatusOrderDto(statusOrderRepository.findOneById(statusOrderDto.getId()));
	}

	/**
	 * Get All StatusOrder
	 * 
	 * @return statusOrderDto Object contains all information about statusOrder in database
	 */
	@Override
	public Object getAllStatusOrder() {
		return statusOrderMapper.listStatusOrderEntityToListStatusOrderDto(statusOrderRepository.findAll());
	}

	/**
	 * Add StatusOrder
	 * 
	 * @param statusOrderDto StatusOrderDto contains information about an statusOrder to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addStatusOrder(StatusOrderDto statusOrderDto) {
		StatusOrderEntity statusOrderEntity = statusOrderMapper.statusOrderDtoToStatusOrderEntity(statusOrderDto);
		statusOrderRepository.save(statusOrderEntity);
		return true;
	}

	/**
	 * Update StatusOrder
	 * 
	 * @param statusOrderDto StatusOrderDto contains information about an statusOrder to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updateStatusOrder(StatusOrderDto statusOrderDto) {
		StatusOrderEntity statusOrderEntityUpdate = statusOrderRepository.findOneById(statusOrderDto.getId());
		if (statusOrderEntityUpdate != null) {
			// Case: StatusOrder is in database
			statusOrderEntityUpdate.setName(statusOrderDto.getName());
			statusOrderRepository.save(statusOrderEntityUpdate);
			return true;
		} else {
			throw new StatusOrderException("StatusOrder Not Found!");
		}
	}

	/**
	 * Delete StatusOrder
	 * 
	 * @param statusOrderDto StatusOrderDto contains information about an statusOrder to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteStatusOrder(StatusOrderDto statusOrderDto) {
		statusOrderRepository.deleteById(statusOrderDto.getId());
		return true;
	}

}
