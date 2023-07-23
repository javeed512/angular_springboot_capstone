package com.agi.shopforhome.serviceImp;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.agi.shopforhome.dto.ProductsDTO;
import com.agi.shopforhome.serviceImp.ProductsServiceImp;

import java.util.List;

class ProductsServiceImpTest {
	@SuppressWarnings("unused")
	@Autowired
	private ProductsServiceImp service;

	@Test
	void testAddProducts() {
		ProductsDTO productsDTO =new ProductsDTO(1,"One Plus 9 RT",42000,"onePlus.png","Mobiles",25);
		String addedProducts = service.addProducts(productsDTO);
		assertNotNull(addedProducts);
	}

	@Test
	void testGetAllProducts() {
		List list = service.getAllProducts();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	void testGetSortedProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateProducts() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteProducts() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProductById() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveMultiple() {
		fail("Not yet implemented");
	}

}
