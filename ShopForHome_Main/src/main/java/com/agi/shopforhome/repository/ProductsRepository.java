package com.agi.shopforhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agi.shopforhome.entity.Products;

/**
 * @author Shubh Sharma
 * Modified Date: 24/08/2022
 * Description: Product Repository
 *
 */

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}
