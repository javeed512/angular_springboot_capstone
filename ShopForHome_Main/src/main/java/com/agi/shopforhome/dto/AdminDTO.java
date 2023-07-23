package com.agi.shopforhome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vishal
 * Modified Date: 24/08/2022
 * Description: Admin DTO
 *
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
	private long id;
	private String email;
	private String password;

}
