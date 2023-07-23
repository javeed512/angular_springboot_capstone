package com.agi.shopforhome.service;

import java.util.List;

import com.agi.shopforhome.dto.WishlistDTO;
import com.agi.shopforhome.entity.Wishlist;

/**
 * @author Soumyadeep
 * Modified Date: 27/08/2022
 * Description: Wishlist service interface
 *
 */

public interface IWishlistService {
	
	public Wishlist addToWishList(WishlistDTO dto);
	
	public List<Wishlist> getAllwishlist();
	
	public List<Wishlist> getAllDataWithSameUserId(long uid);
	
	public String deleteByUserIdAndProdId(long uid,long pid);
		
	}


