package com.agi.shopforhome.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agi.shopforhome.dto.ProductsDTO;
import com.agi.shopforhome.entity.Products;
import com.agi.shopforhome.helper.Helper;
import com.agi.shopforhome.service.IProductsService;

/**
 * @author Soumyadeep Maji
 * Modified Date: 24/08/2022
 * Description: Products Rest Controller
 *
 */

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200/")
public class ProductsController {
	
	@Autowired
	private IProductsService service;
	
	@PostMapping("/add-product")
	public String addProduct(@RequestBody ProductsDTO dto) {
		return service.addProducts(dto);
		
	}
	
	@GetMapping("/getAll")
	public List<Products> getAllProducts(){
		return service.getAllProducts();
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody ProductsDTO dto) {
		return service.updateProducts(dto);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable long id) {
		return service.deleteProducts(id);
	}
	
	@GetMapping("get-product/{id}")
	public Products getProductById(@PathVariable long id) {
		return service.getProductById(id);

	
}
	@PostMapping("/add-bulk-products")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(Helper.checkExelFormat(file))
		{
			this.service.saveMultiple(file);
			return ResponseEntity.ok(Map.of("message","file is uploaded"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file only");
		
	}
	@GetMapping("/get-sorted-product")
	public List<Products> getSortedProducts(){
		return service.getSortedProduct();
	}
}
