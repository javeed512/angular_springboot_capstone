package com.agi.shopforhome.service;

import java.util.List;

import com.agi.shopforhome.dto.UserDTO;
import com.agi.shopforhome.entity.User;

/**
 * @author Soumyadeep
 * Modified Date: 27/08/2022
 * Description: User service interface
 *
 */

public interface IUserService {
	
	public String addUser(UserDTO userDto);
	
	public List<User> getAllUser();
	
	public String updateUser(UserDTO userDto);
	
	public User getUserById(long id);
	
	public String deleteUser(long id);

}
