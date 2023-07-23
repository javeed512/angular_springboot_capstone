package com.agi.shopforhome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vishal
 * Modified Date: 24/08/2022
 * Description: User DTO
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private long id;
	private String name;
	private String email;
	private String password;
	private long phone;
	

}
