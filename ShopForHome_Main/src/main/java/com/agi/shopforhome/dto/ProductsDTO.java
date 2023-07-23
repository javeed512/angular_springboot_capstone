
package com.agi.shopforhome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vishal
 * Modified Date: 24/08/2022
 * Description: Product DTO
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {
	
	private long id;
	private String name;
	private double price;
	private String url;
	private String catagory;
	private int quantity;

}
