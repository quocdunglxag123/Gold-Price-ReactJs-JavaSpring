package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.product.ProductDto;
import com.goldprice.goldprice.dto.product.ProductImgDto;
import com.goldprice.goldprice.dto.product.ProductMaterialDto;
import com.goldprice.goldprice.dto.product.ProductPurityDto;
import com.goldprice.goldprice.dto.product.ProductTypeDto;
import com.goldprice.goldprice.service.product.ProductImgService;
import com.goldprice.goldprice.service.product.ProductMaterialService;
import com.goldprice.goldprice.service.product.ProductPurityService;
import com.goldprice.goldprice.service.product.ProductService;
import com.goldprice.goldprice.service.product.ProductTypeService;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductTypeService productTypeService;
	@Autowired
	private ProductPurityService productPurityService;
	@Autowired
	private ProductMaterialService productMaterialService;
	@Autowired
	private ProductImgService productImgService;

	@PostMapping("/product")
	@PreAuthorize("hasAuthority('customer')")
	public DataResponse product(@RequestBody ProductDto productDto) {
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

	@PostMapping("/productPurity")
	public DataResponse productPurity(@RequestBody ProductPurityDto productPurityDto) {
		if (productPurityDto.getServiceCall().equals("add")) {
			// Case: Add Product Purity By productPurityDto property
			return new DataResponse(productPurityService.addProductPurity(productPurityDto));
		} else if (productPurityDto.getServiceCall().equals("get")) {
			// Case: Get One Product Purity By productPurityDto property
			return new DataResponse(productPurityService.getProductPurity(productPurityDto));
		} else if (productPurityDto.getServiceCall().equals("getAll")) {
			// Case: Get All Product Purity
			return new DataResponse(productPurityService.getAllProductPurity());
		} else if (productPurityDto.getServiceCall().equals("update")) {
			// Case: Update Product Purity By productPurityDto property
			return new DataResponse(productPurityService.updateProductPurity(productPurityDto));
		} else if (productPurityDto.getServiceCall().equals("delete")) {
			// Case: Delete Product Purity By productPurityDto property
			return new DataResponse(productPurityService.deleteProductPurity(productPurityDto));
		}

		return new DataResponse("500", "Method Not Found");
	}

	@PostMapping("/productType")
	public DataResponse productType(@RequestBody ProductTypeDto productTypeDto) {
		if (productTypeDto.getServiceCall().equals("add")) {
			// Case: Add Product Type By productTypeDto property
			return new DataResponse(productTypeService.addProductType(productTypeDto));
		} else if (productTypeDto.getServiceCall().equals("get")) {
			// Case: Get One Product Type By productTypeDto property
			return new DataResponse(productTypeService.getProductType(productTypeDto));
		} else if (productTypeDto.getServiceCall().equals("getAll")) {
			// Case: Get All Product Type
			return new DataResponse(productTypeService.getAllProductType());
		} else if (productTypeDto.getServiceCall().equals("update")) {
			// Case: Update Product Type By productTypeDto property
			return new DataResponse(productTypeService.updateProductType(productTypeDto));
		} else if (productTypeDto.getServiceCall().equals("delete")) {
			// Case: Delete Product Type By productTypeDto property
			return new DataResponse(productTypeService.deleteProductType(productTypeDto));
		}

		return new DataResponse("500", "Method Not Found");
	}

	@PostMapping("/productMaterial")
	public DataResponse productMaterial(@RequestBody ProductMaterialDto productMaterialDto) {
		if (productMaterialDto.getServiceCall().equals("add")) {
			// Case: Add Product Material By productMaterialDto property
			return new DataResponse(productMaterialService.addProductMaterial(productMaterialDto));
		} else if (productMaterialDto.getServiceCall().equals("get")) {
			// Case: Get One Product Material By productMaterialDto property
			return new DataResponse(productMaterialService.getProductMaterial(productMaterialDto));
		} else if (productMaterialDto.getServiceCall().equals("getAll")) {
			// Case: Get All Product Material
			return new DataResponse(productMaterialService.getAllProductMaterial());
		} else if (productMaterialDto.getServiceCall().equals("update")) {
			// Case: Update Product Material By productMaterialDto property
			return new DataResponse(productMaterialService.updateProductMaterial(productMaterialDto));
		} else if (productMaterialDto.getServiceCall().equals("delete")) {
			// Case: Delete Product Material By productMaterialDto property
			return new DataResponse(productMaterialService.deleteProductMaterial(productMaterialDto));
		}

		return new DataResponse("500", "Method Not Found");
	}
	
	@PostMapping("/productImg")
	public DataResponse productImg(@RequestBody ProductImgDto productImgDto) {
		if (productImgDto.getServiceCall().equals("add")) {
			// Case: Add Product Img By ProductImgDto property
			return new DataResponse(productImgService.addProductImg(productImgDto));
		} else if (productImgDto.getServiceCall().equals("get")) {
			// Case: Get One Product Img By ProductImgDto property
			return new DataResponse(productImgService.getProductImg(productImgDto));
		} else if (productImgDto.getServiceCall().equals("getAll")) {
			// Case: Get All Product Img
			return new DataResponse(productImgService.getAllProductImg());
		} else if (productImgDto.getServiceCall().equals("update")) {
			// Case: Update Product Img By ProductImgDto property
			return new DataResponse(productImgService.updateProductImg(productImgDto));
		} else if (productImgDto.getServiceCall().equals("delete")) {
			// Case: Delete Product Img By ProductImgDto property
			return new DataResponse(productImgService.deleteProductImg(productImgDto));
		}
		return new DataResponse("500", "Method Not Found");
	}

}
