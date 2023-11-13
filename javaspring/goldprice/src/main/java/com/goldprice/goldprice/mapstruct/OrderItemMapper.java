package com.goldprice.goldprice.mapstruct;

import java.util.List;

import com.goldprice.goldprice.dto.OrderItemDto;
import com.goldprice.goldprice.entity.OrderItemEntity;

public interface OrderItemMapper {
	// ----------------------------Order Item Start---------------------------
	// Entity To DTO
	OrderItemDto orderItemEntityToOrderItemDto(OrderItemEntity orderItemEntity);

	List<OrderItemDto> listOrderItemEntityToListOrderItemDto(List<OrderItemEntity> orderItemEntities);

	// DTO To Entity
	OrderItemEntity orderItemDtoToOrderItemEntity(OrderItemDto orderItemDto);

	List<OrderItemEntity> listOrderItemDtoToListOrderItemEntity(List<OrderItemDto> orderItemDtos);
	// ----------------------------Order Item End---------------------------
}
