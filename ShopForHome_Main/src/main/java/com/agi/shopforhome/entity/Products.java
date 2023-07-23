package com.agi.shopforhome.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Swapnil 
 * Modified Date: 24/08/2022
 * Description: Product entity
 *
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="products_table")
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	private String url;
	private String catagory;
	private int quantity;

}
