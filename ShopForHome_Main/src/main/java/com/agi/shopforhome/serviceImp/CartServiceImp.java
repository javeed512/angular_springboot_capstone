package com.agi.shopforhome.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agi.shopforhome.entity.Cart;
import com.agi.shopforhome.repository.CartRepository;
import com.agi.shopforhome.service.IcartService;


/**
 * @author hakeem
 * Modified Date: 28-08-2022
 * Description:Cart service class
 * 
 *
 */
@Service
public class CartServiceImp implements IcartService {
	
	@Autowired
	private CartRepository repo;
	

	/**
	 * @author hakeem
	 * Modified Date: 29-08-2022
	 * Description: to add cart
	 * Return Type: Cart object
	 * Params:Cart object
	 */	

	@Override
	public Cart addToCart(Cart cart) {
		return repo.save(cart);
	}

	/**
	 * @author hakeem
	 * Modified Date: 29-08-2022
	 * Description: to add admin
	 * Return Type: list of cart
	 * Params: long uid
	 */	

	@Override
	public List<Cart> getAllByUserCart(long id) {
		return repo.findAllByUserId(id);
	}

	/**
	 * @author hakeem
	 * Modified Date: 29-08-2022
	 * Description: to delete cart
	 * Return Type: void
	 * Params: long id
	 */	

	@Override
	public void deleteCart(long id) {
		repo.deleteById(id);

	}
	

	/**
	 * @author hakeem
	 * Modified Date: 29-08-2022
	 * Description: to update cart
	 * Return Type: void
	 * Params: cart object, long id
	 */	

	@Override
	public void updateCart(Cart cart, long cid) {
		// TODO Auto-generated method stub
		Cart updated=repo.findById(cid).get();
		updated=cart;
		repo.save(updated);
		
	}

}
