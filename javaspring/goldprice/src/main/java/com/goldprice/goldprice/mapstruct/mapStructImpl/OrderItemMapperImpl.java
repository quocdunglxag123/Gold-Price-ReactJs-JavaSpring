package com.goldprice.goldprice.mapstruct.mapStructImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goldprice.goldprice.dto.OrderItemDto;
import com.goldprice.goldprice.entity.OrderItemEntity;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.mapstruct.OrderItemMapper;

@Component
public class OrderItemMapperImpl implements OrderItemMapper {
	@Autowired
	GenerateMapper generateMapper;

	@Override
	public OrderItemDto orderItemEntityToOrderItemDto(OrderItemEntity orderItemEntity) {
		OrderItemDto orderItemDto = new OrderItemDto();
		orderItemDto.setCreateDate(orderItemEntity.getCreateDate());
		orderItemDto.setUpdateDate(orderItemEntity.getUpdateDate());
		orderItemDto.setId(orderItemEntity.getId());
		orderItemDto.setProductDto(generateMapper.productEntityToProductDto(orderItemEntity.getProductEntity()));
		orderItemDto.setQuantity(orderItemEntity.getQuantity());
		orderItemDto.setSubtotal(orderItemEntity.getSubTotal());
		return orderItemDto;
	}

	@Override
	public OrderItemEntity orderItemDtoToOrderItemEntity(OrderItemDto orderItemDto) {
		OrderItemEntity orderItemEntity = new OrderItemEntity();
		orderItemEntity.setCreateDate(orderItemDto.getCreateDate());
		orderItemEntity.setUpdateDate(orderItemDto.getUpdateDate());
		orderItemEntity.setId(orderItemDto.getId());
		orderItemEntity.setProductEntity(generateMapper.productDtoToProductEntity(orderItemDto.getProductDto()));
		orderItemEntity.setQuantity(orderItemDto.getQuantity());
		orderItemEntity.setSubTotal(orderItemDto.getSubtotal());
		return orderItemEntity;
	}

	@Override
	public List<OrderItemDto> listOrderItemEntityToListOrderItemDto(List<OrderItemEntity> orderItemEntities) {
		if (orderItemEntities == null) {
			return null;
		}

		List<OrderItemDto> list = new ArrayList<OrderItemDto>(orderItemEntities.size());
		for (OrderItemEntity orderItemEntity : orderItemEntities) {
			list.add(orderItemEntityToOrderItemDto(orderItemEntity));
		}

		return list;
	}

	@Override
	public List<OrderItemEntity> listOrderItemDtoToListOrderItemEntity(List<OrderItemDto> orderItemDtos) {
		if (orderItemDtos == null) {
			return null;
		}

		List<OrderItemEntity> list = new ArrayList<OrderItemEntity>(orderItemDtos.size());
		for (OrderItemDto orderItemDto : orderItemDtos) {
			list.add(orderItemDtoToOrderItemEntity(orderItemDto));
		}

		return list;
	}

}
