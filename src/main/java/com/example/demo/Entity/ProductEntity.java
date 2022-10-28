package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODCUT_DETAILS")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="PRODCUT_ID")
	private Long productId;
	@Column(name ="PRODUCT_NAME")
	private String productName;
	@Column(name ="PRODUCT_DESCRIPTION")
	private String productDescription;
	@Column(name ="PRODUCT_COST")
	private Long prodcutCost;
	@Column(name ="COMPANY_BRAND")
	private String companyBrand;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Long getProdcutCost() {
		return prodcutCost;
	}
	public void setProdcutCost(Long prodcutCost) {
		this.prodcutCost = prodcutCost;
	}
	public String getCompanyBrand() {
		return companyBrand;
	}
	public void setCompanyBrand(String companyBrand) {
		this.companyBrand = companyBrand;
	}
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public ProductEntity() {
		super();
	}
	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", prodcutCost=" + prodcutCost + ", companyBrand=" + companyBrand + "]";
	}
	public ProductEntity(Long productId, String productName, String productDescription, Long prodcutCost,
			String companyBrand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.prodcutCost = prodcutCost;
		this.companyBrand = companyBrand;
	}
	
	
	
	

}
