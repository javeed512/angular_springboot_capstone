package com.agi.shopforhome.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agi.shopforhome.dto.WishlistDTO;
import com.agi.shopforhome.entity.Wishlist;
import com.agi.shopforhome.repository.WishlistRepository;
import com.agi.shopforhome.service.IWishlistService;

/**
 * @author  hakeem
 * Modified Date: 28-08-2022
 * Description:Wishlist service class
 * 
 *
 */

@Service
public class WishlistServiceImp implements IWishlistService {
	
	@Autowired
	private WishlistRepository repo;
	

	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to add wishlist
	 * Return Type:Wishlist object
	 * Params: WishlistDTO object
	 */	

	@Override
	public Wishlist addToWishList(WishlistDTO dto) {
		Wishlist list=new Wishlist();
		list.setPid(dto.getPid());
		list.setUid(dto.getUid());
		
		return repo.save(list);
	}

	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to get wishlist
	 * Return Type: list of wishlist objects
	 * Params: NA
	 */	

	@Override
	public List<Wishlist> getAllwishlist() {
		
		return repo.findAll();
	}

	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to get wishlist of a user
	 * Return Type: List of wishlist object
	 * Params: long user id
	 */	

	@Override
	public List<Wishlist> getAllDataWithSameUserId(long uid) {
		// TODO Auto-generated method stub
		List<Wishlist> userProductList=new ArrayList<>();
		List<Wishlist> mainList=this.getAllwishlist();
		for(Wishlist a: mainList) {
			if(a.getUid()==uid) {
				userProductList.add(a);
			}
		}
		
		
		return userProductList;
	}

	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to delete wishlist
	 * Return Type: String
	 * Params: long uid and pid
	 */	

	@SuppressWarnings("deprecation")
	@Override
	public String deleteByUserIdAndProdId(long uid, long pid) {
		List<Wishlist> userProductListToDelete=new ArrayList<>();
		List<Wishlist> mainList=this.getAllwishlist();
		for(Wishlist a: mainList) {
			if(a.getUid()==uid && a.getPid()==pid) {
				userProductListToDelete.add(a);
			}
		}
		repo.deleteInBatch(userProductListToDelete);
		
		
		return "data deleted";
	}
	

}
