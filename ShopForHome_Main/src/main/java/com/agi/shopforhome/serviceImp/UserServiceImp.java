package com.agi.shopforhome.serviceImp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agi.shopforhome.dto.UserDTO;
import com.agi.shopforhome.entity.User;
import com.agi.shopforhome.repository.UserRepository;
import com.agi.shopforhome.service.IUserService;

/**
 * @author  hakeem
 * Modified Date: 28-08-2022
 * Description:user service class
 * 
 *
 */

@Service
public class UserServiceImp implements IUserService {
	
	@Autowired
	private UserRepository repo;
	
	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to add users
	 * Return Type: String
	 * Params: UserDTO object
	 */	

	@Override
	public String addUser(UserDTO userDto) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setPhone(userDto.getPhone());
		repo.save(user);
			return "New User Registered";
		
		
	}
	

	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to get list of user
	 * Return Type: List of User
	 * Params:NA
	 */	

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to add admin
	 * Return Type: String
	 * Params: UserDTO object
	 */	

	@Override
	public String updateUser(UserDTO userDto) {
		// TODO Auto-generated method stub
		User userToUpdate=new User();
		userToUpdate.setId(userDto.getId());
		userToUpdate.setEmail(userDto.getEmail());
		userToUpdate.setName(userDto.getName());
		userToUpdate.setPhone(userDto.getPhone());
		userToUpdate.setPassword(userDto.getPassword());
		
		repo.save(userToUpdate);
		
		return "User Updated Successfully";
	}

	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to delete admin
	 * Return Type: String
	 * Params: long id
	 */	

	@Override
	public String deleteUser(long id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);
		return "User deleted";
	}
	

	/**
	 * @author  hakeem
	 * Modified Date: 28-08-2022
	 * Description: to get user by id
	 * Return Type: SUser object
	 * Params: long id
	 */	

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		
		return repo.findById(id).get();
	}

}
