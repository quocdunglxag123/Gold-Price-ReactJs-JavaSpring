package com.goldprice.goldprice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.AccountDto;
import com.goldprice.goldprice.dto.OrderDto;
import com.goldprice.goldprice.entity.OrderEntity;
import com.goldprice.goldprice.exception.OrderException;
import com.goldprice.goldprice.mapstruct.AccountMapper;
import com.goldprice.goldprice.mapstruct.OrderMapper;
import com.goldprice.goldprice.repository.OrderRepository;
import com.goldprice.goldprice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private AccountMapper accountMapper;

	/**
	 * Get Order
	 * 
	 * @param orderDto OrderDto contains information about an order to get
	 * 
	 * @return orderDto Object contains information about an order in database
	 */
	@Override
	public Object getOrder(OrderDto orderDto) {
		OrderEntity orderEntity = orderRepository.findOneById(orderDto.getId());
		AccountDto accountDto = accountMapper.accountEntityToAccountDto(orderEntity.getAccountEntity());
		OrderDto orderDtoResponse = orderMapper.orderEntityToOrderDto(orderEntity);
		orderDtoResponse.setAccountDto(accountDto);
		return orderDtoResponse;
	}

	/**
	 * Add Order
	 * 
	 * @param orderDto OrderDto contains information about an order to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addOrder(OrderDto orderDto) {
		OrderEntity orderEntity = orderMapper.orderDtoToOrderEntity(orderDto);
		orderRepository.save(orderEntity);
		return true;
	}

	/**
	 * Update Order
	 * 
	 * @param orderDto OrderDto contains information about an order to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updateOrder(OrderDto orderDto) {
		OrderEntity orderEntityUpdate = orderRepository.findOneById(orderDto.getId());
		if (orderEntityUpdate != null) {
			// Case: Order is in database

			return true;
		} else {
			throw new OrderException("Order Not Found!");
		}
	}

	/**
	 * Delete Order
	 * 
	 * @param orderDto OrderDto contains information about an order to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteOrder(OrderDto orderDto) {
		orderRepository.deleteById(orderDto.getId());
		return true;
	}

}
