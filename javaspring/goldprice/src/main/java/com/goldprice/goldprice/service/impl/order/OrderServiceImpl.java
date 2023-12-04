package com.goldprice.goldprice.service.impl.order;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.goldprice.goldprice.dto.order.OrderDto;
import com.goldprice.goldprice.entity.order.OrderEntity;
import com.goldprice.goldprice.entity.order.OrderItemEntity;
import com.goldprice.goldprice.entity.order.PaymentOrderEntity;
import com.goldprice.goldprice.entity.order.StatusOrderEntity;
import com.goldprice.goldprice.exception.OrderException;
import com.goldprice.goldprice.mapstruct.OrderMapper;
import com.goldprice.goldprice.repository.order.OrderRepository;
import com.goldprice.goldprice.repository.order.PaymentOrderRepository;
import com.goldprice.goldprice.repository.order.StatusOrderRepository;
import com.goldprice.goldprice.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private StatusOrderRepository statusOrderRepository;
	@Autowired
	private PaymentOrderRepository paymentOrderRepository;

	/**
	 * Get Order
	 * 
	 * @param orderDto OrderDto contains information about an order to get
	 * 
	 * @return orderDto Object contains information about an order in database
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object getOrder(OrderDto orderDto) {
		OrderEntity orderEntity = orderRepository.findOneById(orderDto.getId());

		// Update new Total Price Of Order
		BigDecimal newTotalPrice = getNewTotalPriceOrder(orderEntity);
		orderEntity.setTotalAmount(newTotalPrice);
		orderRepository.save(orderEntity);

		return orderMapper.orderEntityToOrderDto(orderEntity);
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
		throw new OrderException(
				"You cannot create an Order because an Order will be automatically created when you register an account.");
	}

	/**
	 * Update Order
	 * 
	 * @param orderDto OrderDto contains information about an order to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object updateOrder(OrderDto orderDto) {
		OrderEntity orderEntityUpdate = orderRepository.findOneById(orderDto.getId());
		if (orderEntityUpdate != null) {
			// Check And Set Update Status Order
			if (orderDto.getStatusOrderDto() != null) {
				StatusOrderEntity statusOrderEntity = new StatusOrderEntity();
				// Get By Id
				if (orderDto.getStatusOrderDto().getId() != null) {
					statusOrderEntity = statusOrderRepository.findOneById(orderDto.getStatusOrderDto().getId());
				}
				// Get By Name
				if (orderDto.getStatusOrderDto().getName() != null) {
					statusOrderEntity = statusOrderRepository.findByName(orderDto.getStatusOrderDto().getName());
				}
				if (statusOrderEntity == null) {
					throw new OrderException("Status Order Not Found!");
				}

				orderEntityUpdate.setStatusOrderEntity(statusOrderEntity);
			}

			// Check And Set Update Payment Order
			if (orderDto.getPaymentOrderDto() != null) {
				PaymentOrderEntity paymentOrderEntity = new PaymentOrderEntity();
				// Get By Id
				if (orderDto.getPaymentOrderDto().getId() != null) {
					paymentOrderEntity = paymentOrderRepository.findOneById(orderDto.getPaymentOrderDto().getId());
				}
				// Get By Name
				if (orderDto.getPaymentOrderDto().getName() != null) {
					paymentOrderEntity = paymentOrderRepository.findByName(orderDto.getPaymentOrderDto().getName());
				}
				if (paymentOrderEntity == null) {
					throw new OrderException("Payment Order Not Found!");
				}

				orderEntityUpdate.setPaymentOrderEntity(paymentOrderEntity);
			}

			if (orderDto.getShippingAddress() != null) {
				orderEntityUpdate.setShippingAddress(orderDto.getShippingAddress());
			}

			// Get new Total Price Of Order To Update
			// About orderDto.getOrderItemDtos() never use in this function because not
			// permit to update OrderItem In OrderSevice
			BigDecimal newTotalPrice = getNewTotalPriceOrder(orderEntityUpdate);

			orderEntityUpdate.setTotalAmount(newTotalPrice);
			orderRepository.save(orderEntityUpdate);
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

	/**
	 * get New Total Price Order
	 * 
	 * @param orderEntity OrderEntity contains information about an order to
	 *                    Caculater Total Price
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	private BigDecimal getNewTotalPriceOrder(OrderEntity orderEntity) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (OrderItemEntity orderItemEntity : orderEntity.getOrderItemEntities()) {
			totalPrice= totalPrice.add( orderItemEntity.getSubTotal());
		}
		return totalPrice;
	}

}
