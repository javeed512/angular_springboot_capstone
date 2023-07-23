package com.agi.shopforhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agi.shopforhome.entity.Cart;
import com.agi.shopforhome.entity.Products;
import com.agi.shopforhome.entity.User;
import com.agi.shopforhome.service.IProductsService;
import com.agi.shopforhome.service.IUserService;
import com.agi.shopforhome.service.IcartService;

/**

 * Description: Cart Rest Controller
 *
 */

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private IcartService service;

	@Autowired
	private IUserService userService;

	@Autowired
	private IProductsService productService;

	@GetMapping("getall/{userId}")
	public List<Cart> getCart(@PathVariable long userId) {
		return service.getAllByUserCart(userId);
	}

	@GetMapping("/add/{productId}/{userId}")
	public ResponseEntity<Cart> addCart(@PathVariable long productId,@PathVariable long userId) {

		Products product = productService.getProductById(productId);
		User user = userService.getUserById(userId);
		Cart cart = new Cart(user, product);
		cart.setUnit(1);
		cart.setTotalPrice(cart.getUnit()*product.getPrice());
		Cart addCart = service.addToCart(cart);
		return new ResponseEntity<Cart>(addCart, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<?> deletCart(@PathVariable long cartId) {

		service.deleteCart(cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update-cart/{cid}")
	public void updateCart(@RequestBody Cart cart, @PathVariable long cid) {
		service.updateCart(cart, cid);
		
	}
}
