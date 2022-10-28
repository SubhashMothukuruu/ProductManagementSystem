package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.ProductEntity;

@Service
public interface ProductService {

	public ProductEntity createProduct(ProductEntity productEntity);
	
	public ProductEntity updateProduct(ProductEntity productEntity);
	
	
	public List<ProductEntity> getPrdoucts();
	
	public Boolean deleteProductById(Long productId);

	public ProductEntity getProductId(Long productId);
}
