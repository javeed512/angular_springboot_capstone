package com.agi.shopforhome.service;

import java.util.List;

import com.agi.shopforhome.entity.Cart;

/**
 * @author Soumyadeep
 * Modified Date: 27/08/2022
 * Description: Cart service interface
 *
 */

public interface IcartService {
	public Cart addToCart(Cart cart);
	
	public List<Cart> getAllByUserCart(long id);
	
	public void deleteCart(long id);
	
	public void updateCart(Cart cart,long cid);

}
