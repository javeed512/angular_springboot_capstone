package com.agi.shopforhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agi.shopforhome.entity.Admin;

/**
 * @author Shubh Sharma
 * Modified Date: 24/08/2022
 * Description: Wishlist Repository
 *
 */

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
