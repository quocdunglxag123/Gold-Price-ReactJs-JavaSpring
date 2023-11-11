package com.goldprice.goldprice.mapstruct.mapStructImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goldprice.goldprice.dto.OrderDto;
import com.goldprice.goldprice.entity.OrderEntity;
import com.goldprice.goldprice.mapstruct.AccountMapper;
import com.goldprice.goldprice.mapstruct.OrderMapper;
@Component
public class OrderMapperImpl implements OrderMapper{
	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public OrderDto orderEntityToOrderDto(OrderEntity orderEntity) {
		OrderDto orderDto = new OrderDto();
		orderDto.setId(orderEntity.getId());
		orderDto.setPaymentStatus(orderEntity.getPaymentStatus());
		orderDto.setShippingAddress(orderEntity.getShippingAddress());
		orderDto.setTotalAmount(orderEntity.getTotalAmount());
		orderDto.setAccountDto(accountMapper.accountEntityToAccountDto(orderEntity.getAccountEntity()));
		orderDto.setCreateDate(orderEntity.getCreateDate());
		orderDto.setUpdateDate(orderEntity.getUpdateDate());
		return orderDto;
	}
	
	@Override
	public OrderEntity orderDtoToOrderEntity(OrderDto orderDto) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(orderDto.getId());
		orderEntity.setPaymentStatus(orderDto.getPaymentStatus());
		orderEntity.setShippingAddress(orderDto.getShippingAddress());
		orderEntity.setTotalAmount(orderDto.getTotalAmount());
		orderEntity.setAccountEntity(accountMapper.accountDtoToAccountEntity(orderDto.getAccountDto()));
		orderEntity.setCreateDate(orderDto.getCreateDate());
		orderEntity.setUpdateDate(orderDto.getUpdateDate());
		return orderEntity;
	}

	
	
}
