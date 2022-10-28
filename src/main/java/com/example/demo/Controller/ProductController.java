package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.ProductEntity;
import com.example.demo.Service.ProductService;

@RestController
public class ProductController  {
	
	@Autowired
	ProductService productService;
	
	
	
	@PostMapping("/create")
	public String createProduct(@ModelAttribute ("product") ProductEntity product) {
		productService.createProduct(product);
		return "redirect:/";
		
	}
	
	@GetMapping("/showNewProduct")
	public String showNewProduct(Model model) {
		ProductEntity product = new ProductEntity();
		model.addAttribute("product", product);
		return "create";
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestParam Long prdouctId, Model model) {
		
		ProductEntity product = productService.getProductId(prdouctId);
		model.addAttribute("product",product);
		return "modify";
	}
	

	
	@GetMapping({"/", "/home"})
	public String showAllProducts(Model model){
		
		List<ProductEntity> prodcutList= productService.getPrdoucts();
		
		model.addAttribute("prodcutList", prodcutList);
		return "home";
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteById(@RequestParam Long productId) {
		 productService.deleteProductById(productId);
		 return "redirect:/";
	}
	
	
	

}
