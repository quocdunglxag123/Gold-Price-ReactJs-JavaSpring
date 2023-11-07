package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.ProductDto;
import com.goldprice.goldprice.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public DataResponse accountLogin(@RequestBody ProductDto productDto) {
		if (productDto.getServiceCall().equals("add")) {
			// Case: Add Product By productDto property
			return new DataResponse(productService.addProduct(productDto));
		} else if (productDto.getServiceCall().equals("get")) {
			// Case: Get One Product By productDto property
			return new DataResponse(productService.getProduct(productDto));
		} else if (productDto.getServiceCall().equals("getAll")) {
			// Case: Get All Products
			return new DataResponse(productService.getAllProducts());
		} else if (productDto.getServiceCall().equals("update")) {
			// Case: Update Product By productDto property
			return new DataResponse(productService.updateProduct(productDto));
		} else if (productDto.getServiceCall().equals("delete")) {
			// Case: Delete Product By productDto property
			return new DataResponse(productService.deleteProduct(productDto));
		}

		return new DataResponse("500", "Method Not Found");

	}

}
