package com.agi.shopforhome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vishal
 * Modified Date: 24/08/2022
 * Description: Wishlist DTO
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDTO {
	private long wid;
	private long uid;
	private long pid;
	public WishlistDTO(long uid, long pid) {
		super();
		this.uid = uid;
		this.pid = pid;
	}
	

}
