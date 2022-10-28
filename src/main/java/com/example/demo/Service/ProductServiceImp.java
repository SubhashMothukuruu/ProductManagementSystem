package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.ProductEntity;
import com.example.demo.Exceptions.ProductExceptions;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public ProductEntity createProduct(ProductEntity productEntity) {

		if (productEntity.getProductId() == null) {
			throw new ProductExceptions("PRODUCT_ID CAN'T BE NULL.");
		} else if (productEntity.getProductName() == null) {

			throw new ProductExceptions("PRODCUT_NAME CAN'T BE NULL.");
		}

		else {
			return productRepository.saveAndFlush(productEntity);
		}

	}

	@Transactional
	public ProductEntity updateProduct(ProductEntity productEntity) {

		return productRepository.saveAndFlush(productEntity);

	}

	@Transactional
	public List<ProductEntity> getPrdoucts() {
		return productRepository.findAll();
	}

	@Transactional
	public Boolean deleteProductById(Long productId) {
		Boolean flag = false;
		if(productId == null) {
			throw new ProductExceptions("Product_id can't be null.");
		}else {
			
			ProductEntity productEntity = productRepository.findById(productId).orElse(null);
			productRepository.delete(productEntity);
			return flag;
		}
		
	}

	@Transactional
	public ProductEntity getProductId(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}

}
