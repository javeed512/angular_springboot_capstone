package com.agi.shopforhome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agi.shopforhome.entity.Cart;

/**
 * @author Shubh Sharma
 * Modified Date: 24/08/2022
 * Description: Cart Repository
 *
 */

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	List<Cart> findAllByUserId(Long id);
}