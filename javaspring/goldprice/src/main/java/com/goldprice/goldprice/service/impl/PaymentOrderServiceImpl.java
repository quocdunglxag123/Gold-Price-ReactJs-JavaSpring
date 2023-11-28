package com.goldprice.goldprice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.PaymentOrderDto;
import com.goldprice.goldprice.entity.PaymentOrderEntity;
import com.goldprice.goldprice.exception.PaymentOrderException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.PaymentOrderRepository;
import com.goldprice.goldprice.service.PaymentOrderService;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

	@Autowired
	private PaymentOrderRepository paymentOrderRepository;
	@Autowired
	private GenerateMapper paymentOrderMapper;

	/**
	 * Get PaymentOrder
	 * 
	 * @param paymentOrderDto PaymentOrderDto contains information about an paymentOrder to get
	 * 
	 * @return paymentOrderDto Object contains information about an paymentOrder in database
	 */
	@Override
	public Object getPaymentOrder(PaymentOrderDto paymentOrderDto) {
		return paymentOrderMapper.paymentOrderEntityToPaymentOrderDto(paymentOrderRepository.findOneById(paymentOrderDto.getId()));
	}

	/**
	 * Get All PaymentOrder
	 * 
	 * @return paymentOrderDto Object contains all information about paymentOrder in database
	 */
	@Override
	public Object getAllPaymentOrder() {
		return paymentOrderMapper.listPaymentOrderEntityToListPaymentOrderDto(paymentOrderRepository.findAll());
	}

	/**
	 * Add PaymentOrder
	 * 
	 * @param paymentOrderDto PaymentOrderDto contains information about an paymentOrder to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addPaymentOrder(PaymentOrderDto paymentOrderDto) {
		PaymentOrderEntity paymentOrderEntity = paymentOrderMapper.paymentOrderDtoToPaymentOrderEntity(paymentOrderDto);
		paymentOrderRepository.save(paymentOrderEntity);
		return true;
	}

	/**
	 * Update PaymentOrder
	 * 
	 * @param paymentOrderDto PaymentOrderDto contains information about an paymentOrder to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updatePaymentOrder(PaymentOrderDto paymentOrderDto) {
		PaymentOrderEntity paymentOrderEntityUpdate = paymentOrderRepository.findOneById(paymentOrderDto.getId());
		if (paymentOrderEntityUpdate != null) {
			// Case: PaymentOrder is in database
			paymentOrderEntityUpdate.setName(paymentOrderDto.getName());
			paymentOrderRepository.save(paymentOrderEntityUpdate);
			return true;
		} else {
			throw new PaymentOrderException("PaymentOrder Not Found!");
		}
	}

	/**
	 * Delete PaymentOrder
	 * 
	 * @param paymentOrderDto PaymentOrderDto contains information about an paymentOrder to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deletePaymentOrder(PaymentOrderDto paymentOrderDto) {
		paymentOrderRepository.deleteById(paymentOrderDto.getId());
		return true;
	}

}
