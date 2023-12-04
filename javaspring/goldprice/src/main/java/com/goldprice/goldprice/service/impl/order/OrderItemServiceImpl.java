package com.goldprice.goldprice.service.impl.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.goldprice.goldprice.dto.order.OrderDto;
import com.goldprice.goldprice.dto.order.OrderItemDto;
import com.goldprice.goldprice.entity.order.OrderEntity;
import com.goldprice.goldprice.entity.order.OrderItemEntity;
import com.goldprice.goldprice.entity.product.ProductEntity;
import com.goldprice.goldprice.exception.OrderException;
import com.goldprice.goldprice.mapstruct.OrderItemMapper;
import com.goldprice.goldprice.mapstruct.ProductMapper;
import com.goldprice.goldprice.repository.order.OrderItemRepository;
import com.goldprice.goldprice.repository.order.OrderRepository;
import com.goldprice.goldprice.repository.product.ProductRepository;
import com.goldprice.goldprice.service.order.OrderItemService;
import com.goldprice.goldprice.service.order.OrderService;
import com.goldprice.goldprice.service.product.ProductService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private OrderItemMapper orderItemMapper;

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	ProductMapper productMapper;

	/**
	 * Get OrderItem
	 * 
	 * @param orderItemDto OrderItemDto contains information about an orderItem to
	 *                     get
	 * 
	 * @return orderItemDto Object contains information about an orderItem in
	 *         database
	 */
	@Override
	public Object getOrderItem(OrderItemDto orderItemDto) {
		OrderItemEntity orderItemEntity = orderItemRepository.findOneById(orderItemDto.getId());
		return orderItemMapper.orderItemEntityToOrderItemDto(orderItemEntity);
	}

	/**
	 * Add OrderItem
	 * 
	 * @param orderItemDto OrderItemDto contains information about an orderItem to
	 *                     add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object addOrderItem(OrderItemDto orderItemDto) {
		OrderItemEntity orderItemEntity = orderItemMapper.orderItemDtoToOrderItemEntity(orderItemDto);

		// Get Product To Add
		ProductEntity productEntity = productRepository.findOneById(orderItemEntity.getProductEntity().getId());
		// Get Order To Add
		OrderEntity orderEntity = orderRepository.findOneById(orderItemDto.getOrderDto().getId());

		// Check Quantity Of OrderItem Is More Than Product In Stock
		int inStockNew = productEntity.getInStock() - orderItemEntity.getQuantity();
		if (inStockNew < 0) {
			throw new OrderException("Quantity Is More Than Product In Stock!");
		}

		orderItemEntity.setOrderEntity(orderEntity);
		orderItemEntity.setProductEntity(productEntity);
		orderItemRepository.save(orderItemEntity);

		// When Add New Order Item Then Update Total Price Of Order
		OrderDto orderDto = new OrderDto();
		orderDto.setId(orderItemEntity.getOrderEntity().getId());
		orderService.updateOrder(orderDto);

		// Update InStock Of product
		productEntity.setInStock(inStockNew);
		productService.updateProduct(productMapper.productEntityToProductDto(productEntity));

		return true;
	}

	/**
	 * Update OrderItem
	 * 
	 * @param orderItemDto OrderItemDto contains information about an orderItem to
	 *                     update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object updateOrderItem(OrderItemDto orderItemDto) {
		OrderItemEntity orderItemEntityUpdate = orderItemRepository.findOneById(orderItemDto.getId());
		boolean flagAutoCaculateInStock = false;

		if (orderItemEntityUpdate != null) {
			// Case: OrderItem is in database
			if (orderItemDto.getSubtotal() != null) {
				orderItemEntityUpdate.setSubTotal(orderItemDto.getSubtotal());
				// When Update Order Item Then Update Total Price Of Order
				OrderDto orderDto = new OrderDto();
				orderDto.setId(orderItemEntityUpdate.getOrderEntity().getId());
				orderService.updateOrder(orderDto);
			}

			if (orderItemDto.getQuantity() >= 0) {
				ProductEntity productEntity = productRepository
						.findOneById(orderItemEntityUpdate.getProductEntity().getId());
				// When Update Order Item Then Update InStock Of product
				int inStockNew = 0;
				if (orderItemEntityUpdate.getQuantity() < orderItemDto.getQuantity()) {
					// increase quantity
					inStockNew = productEntity.getInStock()
							- (orderItemDto.getQuantity() - orderItemEntityUpdate.getQuantity());
					flagAutoCaculateInStock = true;
				}

				if (orderItemEntityUpdate.getQuantity() > orderItemDto.getQuantity()) {
					// decrease quantity
					inStockNew = productEntity.getInStock()
							+ (orderItemDto.getQuantity() - orderItemEntityUpdate.getQuantity());
					flagAutoCaculateInStock = true;
				}

				if (flagAutoCaculateInStock) {
					// When change in quantity then update in stock of Product
					productEntity.setInStock(inStockNew);
					productService.updateProduct(productMapper.productEntityToProductDto(productEntity));
					orderItemEntityUpdate.setQuantity(orderItemDto.getQuantity());
				}
			}

			orderItemRepository.save(orderItemEntityUpdate);

			return true;
		} else {
			throw new OrderException("OrderItem Not Found!");
		}
	}

	/**
	 * Delete OrderItem
	 * 
	 * @param orderItemDto OrderItemDto contains information about an orderItem to
	 *                     delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object deleteOrderItem(OrderItemDto orderItemDto) {
		OrderItemEntity orderItemEntity = orderItemRepository.findOneById(orderItemDto.getId());

		ProductEntity productEntity = productRepository.findOneById(orderItemEntity.getProductEntity().getId());
		int inStockNew = orderItemEntity.getQuantity() + productEntity.getInStock();

		orderItemRepository.deleteById(orderItemDto.getId());

		// When Delete Order Item Then Update Total Price Of Order
		OrderDto orderDto = new OrderDto();
		orderDto.setId(orderItemEntity.getOrderEntity().getId());
		orderService.updateOrder(orderDto);

		// When Delete Order Item Thne Update InStock Of product
		productEntity.setInStock(inStockNew);
		productService.updateProduct(productMapper.productEntityToProductDto(productEntity));

		return true;
	}

}
