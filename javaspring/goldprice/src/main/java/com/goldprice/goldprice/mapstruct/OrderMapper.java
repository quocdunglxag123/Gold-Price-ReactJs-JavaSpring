package com.goldprice.goldprice.mapstruct;

import com.goldprice.goldprice.dto.order.OrderDto;
import com.goldprice.goldprice.entity.order.OrderEntity;

public interface OrderMapper {
	// ----------------------------Order Start---------------------------
	// Entity To DTO
	OrderDto orderEntityToOrderDto(OrderEntity orderEntity);

	// DTO To Entity
	OrderEntity orderDtoToOrderEntity(OrderDto orderDto);
	// ----------------------------Order End---------------------------
}
