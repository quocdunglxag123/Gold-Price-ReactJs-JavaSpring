package com.goldprice.goldprice.mapstruct.mapStructImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goldprice.goldprice.dto.order.OrderDto;
import com.goldprice.goldprice.dto.order.OrderItemDto;
import com.goldprice.goldprice.entity.order.OrderEntity;
import com.goldprice.goldprice.entity.order.OrderItemEntity;
import com.goldprice.goldprice.mapstruct.AccountMapper;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.mapstruct.OrderItemMapper;
import com.goldprice.goldprice.mapstruct.OrderMapper;

@Component
public class OrderMapperImpl implements OrderMapper {
	@Autowired
	AccountMapper accountMapper;
	@Autowired
	OrderItemMapper orderItemMapper;
	@Autowired
	GenerateMapper generateMapper;

	@Override
	public OrderDto orderEntityToOrderDto(OrderEntity orderEntity) {
		OrderDto orderDto = new OrderDto();
		orderDto.setId(orderEntity.getId());
		orderDto.setStatusOrderDto(
				generateMapper.statusOrderEntityToStatusOrderDto(orderEntity.getStatusOrderEntity()));
		orderDto.setPaymentOrderDto(
				generateMapper.paymentOrderEntityToPaymentOrderDto(orderEntity.getPaymentOrderEntity()));
		orderDto.setShippingAddress(orderEntity.getShippingAddress());
		orderDto.setTotalAmount(orderEntity.getTotalAmount());
		orderDto.setAccountDto(accountMapper.accountEntityToAccountDto(orderEntity.getAccountEntity()));
		orderDto.setCreateDate(orderEntity.getCreateDate());
		orderDto.setUpdateDate(orderEntity.getUpdateDate());
		List<OrderItemDto> orderItemDtos = orderItemMapper
				.listOrderItemEntityToListOrderItemDto(orderEntity.getOrderItemEntities());
		orderDto.setOrderItemDtos(orderItemDtos);

		return orderDto;
	}

	@Override
	public OrderEntity orderDtoToOrderEntity(OrderDto orderDto) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(orderDto.getId());
		orderEntity
				.setStatusOrderEntity(generateMapper.statusOrderDtoToStatusOrderEntity(orderDto.getStatusOrderDto()));
		orderEntity
		.setPaymentOrderEntity(generateMapper.paymentOrderDtoToPaymentOrderEntity(orderDto.getPaymentOrderDto()));
		orderEntity.setShippingAddress(orderDto.getShippingAddress());
		orderEntity.setTotalAmount(orderDto.getTotalAmount());
		orderEntity.setAccountEntity(accountMapper.accountDtoToAccountEntity(orderDto.getAccountDto()));
		orderEntity.setCreateDate(orderDto.getCreateDate());
		orderEntity.setUpdateDate(orderDto.getUpdateDate());
		List<OrderItemEntity> orderItemEntities = orderItemMapper
				.listOrderItemDtoToListOrderItemEntity(orderDto.getOrderItemDtos());
		orderEntity.setOrderItemEntities(orderItemEntities);

		return orderEntity;
	}

}
