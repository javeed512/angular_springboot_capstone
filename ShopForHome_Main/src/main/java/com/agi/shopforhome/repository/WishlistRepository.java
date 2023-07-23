package com.agi.shopforhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agi.shopforhome.entity.Wishlist;
/**
 * @author Soumyadeep
 * Modified Date: 27/08/2022
 * Description: User Repository
 *
 */

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

}
